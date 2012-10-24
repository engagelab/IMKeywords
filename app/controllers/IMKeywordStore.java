package controllers;

import java.io.IOException;
import java.util.List;

import models.IMKeywords;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.codehaus.jackson.type.TypeReference;
import static play.libs.Json.toJson;

import play.mvc.Controller;
import play.mvc.Result;

public class IMKeywordStore extends Controller{
	
	
	public static Result addKeywordStore() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		//parse http requet to json
		JsonNode node =  ctx().request().body().asJson();
		String groupId = node.get("groupId").asText();
		String taskId = node.get("taskId").asText();
		
		//deserialize json array of strings
		JsonNode keywords = node.findPath("keywords");
		TypeReference<List<String>> collectionType = 
			    new TypeReference<List<String>>(){};
			List<String> strKeywords = 
			    mapper.readValue(keywords, collectionType);
		
		//created new keyword store and save in db
    	IMKeywords keywordStore = new IMKeywords(groupId, taskId, strKeywords);
    	keywordStore.insert();
    	
	    return ok(toJson(keywordStore));
	  }
	
	
	
	
	public static Result fetchAllKeywordStore()  {
		
    	List<IMKeywords> keywordStores = IMKeywords.find().all();
    	
	    return ok(toJson(keywordStores));
	  }
	
	
	
	
	
	
	public static Result fetchKeywordStorebyGroupAndTask(String groupId, String taskId)  {
		
		//created new keyword store and save in db
		IMKeywords keywordStore = IMKeywords.find().filter("groupId", groupId).filter("taskId", taskId).get();
    	
		if (keywordStore == null) {
			keywordStore = new IMKeywords();
			
		}
	    return ok(toJson(keywordStore));
	  }
	
	
	
	
	public static Result updateKeywordStore() throws JsonParseException, JsonMappingException, IOException  {
		
		ObjectMapper mapper = new ObjectMapper();

	
		JsonNode node =  ctx().request().body().asJson();
	
		String groupId = node.get("groupId").asText();
		String taskId = node.get("taskId").asText();
		
		JsonNode keywords = node.findPath("keywords");
		
		TypeReference<List<String>> collectionType = 
			    new TypeReference<List<String>>(){};
		
		List<String> strKeywords = mapper.readValue(keywords, collectionType);
		
		
		// FIXME search keywordStore by its own id
		IMKeywords keywordStore = IMKeywords.find().filter("groupId", groupId).filter("taskId", taskId).get();
    	keywordStore.keywords = strKeywords;
    	keywordStore.update();
	    return ok(toJson(keywordStore));
	  }
	

}
