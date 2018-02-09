package explorethread;

/**
 * @author jefferywu
 * @version Id: MyThread, v 0.1 18/2/9 下午2:59 jefferywu Exp $
 */
public class MyThread extends Thread {

    private static int num = 0;

    public MyThread() {
        num++;
    }

    public int getNum(){
        return num;
    }

    @Override
    public void run() {
        System.out.println("主动创建的第" + num + "个线程");
    }
}
