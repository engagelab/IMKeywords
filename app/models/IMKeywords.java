package models;

import java.util.Set;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
//import leodagdag.play2morphia.Blob;
import leodagdag.play2morphia.Model;
import org.bson.types.ObjectId;



/**
 * @author Muhammad Fahied
 */



@Entity
public class IMKeywords extends Model {

    @Id
    public String id;
   
    //use Set to avoid duplicated entries 
    public Set<String> keywords;

    //MetaInfo
    public String groupId;
    public String taskId;
    //public int runId;
    
    

    //public Blob picture;

    // morphia finder
    public static Model.Finder<ObjectId, IMKeywords> find(){
    	return new Model.Finder<ObjectId, IMKeywords>(ObjectId.class, IMKeywords.class);
    }
    
    
    //empty consturctor for fetch queries
    public IMKeywords()
    {
    	
    }
    
    
    
    
    public IMKeywords(String groupId, String taskId, Set<String> keywords)
    {
    	this.groupId = groupId;
    	this.taskId = taskId;
    	this.keywords = keywords;
    }

}
