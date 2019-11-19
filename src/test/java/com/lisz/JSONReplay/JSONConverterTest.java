package com.lisz.JSONReplay;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lisz.demo.JSONConverter;
import com.lisz.demo.Source;
import com.lisz.demo.Transaction;

public class JSONConverterTest {
	@Test
	public void testToJsonString() {
		Transaction transaction = new Transaction();
		Source source = new Source();
		source.setMethod("card");
		source.setNumber("4242424242424242");
		source.setExpMonth(12);
		transaction.setEmail("tester@example.com");
		transaction.setSource(source);
		
		System.out.println(JSONConverter.toJsonString(transaction));
		//{"email":"tester@example.com","source":{"method":"card","number":"4242424242424242","expMonth":12}}
	}
	
	@Test
	public void testToObject() {
		String jsonString = "{\"email\":\"tester@example.com\",\"source\":{\"method\":\"card\",\"number\":\"4242424242424242\",\"expMonth\":12}}";
		System.out.println(JSONConverter.toObject(jsonString, Transaction.class));
	}
	
	@Test
	public void testEndToEnd() {
		Transaction transaction = new Transaction();
		Source source = new Source();
		source.setMethod("card");
		source.setNumber("4242424242424242");
		source.setExpMonth(12);
		transaction.setEmail("tester@example.com");
		transaction.setSource(source);
		
		Transaction convertedTransaction = JSONConverter.toObject(JSONConverter.toJsonString(transaction), Transaction.class);
		assertEquals(transaction, convertedTransaction);
	}
}
