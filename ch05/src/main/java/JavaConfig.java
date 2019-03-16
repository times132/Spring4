import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration          //설정으로 사용된다고 표시
public class JavaConfig {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegisterSvc(){
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public MemberPrinter printer(){
        return new MemberPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDao(memberDao());
        infoPrinter.setPrinter(printer());
        return infoPrinter;
    }
}
