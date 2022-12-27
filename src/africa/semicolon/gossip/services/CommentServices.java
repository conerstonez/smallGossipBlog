package africa.semicolon.gossip.services;

import africa.semicolon.gossip.data.models.Comment;
import africa.semicolon.gossip.dtos.requests.CreateCommentRequest;

import java.util.List;

public interface CommentServices {

    void createComments(CreateCommentRequest createCommentRequest);
    List<Comment> viewAll();
}
