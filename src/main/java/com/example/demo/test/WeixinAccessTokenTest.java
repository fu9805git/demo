package com.example.demo.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.example.demo.entity.AccessToken;
import com.example.demo.util.WeixinUtil;

public class WeixinAccessTokenTest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		AccessToken token = WeixinUtil.getAccessToken();
		System.out.println("token:"+token.getToken());
		System.out.println("expires:"+token.getExpiresIn());
	}
}
