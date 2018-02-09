package service.impl;

import com.sun.media.sound.SoftTuning;
import service.UserService;

/**
 * @author jefferywu
 * @version Id: UserServiceImpl, v 0.1 18/2/8 下午5:58 jefferywu Exp $
 */
public class UserServiceImpl implements UserService {

    @Override
    public void test(String userName) throws Exception {
        System.out.println("test");
        System.out.println("test2");
    }
}
