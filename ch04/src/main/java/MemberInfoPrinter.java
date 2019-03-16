import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
    @Autowired
    private MemberDao memberDao;
    private MemberPrinter printer;

    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    @Autowired
    public void setPrinter(MemberPrinter printer){
        this.printer = printer;
    }

    public void printMemberInfo(String email){
        Member member = memberDao.selectByEmail(email);
        if (member == null){
            System.out.println("데이터없음\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }

    @Autowired
    public void injectDependency(MemberDao memberDao, MemberPrinter printer){
        this.memberDao = memberDao;
        this.printer = printer;
    }
}
