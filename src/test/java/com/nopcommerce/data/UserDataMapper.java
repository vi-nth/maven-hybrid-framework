package com.nopcommerce.data;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {
	
	public static UserDataMapper getUserData( ) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserData.json"), UserDataMapper.class);

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@JsonProperty("firstname")
	private String firstName;
	
	@JsonProperty("lastname")
	private String lastName;
	
	@JsonProperty("emailAddress")
	private String emailAddress;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("month")
	private String month;
	
	@JsonProperty("year")
	private String year;
	
	@JsonProperty("login")
	private Login login;
	
	static class Login{
		@JsonProperty("username")
		private String username;
		
		@JsonProperty("userpassword")
		private String userPassword;
	}
	
	public String getLoginUsername() {
		return login.username;
		
	}
	
	public String getLoginUserPassword() {
		return login.userPassword;
		
		
	}
	@JsonProperty("subjects")
	public List<Subject> subjects;
	
	public List<Subject> getSubjects(){
		return subjects;
	}
	
	public static class Subject{
		@JsonProperty("name")
		private String name;
		@JsonProperty("point")
		private String point;
		
		public String getName() {
			return name;
		}
		
		public String getPoint() {
			return point;
		}
		
		
	}

	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

}
