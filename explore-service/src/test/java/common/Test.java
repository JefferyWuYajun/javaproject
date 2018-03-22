package common;

import com.sun.media.sound.SoftTuning;

/**
 * @author jefferywu
 * @version Id: Test, v 0.1 18/3/22 下午5:38 jefferywu Exp $
 */
public class Test {

    private String c = "123";

    private static String a = "123";

    private static final String b = "123";

    @org.junit.Test
    public void generalTest() throws Exception {
        System.out.println(a);

        a = "456";

        System.out.println(a);
    }

    @org.junit.Test
    public void finalTest() throws Exception {
        System.out.println(b);

        System.out.println(c);
        c = "456";
        System.out.println(c);
    }
}
