package jupiter.hello.spring4.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Board {
    private int bno;
    private String userid;
    private String title;
    private String contents;
    private String regdate;
    private String views;

}
