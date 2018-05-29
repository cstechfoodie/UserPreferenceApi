package io.swagger.model;

import java.io.Serializable;
import java.util.Map;

public class ClientAction implements Serializable{

	private String id;
	
	private String name;
	
	private String landing;
	
	private String type;
	
	private Map<String, String> param;
	
	private String jsCall;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the landing
	 */
	public String getLanding() {
		return landing;
	}

	/**
	 * @param landing the landing to set
	 */
	public void setLanding(String landing) {
		this.landing = landing;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the param
	 */
	public Map<String, String> getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(Map<String, String> param) {
		this.param = param;
	}

	/**
	 * @return the jsCall
	 */
	public String getJsCall() {
		return jsCall;
	}

	/**
	 * @param jsCall the jsCall to set
	 */
	public void setJsCall(String jsCall) {
		this.jsCall = jsCall;
	}
	
	

}
