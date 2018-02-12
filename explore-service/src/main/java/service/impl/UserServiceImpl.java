package service.impl;

import service.UserService;
import static service.CommonService.getUserName;

/**
 * @author jefferywu
 * @version Id: UserServiceImpl, v 0.1 18/2/8 下午5:58 jefferywu Exp $
 */
public class UserServiceImpl implements UserService {

    @Override
    public void test(String userName) throws Exception {
        String name = getUserName();
        System.out.println(name);
    }

    @Override
    public void junitOrg(String jobNumber) throws Exception {
        System.out.println("jobNumber :" + jobNumber);
    }
}
