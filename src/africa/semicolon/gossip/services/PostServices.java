package africa.semicolon.gossip.services;

import africa.semicolon.gossip.data.models.Comment;
import africa.semicolon.gossip.data.models.Post;
import africa.semicolon.gossip.dtos.requests.CreatePostRequests;

import java.util.List;

public interface PostServices {
    Post createPost(CreatePostRequests createPostRequest);
    void updatePost(String id, CreatePostRequests createPostRequests);
    void addComment(String postId, Comment comment);
    void deletePost(Post post);
    Post viewPost(String id);
    List<Post> viewAll();
}
