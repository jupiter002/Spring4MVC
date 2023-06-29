package jupiter.hello.spring4.service;

import jupiter.hello.spring4.dao.MemberDao;
import jupiter.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("msrv")
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDao mdao;
    @Override
    public boolean saveMemeber(Member m) {
        boolean isSaved = false;
        if (mdao.insertMember(m) > 0) isSaved = true;
        return isSaved;
    }
    @Override
    public boolean loginMember(Member m) {
        boolean isLogin = false;
        if(mdao.loginMember(m) !=null )isLogin = true;
        return isLogin;
    }
}
