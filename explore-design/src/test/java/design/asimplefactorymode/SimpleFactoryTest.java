package design.asimplefactorymode;

import commonbiz.Login;
import org.junit.Test;

/**
 * @author wyj40124
 * @version Id: SimpleFactoryTest, v 0.1 2018/3/9 10:52 wyj40124 Exp $
 */
public class SimpleFactoryTest {
    @Test
    public void successSimpleFactoryTest() throws Exception {

        Login login = LoginSimpleFactory.factory("password");
        System.out.println(login.verify("test","test"));

    }
}