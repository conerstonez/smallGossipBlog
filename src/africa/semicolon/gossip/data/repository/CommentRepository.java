package africa.semicolon.gossip.data.repository;

import africa.semicolon.gossip.data.models.Comment;
import africa.semicolon.gossip.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
//    Comment save(Comment comment);
//    Comment findById(int id);
//    List<Comment> findAll();
//    //    long count();
//    void delete(Comment comment);
//    void delete(int id);

}
