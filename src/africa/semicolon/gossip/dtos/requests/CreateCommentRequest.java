package africa.semicolon.gossip.dtos.requests;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@Data
public class CreateCommentRequest {
    private String postId;
//    @NonNull
    private String commenterName;
    private  String comment;

}
