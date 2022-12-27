package africa.semicolon.gossip.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Comment {
    private String commenterName;
   @Id
    private String id;
    private String comment;

//    public String getCommenterName() {
//        return commenterName;
//    }
//
//    public void setCommenterName(String commenterName) {
//        this.commenterName = commenterName;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
}
