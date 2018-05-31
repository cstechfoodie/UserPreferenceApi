package io.swagger.controller;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

public class ClientApiControllerTest {

	private static String url = "http://localhost:8080/client";

	private static HttpClient client = new HttpClient();
	
	
	@Test
	public void getClientByIdtest_1() {
		// Renew the instance of HttpClient.
		client = new HttpClient();

		// relative path to test {"uuid":"3"}
		GetMethod method = new GetMethod(url + "/3");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);
			
			//JUnit Assertion
			assertEquals(200, statusCode, 0.0);
			
			//HttpClient Logging
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}

			// Read the response body.
			InputStream responseBody = method.getResponseBodyAsStream();

			String result = new BufferedReader(new InputStreamReader(responseBody)).lines()
					.collect(Collectors.joining("\n"));
			System.out.println(result);

		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Release the connection.
			method.releaseConnection();
		}
	}
	
	

	@Test
	public void getClientByIdtest_2() {
		// Renew the instance of HttpClient.
		client = new HttpClient();

		// relative path to test {"uuid":"ggg"}
		GetMethod method = new GetMethod(url + "/ggg");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);
			
			//JUnit Assertion
			assertEquals(404, statusCode, 0.0);
			
			//HttpClient Logging
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}

			// Read the response body.
			InputStream responseBody = method.getResponseBodyAsStream();

			String result = new BufferedReader(new InputStreamReader(responseBody)).lines()
					.collect(Collectors.joining("\n"));
			System.out.println(result);

		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Release the connection.
			method.releaseConnection();
		}
	}

}
