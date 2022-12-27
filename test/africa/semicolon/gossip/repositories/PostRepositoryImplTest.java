package africa.semicolon.gossip.repositories;


import africa.semicolon.gossip.data.models.Post;
import africa.semicolon.gossip.data.repository.PostRepository;
//import africa.semicolon.gossip.data.repository.PostRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepositoryImplTest {

    PostRepository postRepository;

    @BeforeEach
//    void setUp() {
//        postRepository = new PostRepositoryImpl();
//    }

    @Test
    void saveNewPostTest_countShouldBeOne_Test() {
        Post post = new Post();
        post.setBody("Our new post");
        post.setTitle("Our post Title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
    }

    @Test
    void saveNewPost_findById_shouldReturnSavedPostTest() {
        Post post = new Post();
        post.setBody("Our new post");
        post.setTitle("Our post Title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
//        Post savedpost = postRepository.findById(1);
//        assertEquals(post, savedpost);

        Post post2 = new Post();
//        post2.setBody("Our new post");
//        post2.setTitle("Our post Title");
        postRepository.save(post2);
        assertEquals(2L, postRepository.count());
//        assertEquals(post2, postRepository.findById(2));
    }

    @Test
    void saveNewPost_updatePost_countIsOneTest() {
        Post post = new Post();
        post.setBody("Our new post");
        post.setTitle("Our post Title");
        postRepository.save(post);

        Post updatedPost = new Post();
//        updatedPost.setId(1);
        updatedPost.setBody("updated body");
        updatedPost.setTitle("updated title");
        postRepository.save(updatedPost);
        assertEquals(1L, postRepository.count());
//        assertEquals(post, postRepository.findById(1));
        assertEquals("updated body", post.getBody());
        assertEquals("updated title", post.getTitle());
    }

    @Test
    void deleteItemBYId_countIsZeroTest() {
        Post post = new Post();
        post.setBody("Our new post");
        post.setTitle("Our post Title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
//        postRepository.delete(1);
        assertEquals(0, postRepository.count());
    }

    @Test
    void savingItems_andDeletingItemsWithoutHavingDuplicateIds() {
        Post post = new Post();
        post.setBody("Our new post"); post.setTitle("Our post Title");
        postRepository.save(post);
        Post post2 = new Post();
        post2.setBody("post2"); post2.setTitle("---------");
        postRepository.save(post2);
        Post post3 = new Post();
        post3.setBody("post3"); post3.setTitle("########");
        postRepository.save(post3);
        assertEquals(3L, postRepository.count());
//        postRepository.delete(2);
        Post post4 = new Post();
        post4.setBody("Our new post"); post4.setTitle("Our post Title");
        postRepository.save(post4);
        assertEquals(3L, postRepository.count());
        assertEquals(4, post4.getId());
    }

    @Test
    void deletePost_countIsZero() {
        Post post = new Post();
        post.setBody("Our new post");
        post.setTitle("Our post Title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
        postRepository.delete(post);
        assertEquals(0, postRepository.count());
    }
}