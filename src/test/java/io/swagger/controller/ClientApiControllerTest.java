package io.swagger.controller;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

import com.google.gson.Gson;

import io.swagger.model.ClientAction;

public class ClientApiControllerTest {

	private static String url = "http://localhost:8080/client";

	private static HttpClient client = new HttpClient();

	@Test
	public void getClientByIdTest_1() {
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

			// JUnit Assertion
			assertEquals(200, statusCode, 0.0);

			// HttpClient Logging
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
	public void getClientByIdTest_2() {
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

			// JUnit Assertion
			assertEquals(404, statusCode, 0.0);

			// HttpClient Logging
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
	public void addActionToClientTest_1() {

		client = new HttpClient();
		PostMethod method = new PostMethod(url + "/3");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		ClientAction action = new ClientAction();
		action.setId("100");
		action.setJsCall("onclick = function(100)");
		action.setLanding("landing.html");

		Gson gson = new Gson();
		String input = gson.toJson(action);

		method.setRequestBody(input);
		try {
			int statusCode = client.executeMethod(method);

			// JUnit Assertion
			assertEquals(200, statusCode, 0.0);

			// HttpClient Logging
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
	public void addActionToClientTest_2() {

		client = new HttpClient();
		PostMethod method = new PostMethod(url + "/3");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		// method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		ClientAction action = new ClientAction();
		action.setId("101");
		action.setJsCall("onclick = function(101)");
		action.setLanding("landing.html");

		Gson gson = new Gson();
		String input = gson.toJson(action);

		method.setRequestBody(input);
		try {
			int statusCode = client.executeMethod(method);

			// JUnit Assertion
			assertEquals(501, statusCode, 0.0);

			// HttpClient Logging
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
	public void getActionByIdTest_1() {
		// Renew the instance of HttpClient.
		client = new HttpClient();

		// relative path to test
		GetMethod method = new GetMethod(url + "/3/recent/80");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			// JUnit Assertion
			assertEquals(200, statusCode, 0.0);

			// HttpClient Logging
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
	public void getActionByIdTest_2() {
		// Renew the instance of HttpClient.
		client = new HttpClient();

		// relative path to test
		GetMethod method = new GetMethod(url + "/3/recent/notfound90");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			// JUnit Assertion
			assertEquals(404, statusCode, 0.0);

			// HttpClient Logging
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
	public void deleteActionByIdTest_1() {
		// Renew the instance of HttpClient.
		client = new HttpClient();

		// relative path to test
		DeleteMethod method = new DeleteMethod(url + "/3/recent/100");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			// JUnit Assertion
			assertEquals(200, statusCode, 0.0);

			// HttpClient Logging
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
	public void getAllActionsTest_1() {
		// Renew the instance of HttpClient.
		client = new HttpClient();

		// relative path to test
		GetMethod method = new GetMethod(url + "/3/recents");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			// JUnit Assertion
			assertEquals(200, statusCode, 0.0);

			// HttpClient Logging
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
	public void addBatchActionsToClientTest_1() {

		client = new HttpClient();
		PostMethod method = new PostMethod(url + "/3/recents");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		ClientAction action1 = new ClientAction();
		action1.setId("200");
		action1.setJsCall("onclick = function(200)");
		action1.setLanding("landing.html");

		ClientAction action2 = new ClientAction();
		action2.setId("300");
		action2.setJsCall("onclick = function(300)");
		action2.setLanding("landing.html");

		ArrayList<ClientAction> actions = new ArrayList<ClientAction>();
		actions.add(action1);
		actions.add(action2);

		Gson gson = new Gson();
		String input = gson.toJson(actions);
		method.setRequestBody(input);

		try {
			int statusCode = client.executeMethod(method);

			// JUnit Assertion
			assertEquals(200, statusCode, 0.0);

			// HttpClient Logging
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
	public void addBatchActionsToClientTest_2() {

		client = new HttpClient();
		PostMethod method = new PostMethod(url + "/3/recents");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		// method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		ClientAction action1 = new ClientAction();
		action1.setId("200");
		action1.setJsCall("onclick = function(400)");
		action1.setLanding("landing.html");

		ClientAction action2 = new ClientAction();
		action2.setId("300");
		action2.setJsCall("onclick = function(500)");
		action2.setLanding("landing.html");

		ArrayList<ClientAction> actions = new ArrayList<ClientAction>();
		actions.add(action1);
		actions.add(action2);

		Gson gson = new Gson();
		String input = gson.toJson(actions);
		method.setRequestBody(input);

		try {
			int statusCode = client.executeMethod(method);

			// JUnit Assertion
			assertEquals(501, statusCode, 0.0);

			// HttpClient Logging
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
	public void deleteAllActionsTest_1() {
		// Renew the instance of HttpClient.
		client = new HttpClient();

		// relative path to test
		DeleteMethod method = new DeleteMethod(url + "/2/recents");

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		// method.setRequestHeader("Accept", "application/json");
		method.setRequestHeader("Content-type", "application/json");

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			// JUnit Assertion
			assertEquals(200, statusCode, 0.0);

			// HttpClient Logging
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
