package controllers;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import play.mvc.*;



public class Application extends Controller {
  
  public static Result index() throws JsonGenerationException, JsonMappingException, IOException {
	
	  ObjectMapper mapper = new ObjectMapper();
		
		Collection<String> keywords = Arrays.asList("1","2","3","4","5");

		// (Serialization)
		String json = mapper.writeValueAsString(keywords);
		
		System.out.println(json); // [1,2,3,4,5]
    	
	    return ok(json);
  }
  
}

