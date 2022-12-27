package africa.semicolon.gossip.services;

import africa.semicolon.gossip.data.models.Comment;
import africa.semicolon.gossip.data.models.Post;
import africa.semicolon.gossip.dtos.requests.CreatePostRequests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServicesImplTest {
    PostServices postServices;
    CreatePostRequests createPostRequests;
    @BeforeEach
    void setUp() {
        postServices = new PostServicesImpl();
        createPostRequests = new CreatePostRequests();
    }

    @Test
    void createPostTest() {
        createPostRequests.setBody("New post Body");
        createPostRequests.setTitle("New post");
        postServices.createPost(createPostRequests);
        assertEquals(1, postServices.viewAll().size());
    }

    @Test
    void viewPostTest() {
        createPostRequests.setBody("New post Body");
        createPostRequests.setTitle("New Post");
        postServices.createPost(createPostRequests);
        assertEquals(1, postServices.viewAll().size());

        Post post = postServices.viewPost(1);
        assertEquals("New Post", post.getTitle());
        assertEquals("New post Body", post.getBody());
        assertNotNull(post.getCreationTime());
    }

    @Test
    void deletePostTest_countIsZero() {
        createPostRequests.setBody("New post Body");
        createPostRequests.setTitle("New Post");
        Post post = postServices.createPost(createPostRequests);
        assertEquals(1, postServices.viewAll().size());

        postServices.deletePost(post);
        assertEquals(0, postServices.viewAll().size());
    }

    @Test
    void updatePostTest() {
        createPostRequests.setBody("New post Body");
        createPostRequests.setTitle("New Post");
        postServices.createPost(createPostRequests);
        assertEquals(1, postServices.viewAll().size());

        createPostRequests.setBody("Another Body");
        createPostRequests.setTitle("New post title");
        postServices.updatePost(1, createPostRequests);
        Post post = postServices.viewPost(1);
        assertEquals(1, postServices.viewAll().size());
        assertEquals("Another Body", post.getBody());
        assertEquals("New post title", post.getTitle());
    }

    @Test
    void addCommentTest() {
        createPostRequests.setBody("New post Body");
        createPostRequests.setTitle("New Post");
        postServices.createPost(createPostRequests);
//        Post post = new Post();
//        post.setBody("Post Body");
//        post.setTitle("Post Title");
        Comment comment = new Comment();
        comment.setComment("I love this");
        postServices.addComment(1, comment);
        Post savedPost = postServices.viewPost(1);

        assertEquals(1, savedPost.getComments().size());
        assertEquals("I love this", savedPost.getComments().get(0).getComment());
    }
}