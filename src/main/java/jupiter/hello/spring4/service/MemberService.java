package jupiter.hello.spring4.service;

import jupiter.hello.spring4.model.Member;

public interface MemberService {

    boolean saveMemeber(Member m);
    boolean loginMember(Member m);
    Member readOneMember(String userid);

}
