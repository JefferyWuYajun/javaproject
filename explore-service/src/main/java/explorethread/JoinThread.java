package explorethread;

/**
 * @author jefferywu
 * @version Id: JoinThread, v 0.1 18/2/9 上午10:46 jefferywu Exp $
 */
public class JoinThread implements Runnable {

    private String name;

    public JoinThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + name + ",运行结束");
    }
}
