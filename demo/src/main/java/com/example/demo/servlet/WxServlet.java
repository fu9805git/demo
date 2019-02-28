package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.example.demo.entity.TextMessage;
import com.example.demo.util.CheckUtil;
import com.example.demo.util.MessageUtil;

public class WxServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----------doGet----------------");

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			// 如果校验成功，将得到的随机字符串原路返回
			System.out.println("校验成功");
			out.print(echostr);
		} else {
			System.out.println("校验失败");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----------doPost----------------");
		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		try {

			Map<String, String> map = MessageUtil.xmlToMap(request);

			String ToUserName = map.get("ToUserName");

			String FromUserName = map.get("FromUserName");

			String CreateTime = map.get("CreateTime");

			String MsgType = map.get("MsgType");

			String Content = map.get("Content");

			String MsgId = map.get("MsgId ");

			String message = null;

			if (MsgType.equals(MessageUtil.MESSAGE_TEXT)) {// 判断是否为文本消息类型

				if (Content.equals("1")) {

					message = MessageUtil.initText(ToUserName, FromUserName,

							"即将上线，尽请期待！");

				} else if (Content.equals("2")) {

					message = MessageUtil.initText(ToUserName, FromUserName,

							"来了，老弟");

				} else if (Content.equals("?") || Content.equals("？")) {

					message = MessageUtil.initText(ToUserName, FromUserName,

							MessageUtil.menuText());

				} else {

					message = MessageUtil.initText(ToUserName, FromUserName,

							"请不要乱选");

				}

			} else if (MsgType.equals(MessageUtil.MESSAGE_EVENT)) {// 判断是否为事件类型

				// 从集合中，或许是哪一种事件传入

				String eventType = map.get("Event");

				// 关注事件

				if (eventType.equals(MessageUtil.MESSAGE_SUBSCRIBE)) {

					message = MessageUtil.initText(ToUserName, FromUserName,MessageUtil.menuText());
				}

			}

			System.out.println(message);

			out.print(message);

		} catch (DocumentException e) {

			e.printStackTrace();

		} finally {

			out.close();

		}
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

}
