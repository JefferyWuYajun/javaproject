package explorethread;

import org.junit.Test;

/**
 * @author jefferywu
 * @version Id: MyThreadTest, v 0.1 18/2/9 下午3:02 jefferywu Exp $
 */
public class MyThreadTest {
    @Test
    public void MyThreadTestOne() throws Exception {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(1000);
        MyThread thread2 = new MyThread();
        thread2.start();

        System.out.println(thread.getNum());
        System.out.println(thread2.getNum());
    }
}
