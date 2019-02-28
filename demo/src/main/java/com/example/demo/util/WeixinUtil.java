package com.example.demo.util;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.demo.entity.AccessToken;
import com.example.demo.entity.Button;
import com.example.demo.entity.ClickButton;
import com.example.demo.entity.MenuButton;
import com.example.demo.entity.ViewButton;

import net.sf.json.JSONObject;

public class WeixinUtil {
	// 从微信后台拿到APPID和APPSECRET 并封装为常量
	private static final String APPID = "wx2985904847296611";
	private static final String APPSECRET = "eeb897d02fe9e7f428b2483d861e825b";
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	/**
	 * 编写Get请求的方法。但没有参数传递的时候，可以使用Get请求
	 * 
	 * @param url 需要请求的URL
	 * @return 将请求URL后返回的数据，转为JSON格式，并return
	 */
	public static JSONObject doGetStr(String url) throws ClientProtocolException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();// 获取DefaultHttpClient请求
		HttpGet httpGet = new HttpGet(url);// HttpGet将使用Get方式发送请求URL
		JSONObject jsonObject = null;
		HttpResponse response = client.execute(httpGet);// 使用HttpResponse接收client执行httpGet的结果
		HttpEntity entity = response.getEntity();// 从response中获取结果，类型为HttpEntity
		if (entity != null) {
			String result = EntityUtils.toString(entity, "UTF-8");// HttpEntity转为字符串类型
			jsonObject = JSONObject.fromObject(result);// 字符串类型转为JSON类型
		}
		return jsonObject;
	}

	/**
	 * 编写Post请求的方法。当我们需要参数传递的时候，可以使用Post请求
	 * 
	 * @param url    需要请求的URL
	 * @param outStr 需要传递的参数
	 * @return 将请求URL后返回的数据，转为JSON格式，并return
	 */
	public static JSONObject doPostStr(String url, String outStr) throws ClientProtocolException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();// 获取DefaultHttpClient请求
		HttpPost httpost = new HttpPost(url);// HttpPost将使用Get方式发送请求URL
		JSONObject jsonObject = null;
		httpost.setEntity(new StringEntity(outStr, "UTF-8"));// 使用setEntity方法，将我们传进来的参数放入请求中
		HttpResponse response = client.execute(httpost);// 使用HttpResponse接收client执行httpost的结果
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");// HttpEntity转为字符串类型
		jsonObject = JSONObject.fromObject(result);// 字符串类型转为JSON类型
		return jsonObject;
	}

	/**
	 * 获取AccessToken
	 * 
	 * @return 返回拿到的access_token及有效期
	 */
	public static AccessToken getAccessToken() throws ClientProtocolException, IOException {
		AccessToken token = new AccessToken();
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);// 将URL中的两个参数替换掉
		JSONObject jsonObject = doGetStr(url);// 使用刚刚写的doGet方法接收结果
		if (jsonObject != null) { // 如果返回不为空，将返回结果封装进AccessToken实体类
			token.setToken(jsonObject.getString("access_token"));// 取出access_token
			token.setExpiresIn(jsonObject.getInt("expires_in"));// 取出access_token的有效期
		}
		return token;
	}

	/**
	 * 
	 * 组装菜单
	 * 
	 * @return
	 * 
	 */

	public static MenuButton initMenu() {

//		MenuButton menu = new MenuButton();

//		ClickButton button11 = new ClickButton();
//		button11.setName("了解杰瑞教育");
//		button11.setType("click");
//		button11.setKey("11");
//
//		ClickButton button12 = new ClickButton();
//		button12.setName("加入杰瑞教育");
//		button12.setType("click");
//		button12.setKey("12");
//
//		ViewButton button21 = new ViewButton();
//		button21.setName("杰瑞教育官网");
//		button21.setType("view");
//		button21.setUrl("https://time.geekbang.org/?category=1&sort=1&order=sort");
//
//		ViewButton button22 = new ViewButton();
//		button22.setName("杰瑞教育新闻网");
//		button22.setType("view");
//		button22.setUrl("http://www.jredu100.com");
//
//		ClickButton button31 = new ClickButton();
//		button31.setName("我");
//		button31.setType("click");
//		button31.setKey("31");
//
//		Button button1 = new Button();
//		button1.setName("发现"); // 将11/12两个button作为二级菜单封装第一个一级菜单
//		button1.setSub_button(new Button[] { button11, button12 });
		
//		Button button2 = new Button();
//		button2.setName("课堂"); // 将21/22两个button作为二级菜单封装第二个二级菜单
//		button2.setSub_button(new Button[] { button21, button22 });
//
//		menu.setButton(new Button[] { button1, button2, button31 });// 将31Button直接作为一级菜单

//		return menu;
		
		MenuButton menu = new MenuButton();
		ViewButton button1 = new ViewButton();
		button1.setName("发现"); 
		button1.setType("view");
		button1.setUrl("https://www.geekbang.org");
		
		ViewButton button2 = new ViewButton();
		button2.setName("课堂"); 
		button2.setType("view");
		button2.setUrl("https://time.geekbang.org/?category=1&sort=1&order=sort");
		
		ViewButton button3 = new ViewButton();
		button3.setName("我"); 
		button3.setType("view");
		button3.setUrl("https://jinshuju.net/f/7y04KD");
		
		menu.setButton(new Button[] { button2, button3 });// 将31Button直接作为一级菜单
		return menu;

	}

	public static String[] createMenu(String token,String menu) throws ClientProtocolException, IOException {

	String [] result = new String[2];
	String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
	JSONObject jsonObject = doPostStr(url, menu);
	if(jsonObject != null){
	result[1] = jsonObject.getString("errmsg");
	result[0] = String.valueOf(jsonObject.getInt("errcode"));
	}
	return result;
	}
}
