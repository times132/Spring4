public class Assembler { //객체를 생성하고 주입해주는 클래스
    private MemberDao memberDao;
    private MemberRegisterService regSvc;
    private ChangePasswordService pwdSvc;

    public Assembler(){
        memberDao = new MemberDao();
        regSvc = new MemberRegisterService(memberDao);
        pwdSvc = new ChangePasswordService(memberDao);
    }

    public MemberDao getMemberDao(){
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService(){
        return regSvc;
    }

    public ChangePasswordService getChangePasswordService(){
        return pwdSvc;
    }
}
