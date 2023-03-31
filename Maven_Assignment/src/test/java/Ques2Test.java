import junit.framework.TestCase;
import org.example.Ques2;

public class Ques2Test extends TestCase {
    public void testSayHello(){
        Ques2 ques2=new Ques2();
        assertEquals("Hello World!!!",ques2.sayHello());
    }

}
