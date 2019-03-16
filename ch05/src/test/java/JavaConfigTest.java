import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
public class JavaConfigTest {
    @Autowired
    private MemberRegisterService memberRegisterSrg;

    @Autowired
    private MemberInfoPrinter printer;



    @Test
    public void 자바설정이_싱글톤인가(){
        //System.out.println(memberRegisterSrg.getMemberDao());
        //System.out.println(printer.getMemberDao());
        assertThat(memberRegisterSrg.getMemberDao(), is(printer.getMemberDao()));
    }
}
