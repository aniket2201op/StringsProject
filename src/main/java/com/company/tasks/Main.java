package com.company.tasks;
import org.bson.Document;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("firstname", "Aniket");
		jsonData.put("lastname", "Shinde");
		jsonData.put("username", "aniketOP");
		jsonData.put("gender", "Male");
		jsonData.put("dob", "2002-11-12");
		jsonData.put("country", "India");
		jsonData.put("mobile", 1234567890);
		jsonData.put("validated", true);
		
		UserDetails user = new UserDetails();
		UserIdentity identity = new UserIdentity();
		Document query = new Document(SKeywords.USERID, 1)
				.append(SKeywords.IDTYPE, "AADHAR")
				.append(SKeywords.ISVALID, true )
				.append(SKeywords.VALIDFROM, "12-11-2002")
				.append(SKeywords.VALIDTO, "12-11-2012")
				.append(SKeywords.IDNUMBER, "1223-1321-2002");
		identity.fromDataset(query);
		System.out.println(identity.toDataset());
				
		user.fromJson(jsonData);
		
		System.out.println(user.toJson());
		System.out.println(user.getFirstName());
		System.out.println(user.toDataSet());
		
		Document query1 = new Document(SKeywords.USERID, 5)
	    		.append(SKeywords.USERNAME, "PratikOP")
	    		.append(SKeywords.FIRSTNAME, "Pratik")
	    		.append(SKeywords.LASTNAME, "Patil" )
	    		.append(SKeywords.GENDER, "Male")
	    		.append(SKeywords.DOB,"2002-11-12")
	    		.append(SKeywords.COUNTRY, "India")
	    		.append(SKeywords.MOBILE, 999999999)
	    		.append(SKeywords.VALIDATED, true);
		user.fromDataSet(query1);
		System.out.println(user.toDataSet());
		
	}

}
