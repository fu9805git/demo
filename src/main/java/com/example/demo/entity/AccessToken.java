package com.example.demo.entity;

public class AccessToken {
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expireIn) {
		this.expiresIn = expireIn;
	}
	private String token;
	private int expiresIn;
}
