package jupiter.hello.spring4.dao;

import jupiter.hello.spring4.model.Member;

public interface MemberDao {
    int insertMember(Member m);
    Member loginMember(Member m);
}
