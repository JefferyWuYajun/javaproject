package explorethread;

import org.junit.Test;

/**
 * @author jefferywu
 * @version Id: JoinThreadTest, v 0.1 18/2/9 上午10:56 jefferywu Exp $
 */
public class JoinThreadTest {

    @Test
    public void JoinThreadTestOne() throws InterruptedException {
        System.out.println("线程:" + Thread.currentThread().getName() + "开始运行");
        Thread testThread = new Thread(new JoinThread("A"));
        testThread.start();
        testThread.join();
        System.out.println("线程:" + Thread.currentThread().getName() + "运行结束");
    }
}
