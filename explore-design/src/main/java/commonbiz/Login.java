package commonbiz;

/**
 * 就拿登录功能来说，假如应用系统需要支持多种登录方式如：口令认证、域认证
 * （口令认证通常是去数据库中验证用户，而域认证则是需要到微软的域中验证用户）。
 * 那么自然的做法就是建立一个各种登录方式都适用的接口
 * @author wyj40124
 * @version Id: Login, v 0.1 2018/3/9 10:12 wyj40124 Exp $
 */
public interface Login {
    boolean verify(String name, String password);
}