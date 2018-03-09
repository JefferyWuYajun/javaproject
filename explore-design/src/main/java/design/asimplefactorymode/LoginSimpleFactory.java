package design.asimplefactorymode;

import org.apache.commons.lang3.StringUtils;

import commonbiz.Login;
import commonbiz.impl.login.DomainLogin;
import commonbiz.impl.login.PasswordLogin;

/**
 * 需要一个工厂类LoginSimpleFactory，根据调用者不同的要求，创建出不同的登录对象并返回。而如果碰到不合法的要求，会返回一个Runtime异常。
 *
 * 简单工厂模式的优点
 *　 模式的核心是工厂类。这个类含有必要的逻辑判断，可以决定在什么时候创建哪一个登录验证类的实例，而调用者则可以免除直接创建对象的责任。
 *   简单工厂模式通过这种做法实现了对责任的分割，当系统引入新的登录方式的时候无需修改调用者。
 * 简单工厂模式的缺点
 *   这个工厂类集中了所以的创建逻辑，当有复杂的多层次等级结构时，所有的业务逻辑都在这个工厂类中实现。什么时候它不能工作了，整个系统都会受到影响。
 * @author wyj40124
 * @version Id: LoginSimpleFactory, v 0.1 2018/3/9 10:23 wyj40124 Exp $
 */
public class LoginSimpleFactory {
    public static Login factory(String type) {
        if (StringUtils.equals(type, "password")) {
            return new PasswordLogin();
        } else if (StringUtils.equals(type, "domain")) {
            return new DomainLogin();
        } else {
            throw new RuntimeException("没有取到登录类型");
        }
    }
}