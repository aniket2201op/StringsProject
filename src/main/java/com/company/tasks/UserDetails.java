package com.company.tasks;

import org.bson.Document;
import org.json.JSONObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserDetails {
	private long userId;
	private String userName;
	private String firstName;;
	private String lastName;
	private String gender;
	private String dob;
	private String country;
	private int mobile;
	private boolean validated;
	public static String name;
	
	public UserDetails() {
		
	}
	
	public void init() {
		this.userName = "";
		this.firstName = "";
		this.lastName = "";
		this.gender = "";
		this.dob = "";
		this.country = "";
		this.mobile = 0;
		this.validated = false;
	}
	
	public JSONObject toJson() {
	    JSONObject jsonContent = new JSONObject();
	    jsonContent.put(SKeywords.USERNAME, this.userName);
	    jsonContent.put(SKeywords.FIRSTNAME, this.firstName);
	    jsonContent.put(SKeywords.LASTNAME, this.lastName);
	    jsonContent.put(SKeywords.GENDER, this.gender);
	    jsonContent.put(SKeywords.DOB, this.dob);
	    jsonContent.put(SKeywords.COUNTRY, this.country);	    
	    jsonContent.put(SKeywords.MOBILE, this.mobile);
	    jsonContent.put(SKeywords.VALIDATED, this.validated);
	    jsonContent.put(SKeywords.USERID, this.userId);
	   
	    return jsonContent;
	}
	
	public Document toDataSet() {
		MongoDatabase database = Connection.getDatabase();
	    MongoCollection<Document> userDetailsCollection = database.getCollection("UserDetails");
	    Document query = new Document(SKeywords.USERID, this.getUserID())
	    		.append(SKeywords.USERNAME, this.getUserName())
	    		.append(SKeywords.FIRSTNAME, this.getFirstName())
	    		.append(SKeywords.LASTNAME, this.getLastName())
	    		.append(SKeywords.GENDER, this.getGender())
	    		.append(SKeywords.DOB, this.getDob())
	    		.append(SKeywords.COUNTRY, this.getCountry())
	    		.append(SKeywords.MOBILE, this.getMobile())
	    		.append(SKeywords.VALIDATED, this.getValidated());
	    userDetailsCollection.insertOne(query);
	    return query;
	}

	public void fromJson(JSONObject jsonData){
		this.userName = jsonData.getString(SKeywords.USERNAME);
		this.firstName = jsonData.getString(SKeywords.FIRSTNAME);
		this.lastName = jsonData.getString(SKeywords.LASTNAME);
		this.gender = jsonData.getString(SKeywords.GENDER);
		this.dob = jsonData.getString(SKeywords.DOB);
		this.country = jsonData.getString(SKeywords.COUNTRY);
		this.mobile = jsonData.getInt(SKeywords.MOBILE);
		this.validated = jsonData.getBoolean(SKeywords.VALIDATED);		
		try {
			this.userId = jsonData.getLong("userid");
		}
		catch(Exception e){		
		}
	}
	
	public void fromDataSet(Document data){
		this.userId = data.getInteger(SKeywords.USERID).longValue();
	    this.userName = data.getString(SKeywords.USERNAME);
	    this.firstName = data.getString(SKeywords.FIRSTNAME);
	    this.lastName = data.getString(SKeywords.LASTNAME);
	    this.gender = data.getString(SKeywords.GENDER);
	    this.dob = data.getString(SKeywords.DOB);
	    this.country = data.getString(SKeywords.COUNTRY);
	    this.mobile = data.getInteger(SKeywords.MOBILE);
	    this.validated = data.getBoolean(SKeywords.VALIDATED);
	}
		
	public long getUserID() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getDob() {
		return dob;
	}
	
	public String getCountry() {
		return country;
	}
	
	
	public int getMobile() {
		return mobile;
	}
	
	public boolean getValidated() {
		return validated;
	}
	
}
