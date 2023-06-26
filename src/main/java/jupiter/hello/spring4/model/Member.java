package jupiter.hello.spring4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString

public class Member {
    private int mno;
    private String userid;
    private String passwd;
    private String username;
    private String useremail;
    private String regdate;


    }

