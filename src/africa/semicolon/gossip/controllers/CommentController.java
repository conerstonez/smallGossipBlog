package africa.semicolon.gossip.controllers;

import africa.semicolon.gossip.services.CommentServices;
import africa.semicolon.gossip.services.CommentServicesImpl;
import africa.semicolon.gossip.dtos.requests.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentServices commentServices;
    @PostMapping("/comment")
    public String addComment(@RequestBody CreateCommentRequest createCommentRequest) {
        commentServices.createComments(createCommentRequest);
        return "Comment added";
    }

}
