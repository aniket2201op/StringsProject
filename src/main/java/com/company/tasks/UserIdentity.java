package com.company.tasks;
import org.bson.Document;
import org.json.JSONObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
//import org.bson.types.Binary;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;


public class UserIdentity {
	private IdCardType idType;
	private String idNumber;
	private String validFrom;
	private String validTo;
	private boolean isValid;
//	private String imagePath;
	
	public UserIdentity () { 
		
	}
	
	public JSONObject toJson() {
	    JSONObject jsonContent = new JSONObject();
	   jsonContent.put(SKeywords.IDNUMBER, this.idNumber);
	   jsonContent.put(SKeywords.VALIDFROM, this.validFrom);
	   jsonContent.put(SKeywords.VALIDTO, this.validTo);
	   jsonContent.put(SKeywords.ISVALID, this.isValid);
	   jsonContent.put(SKeywords.IDTYPE, this.idType);
	    return jsonContent;
	}

	public void fromJson(JSONObject jsonData){
		this.idNumber = jsonData.getString(SKeywords.IDNUMBER);
		this.validFrom = jsonData.getString(SKeywords.VALIDFROM);
		this.validTo = jsonData.getString(SKeywords.VALIDTO);
		this.isValid = jsonData.getBoolean(SKeywords.ISVALID);
		
		try {
			this.idType = IdCardType.valueOf(jsonData.getString(SKeywords.IDTYPE));
					
		}catch(Exception ex) {
			
		}
	}

	public Document toDataset() {
		 MongoDatabase database = Connection.getDatabase();
	     MongoCollection<Document> userIdentityCollection = database.getCollection("UserIdentity");
	    	
	     Document query = new Document(SKeywords.IDNUMBER ,this.getNumber())
	    	        .append(SKeywords.VALIDFROM, this.getVaildfrom())
	    	        .append(SKeywords.VALIDTO, this.getVaildto())
	    	        .append(SKeywords.ISVALID, this.getIsvaild())
	    	        .append(SKeywords.IDTYPE, this.getIdtype().toString());
//	    	        .append(SKeywords.IMAGE, new Binary(this.getImage(imagePath)));

	     userIdentityCollection.insertOne(query);
	     return query;
	    	 	     
	}
	
	public void fromDataset(Document query) {
		this.idNumber = query.getString(SKeywords.IDNUMBER);																									
		this.isValid = query.getBoolean(SKeywords.ISVALID);
		this.validFrom = query.getString(SKeywords.VALIDFROM);
		this.validTo = query.getString(SKeywords.VALIDTO);
//		this.imagePath = query.getString(SKeywords.IMAGE);
		    try {
		        this.idType = IdCardType.valueOf(query.getString(SKeywords.IDTYPE));
		    } catch (IllegalArgumentException e) {
		    }
	}

    
//	public byte[] getImage(String imagePath) {
//        byte[] imageData = null;
//        try {
//            File file = new File(imagePath);
//            imageData = new byte[(int) file.length()];
//            FileInputStream fileInputStream = new FileInputStream(file);
//            fileInputStream.read(imageData);
//            fileInputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return imageData;
//    }
	
	public IdCardType getIdtype() {
		return idType;
	}
	
	
	public String getNumber() {
		return idNumber;
	}
	
	
	public String getVaildfrom() {
		return validFrom;
	}

	
	public String getVaildto() {
		return validTo;
	}
	
	public boolean getIsvaild() {
		return isValid;
	}
	
}