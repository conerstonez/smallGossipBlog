package africa.semicolon.gossip.repositories;

import africa.semicolon.gossip.data.repository.CommentRepository;
import africa.semicolon.gossip.data.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;

class CommentRepositoryImplTest {

    CommentRepository commentRepository;
    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }


}
