package jupiter.hello.spring4.model;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {
    private String bno;
    private String userid;
    private String title;
    private String contents;
    private String regdate;
    private String views;

}
