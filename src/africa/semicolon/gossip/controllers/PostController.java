package africa.semicolon.gossip.controllers;

import africa.semicolon.gossip.data.models.Post;
import africa.semicolon.gossip.dtos.requests.CreatePostRequests;
import africa.semicolon.gossip.services.PostServices;
import africa.semicolon.gossip.services.PostServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    private PostServices postServices;

    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequests createPostRequest) {
        postServices.createPost(createPostRequest);
        return "Successful";
    }

    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable String postId) {
        return postServices.viewPost(postId);
    }
}
