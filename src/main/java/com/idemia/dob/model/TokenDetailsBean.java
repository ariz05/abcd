package com.idemia.dob.model;

public class TokenDetailsBean {

	private static String accessToken;
	private static String refreshToken;
	
	public static String getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(String accessToken ) {
		TokenDetailsBean.accessToken =accessToken ;
	}

	public static String getRefreshToken() {
		return refreshToken;
	}

	public static void setRefreshToken(String refreshToken) {
		TokenDetailsBean.refreshToken = refreshToken;
	}
	
	
	
}
