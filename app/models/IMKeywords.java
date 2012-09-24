package models;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
//import leodagdag.play2morphia.Blob;
import leodagdag.play2morphia.Model;
import org.bson.types.ObjectId;

@Entity
public class IMKeywords extends Model {

    @Id
    public ObjectId id;

    public String groupId;

    //public Blob picture;

    public static Model.Finder<ObjectId, IMKeywords> find(){
    	return new Model.Finder<ObjectId, IMKeywords>(ObjectId.class, IMKeywords.class);
    }
    

}
