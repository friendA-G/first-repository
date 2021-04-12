package com.kaikeba.util.wx.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class TokenUtil {

	private static String token;
	private static long oldTime = 0;

	public static String getToken() {
		long newTime = System.currentTimeMillis();
		if (newTime - oldTime >= 7100000) {
			oldTime = newTime;
			try {
				setToken();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return token;
	}


	private static void setToken() throws Exception {
		String appid = "wx6a957ffa237c2d42";
		String secret = "e5fa3c5f5ee90684d3a33db9d5d5786e";
		URL url = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String text = null;
		while((text = br.readLine())!=null) {
			sb.append(text);
		}
		br.close();
		JSONObject obj = new JSONObject(sb.toString());
		token = obj.getString("access_token");
	}
}
