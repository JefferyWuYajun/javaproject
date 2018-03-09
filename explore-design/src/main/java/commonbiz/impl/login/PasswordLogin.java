package commonbiz.impl.login;

import commonbiz.Login;

/**
 * @author wyj40124
 * @version Id: PasswordLogin, v 0.1 2018/3/9 10:14 wyj40124 Exp $
 */
public class PasswordLogin implements Login {
    @Override
    public boolean verify(String name, String password) {
        return true;
    }
}