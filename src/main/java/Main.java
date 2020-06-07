import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import app.Zoo;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Zoo zoo = context.getBean("zoo", Zoo.class);
        zoo.getCat().voice();
        zoo.getDog().voice();
    }
}
