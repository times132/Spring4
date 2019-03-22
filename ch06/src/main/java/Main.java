import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:springconf.xml");
        Client client = ctx.getBean("client", Client.class);
        client.send();
        Client2 client2 = ctx.getBean("client2", Client2.class);
        client2.send();
        ctx.close();
    }
}
