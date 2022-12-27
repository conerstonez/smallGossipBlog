package africa.semicolon.gossip.services;

import africa.semicolon.gossip.dtos.requests.CreateCommentRequest;
import africa.semicolon.gossip.dtos.requests.CreatePostRequests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommentServicesImplTest {

    CommentServices commentServices;
    PostServices postServices;
    CreateCommentRequest createCommentRequest;
    CreatePostRequests createPostRequests;
    @BeforeEach
    void setUp() {
        commentServices = new CommentServicesImpl();
        postServices = new PostServicesImpl();
        createCommentRequest = new CreateCommentRequest();
        createPostRequests = new CreatePostRequests();
    }

    @Test
    void createCommentTest() {
        createPostRequests.setTitle("Title");
        createPostRequests.setBody("Body");
        postServices.createPost(createPostRequests);

        createCommentRequest.setPostId(1);
        createCommentRequest.setCommenterName("Femi");
        createCommentRequest.setComment("I love this");
        commentServices.createComments(createCommentRequest);
        assertEquals(1, commentServices.viewAll().size());
    }
}