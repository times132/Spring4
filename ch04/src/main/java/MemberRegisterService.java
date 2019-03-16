import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;

public class MemberRegisterService {
    //@Resource(name="memberDao")      @Resource를 이용, 이름으로 찾아서 주입, 이름이 없으면 타입으로 주입
    private MemberDao memberDao;

    @Autowired(required = false)    //@Autowired를 이용, 타입으로 찾아서 주입
    public MemberRegisterService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public MemberRegisterService(){}  //@Autowired(required=false)을 할거면 기본 생성자가 있어야한다

    public void regist(RegisterRequest req){
        Member member = memberDao.selectByEmail(req.getEmail()); //이메일을 조회해봐서
        if (member != null){ //존재하면 오류
            throw new AlreadyExistingMemberException("dup email " + req.getEmail());
        }
        Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date()); //없으면 새로 추가
        memberDao.insert(newMember);
    }
}
