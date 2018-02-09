package explorethread;

/**
 * @author jefferywu
 * @version Id: YieldThread, v 0.1 18/2/9 上午11:09 jefferywu Exp $
 */
public class YieldThread extends Thread {

    private String name;

    public YieldThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("线程:" + this.name + ",第" + i + "次，开始运行!");
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            /*if (i ==30) {
                this.yield();
            }*/
        }
    }
}
