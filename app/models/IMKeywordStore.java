package models;

import java.util.Set;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
//import leodagdag.play2morphia.Blob;
import leodagdag.play2morphia.Model;
import org.bson.types.ObjectId;

@Entity
public class IMKeywordStore extends Model {

    @Id
    public ObjectId id;

    public String groupId;
    public String taskId;
    public int runId;
    
    public Set<String> keywords;

    //public Blob picture;

    public static Model.Finder<ObjectId, IMKeywordStore> find(){
    	return new Model.Finder<ObjectId, IMKeywordStore>(ObjectId.class, IMKeywordStore.class);
    }
    

}
