package com.kaikeba.util.wx;

import com.kaikeba.util.wx.util.SignatureUtil;
import com.kaikeba.util.wx.util.TicketUtil;
import com.kaikeba.util.wx.util.TokenUtil;
import org.junit.Test;


public class TokenTest {

	@Test
	public void test1() throws Exception {
		String token1 = TokenUtil.getToken();
		System.out.println(token1);
		token1 = TokenUtil.getToken();
		System.out.println(token1);
		token1 = TokenUtil.getToken();
		System.out.println(token1);
		token1 = TokenUtil.getToken();
		System.out.println(token1);
	}
	@Test
	public void test2() throws Exception {
		String ticket = TicketUtil.getTicket();
		System.out.println(ticket);
		ticket = TicketUtil.getTicket();
		System.out.println(ticket);
		ticket = TicketUtil.getTicket();
		System.out.println(ticket);
	}
	@Test
	public void test3() throws Exception {
		String s = SignatureUtil.getConfig("http://friend.kaikeba.cn/pickExpress.html").toJSON();
		System.out.println(s);
	}
}
