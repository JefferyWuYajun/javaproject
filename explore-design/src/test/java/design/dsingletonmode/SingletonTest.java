package design.dsingletonmode;

import org.junit.Test;

/**
 * @author wyj40124
 * @version Id: SingletonTest, v 0.1 2018/3/9 14:48 wyj40124 Exp $
 */
public class SingletonTest {

    @Test
    public void successSingletonTest() throws Exception {
        Singleton singleton = Singleton.getInstance();
        singleton.eat();
        singleton.drink();
    }
}