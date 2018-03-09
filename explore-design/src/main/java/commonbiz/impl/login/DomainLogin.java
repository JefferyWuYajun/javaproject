package commonbiz.impl.login;

import commonbiz.Login;

/**
 * @author wyj40124
 * @version Id: DomainLogin, v 0.1 2018/3/9 10:18 wyj40124 Exp $
 */
public class DomainLogin implements Login {
    @Override
    public boolean verify(String name, String password) {
        return false;
    }
}