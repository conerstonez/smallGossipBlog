package africa.semicolon.gossip.services;

import africa.semicolon.gossip.data.models.Comment;
import africa.semicolon.gossip.data.models.Post;
import africa.semicolon.gossip.data.repository.PostRepository;
//import africa.semicolon.gossip.data.repository.PostRepositoryImpl;
import africa.semicolon.gossip.dtos.requests.CreatePostRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServicesImpl implements PostServices {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Post createPost(CreatePostRequests createPostRequest) {
        Post post = new Post();
        post.setBody(createPostRequest.getBody());
        post.setTitle(createPostRequest.getTitle());
        postRepository.save(post);
        return post;
    }

    @Override
    public void updatePost(String id, CreatePostRequests createPostRequest) {
        Post post = new Post();
        post.setId(id);
        post.setBody(createPostRequest.getBody());
        post.setTitle(createPostRequest.getTitle());
        postRepository.save(post);
    }

    @Override
    public void addComment(String postId, Comment comment) {
        postRepository.findPostById(postId).getComments().add(comment);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    @Override
    public Post viewPost(String id) {
        return postRepository.findPostById(id);
    }

    @Override
    public List<Post> viewAll() {
        return postRepository.findAll();
    }
}
