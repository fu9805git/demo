package com.example.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.example.demo.entity.TextMessage;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	/**
	 * 
	 * 新建方法，将接收到的XML格式，转化为Map对象
	 * 
	 * @param request 将request对象，通过参数传入
	 * 
	 * @return 返回转换后的Map对象
	 * 
	 */

	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_SHORTVIDEO = "shortvideo";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCAN = "SCAN";

	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {

		Map<String, String> map = new HashMap<String, String>();

		// 从dom4j的jar包中，拿到SAXReader对象。

		SAXReader reader = new SAXReader();

		InputStream is = request.getInputStream();// 从request中，获取输入流

		Document doc = reader.read(is);// 从reader对象中,读取输入流

		Element root = doc.getRootElement();// 获取XML文档的根元素

		List<Element> list = root.elements();// 获得根元素下的所有子节点

		for (Element e : list) {

			map.put(e.getName(), e.getText());// 遍历list对象，并将结果保存到集合中

		}

		is.close();

		return map;

	}

	/**
	 * 
	 * 将文本消息对象转化成XML格式
	 * 
	 * @param message 文本消息对象
	 * 
	 * @return 返回转换后的XML格式
	 * 
	 */

	public static String textMessageToXml(TextMessage message) {

		XStream xs = new XStream();

		// 由于转换后xml根节点默认为class类，需转化为<xml>

		xs.alias("xml", message.getClass());

		return xs.toXML(message);

	}
	
	/**

	 * 拼接关注主菜单

	 */

	public static String menuText(){

	StringBuffer sb = new StringBuffer();

	sb.append("欢迎关注金牛汇公众号，请选择:\n\n");

	sb.append("1、新手扫盲。\n");

	sb.append("2、那些“股”事。\n\n");

	sb.append("回复？调出主菜单。\n\n");

	return sb.toString();

	}

	/**

	 * 初始化回复消息

	 */

	public static String initText(String toUSerName,String fromUserName,String content){

	TextMessage text = new TextMessage();

	text.setFromUserName(toUSerName);

	text.setToUserName(fromUserName);

	text.setMsgType(MESSAGE_TEXT);

	text.setCreateTime(new Date().getTime()+"");

	text.setContent(content);

	return MessageUtil.textMessageToXml(text);

	}
}
