//package africa.semicolon.gossip.data.repository;
//
//import africa.semicolon.gossip.data.models.Post;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class PostRepositoryImpl implements PostRepository {
//    private List<Post> postDb = new ArrayList<>();
//
//    @Override
//    public void save(Post post) {
//        if (post.getId() != 0) update(post);
//        else {
//            setPostId(post);
//            postDb.add(post);
//        }
//    }
//
//    private void setPostId(Post post) {
//        if (Objects.equals(postDb.size(), 0)) post.setId(1);
//        else {
//            int lastIndex = postDb.size() - 1;
//            int id = postDb.get(lastIndex).getId() + 1;
//            post.setId(id);
//        }
//    }
//
//    private void update(Post post) {
//        Post savedPost = findById(post.getId());
//        savedPost.setTitle(post.getTitle());
//        savedPost.setBody(post.getBody());
//    }
//
//    @Override
//    public Post findById(int id) {
//        for (Post post : postDb) if (Objects.equals(post.getId(), id)) return post;
//        return null;
//    }
//
//    @Override
//    public List<Post> findAll() {
//        return postDb;
//    }
//
//    @Override
//    public long count() {
//        return postDb.size();
//    }
//
//    @Override
//    public void delete(Post post) {
//        postDb.remove(post);
//    }
//
//    @Override
//    public void delete(int id) {
//        postDb.removeIf(post -> Objects.equals(post.getId(), id));
//    }
//}
