import org.junit.Test;

import java.util.regex.Pattern;

public class MatchTest {
    @Test
    public void match(){
        System.out.println(matches("a"));
        System.out.println(matches("ab"));
        System.out.println(matches("a d"));
        System.out.println(matches("void"));
        System.out.println(matches("我的世界"));
        System.out.println(matches("顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶"));
        System.out.println(matches("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"));
        System.out.println(matches("steve_wang"));
    }

    public boolean matches(String s){
        return Pattern.matches("[a-zA-z0-9_]{3,16}", s);
    }
}
