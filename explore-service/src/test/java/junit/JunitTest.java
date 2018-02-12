package junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import service.CommonService;
import service.impl.UserServiceImpl;

/**
 * @author jefferywu
 * @version Id: JunitTest, v 0.1 18/2/12 下午1:29 jefferywu Exp $
 */
@RunWith(PowerMockRunner.class)
public class JunitTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testPowerMock() throws Exception {
        userService.junitOrg("40124");
    }

    @PrepareForTest({CommonService.class})
    @Test
    public void junitTest() throws Exception {
        PowerMockito.mockStatic(CommonService.class);
        PowerMockito.when(CommonService.getUserName()).thenReturn("newNameJeffery");
        userService.test(null);
    }
}
