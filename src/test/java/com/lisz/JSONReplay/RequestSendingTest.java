package com.lisz.JSONReplay;

import org.junit.Test;

import com.lisz.demo.StripeAPIClient;

public class RequestSendingTest {

	@Test
	public void testGet() throws Exception {
		StripeAPIClient client = new StripeAPIClient();
        String respString = client.call("http://www.amazon.com");
        System.out.println(respString);
	}

	@Test
	public void testPost() throws Exception {
		StripeAPIClient client = new StripeAPIClient();
        String respString = client.call("http://www.amazon.com");
        System.out.println(respString);
	}
	
}
