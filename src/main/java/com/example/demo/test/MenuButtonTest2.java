package com.example.demo.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.example.demo.entity.AccessToken;
import com.example.demo.util.WeixinUtil;

import net.sf.json.JSONObject;

public class MenuButtonTest2 {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		AccessToken token = WeixinUtil.getAccessToken();	
		System.out.println("Access_Token为:"+token.getToken());
		System.out.println("有效时间为："+token.getExpiresIn());
		String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
		System.out.println("创建的菜单为："+menu);
		String[] result = WeixinUtil.createMenu(token.getToken(), menu);
		if(result[0].equals("0")){
			System.out.println("菜单创建成功！"+result[1]);
		} else {
			System.out.println("菜单创建失败！"+result[1]);
		}
	}
	
}
