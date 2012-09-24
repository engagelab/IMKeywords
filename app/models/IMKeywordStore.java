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
public class IMKeywordStore extends Model {

    @Id
    public String id;

    public String groupId;
    public String taskId;
    public int runId;
    
    //use Set to avoid duplicated entries 
    public Set<String> keywords;

    //public Blob picture;

    public static Model.Finder<ObjectId, IMKeywordStore> find(){
    	return new Model.Finder<ObjectId, IMKeywordStore>(ObjectId.class, IMKeywordStore.class);
    }
    
    
    public IMKeywordStore(String groupId, String taskId, int runId, Set<String> keywords)
    {
    	this.groupId = groupId;
    	this.taskId = taskId;
    	this.runId = runId;
    	this.keywords = keywords;
    }

}
