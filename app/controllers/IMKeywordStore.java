package controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import models.IMKeywords;

import org.codehaus.jackson.JsonGenerationException;
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
		int runId = node.get("runId").asInt();
		
		//deserialize json array of strings
		JsonNode keywords = node.findPath("keywords");
		TypeReference<Set<String>> collectionType = 
			    new TypeReference<Set<String>>(){};
			Set<String> strKeywords = 
			    mapper.readValue(keywords, collectionType);
		
		//created new keyword store and save in db
    	IMKeywords keywordStore = new IMKeywords(groupId, runId, strKeywords);
    	keywordStore.insert();
    	
	    return ok(toJson(keywordStore));
	  }
	
	
	
	
	public static Result fetchAllKeyWordStore()  {
		
    	List<IMKeywords> keywordStores = IMKeywords.find().all();
    	
	    return ok(toJson(keywordStores));
	  }
	
	
	
	
	
	
	public static Result fetchKeyWordsbyGroup(String groupId)  {
		
		//parse http requet to json
//		JsonNode node =  ctx().request().body().asJson();
//		String groupId = node.get("groupId").asText();
//		String taskId = node.get("taskId").asText();
//		int runId = node.get("runId").asInt();
		
		//created new keyword store and save in db
		IMKeywords keywordStore = IMKeywords.find().filter("groupId", groupId).get();
    	
	    return ok(toJson(keywordStore));
	  }
	
	
	
	
	public static Result updateKeywordsStore(String storeId) throws JsonParseException, JsonMappingException, IOException  {
		
		ObjectMapper mapper = new ObjectMapper();

		//parse http requet to json
		JsonNode node =  ctx().request().body().asJson();
		//String groupId = node.get("groupId").asText();

		
		JsonNode keywords = node.findPath("keywords");
		TypeReference<Set<String>> collectionType = 
			    new TypeReference<Set<String>>(){};
			Set<String> strKeywords = 
			    mapper.readValue(keywords, collectionType);
		
		
		//created new keyword store and save in db
    	//IMKeywordStore keywordStore = IMKeywordStore.find().filter("groupId", groupId).filter("runId", runId).get();
			IMKeywords keywordStore = IMKeywords.find().byId(storeId);	
    	keywordStore.keywords = strKeywords;
    	keywordStore.update();
	    return ok(toJson(keywordStore));
	  }
	
	
	
	
	
	public static Result deserialize() throws JsonGenerationException, JsonMappingException, IOException{
    	
		ObjectMapper mapper = new ObjectMapper();
		
		Collection<String> keywords = Arrays.asList("1","2","3","4","5");

		// (Serialization)
		String json = mapper.writeValueAsString(keywords);
		
		System.out.println(json); // [1,2,3,4,5]
    	
	    return ok(json);
	  }
	

}
