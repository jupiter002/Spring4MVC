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
        if (mdao.insertMember(m) > 0) isSaved = true;           //쿼리문으로 물어온 값에 들어있나 확인
        return isSaved;
    }
    @Override
    public boolean loginMember(Member m) {
        boolean isLogin = false;
        if(mdao.loginMember(m) !=null )isLogin = true;          //쿼리문으로 물어온 값에 들어있나 확인
        return isLogin;
    }

    @Override
    public Member readOneMember(String userid) {                    //로그인이 성공했을때는 쿼리문으로 물어온 값의 여부를 확인할 필요가 없기때문에 확인x
        return mdao.selectOneMember(userid);
    }
}
