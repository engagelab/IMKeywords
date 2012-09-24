package controllers;

import models.IMKeywordStore;

import org.codehaus.jackson.JsonNode;

import play.mvc.Controller;
import play.mvc.Result;

public class IMKeywords extends Controller{
	
	
	public static Result addKeyWords() {
		
		JsonNode node =  ctx().request().body().asJson();
    	
    	String keywords = node.get("name").asText();
    	String password = node.get("password").asText();
    	int runId = node.get("runId").asInt();
    	
    	
		
    	//IMKeywordStore keywordStore = new IMKeywordStore(name,password, runId);
    	
	    return ok("Keywords API Started");
	  }
	
	

}
