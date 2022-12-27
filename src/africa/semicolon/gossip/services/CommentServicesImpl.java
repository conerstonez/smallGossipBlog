package africa.semicolon.gossip.services;

import africa.semicolon.gossip.data.models.Comment;
import africa.semicolon.gossip.data.repository.CommentRepository;
//import africa.semicolon.gossip.data.repository.CommentRepositoryImpl;
import africa.semicolon.gossip.dtos.requests.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServicesImpl implements CommentServices{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostServices postServices;
    @Override
    public void createComments(CreateCommentRequest createCommentRequest) {
        Comment comment = new Comment();
        comment.setComment(createCommentRequest.getComment());
        comment.setCommenterName(createCommentRequest.getCommenterName());
        postServices.addComment(createCommentRequest.getPostId(), commentRepository.save(comment));
    }

    @Override
    public List<Comment> viewAll() {
        return commentRepository.findAll();
    }
}
