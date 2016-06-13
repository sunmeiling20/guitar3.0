package model;

import java.util.HashMap;
import java.util.Map;

public class Guitar {
	
	private String builder;
	private String model;
	private String type;
	private String topwood;
	private String backwood;
	private HashMap properties;
	public Guitar(String builder, String model, String type, String backwood, String topwood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backwood = backwood;
		this.topwood = topwood;
		
	}


	
	

	public Guitar(Map properties) {

		if (properties == null) {
			this.properties = new HashMap();
		} else {
			this.properties = new HashMap(properties);
		}
		// TODO Auto-generated constructor stub
	}



	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	public String getTopwood() {
		return topwood;
	}
	public void setTopwood(String topwood) {
		this.topwood =topwood;
	}
	public String getBackwood() {
		return backwood;
	}
	public void setBackwood(String backwood) {
		this.backwood=backwood;
	}

}
