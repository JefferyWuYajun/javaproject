package explorethread;

import org.junit.Test;

/**
 * @author jefferywu
 * @version Id: YieldThreadTest, v 0.1 18/2/9 上午11:15 jefferywu Exp $
 */
public class YieldThreadTest {

    @Test
    public void YieldThradTest(){
        Thread threadA = new YieldThread("A");
        Thread threadB = new YieldThread("B");
        threadA.start();
        threadB.start();
    }
}
