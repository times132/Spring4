import java.util.Date;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void regist(RegisterRequest req){
        Member member = memberDao.selectByEmail(req.getEmail()); //이메일을 조회해봐서
        if (member != null){ //존재하면 오류
            throw new AlreadyExistingMemberException("dup email " + req.getEmail());
        }
        Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date()); //없으면 새로 추가
        memberDao.insert(newMember);
    }
}
