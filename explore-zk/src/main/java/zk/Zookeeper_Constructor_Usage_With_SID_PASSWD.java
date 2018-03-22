package zk;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author jefferywu
 * @version Id: Zookeeper_Constructor_Usage_With_SID_PASSWD, v 0.1 18/3/22 下午4:10 jefferywu Exp $
 */
public class Zookeeper_Constructor_Usage_With_SID_PASSWD implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static final String HOST_ADDRESS = "127.0.0.1:2181";

    private static final int SESSION_TIMEOUT = 5000;

    @Override
    public void process(WatchedEvent event) {
        System.out.println("收到事件:" + event.getType() + "," + event.getState());
        if (event.getState() == Event.KeeperState.SyncConnected){
            countDownLatch.countDown();
        } else {
            System.out.println(event);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        ZooKeeper zooKeeper = new ZooKeeper(HOST_ADDRESS, SESSION_TIMEOUT, new Zookeeper_Constructor_Usage_With_SID_PASSWD());
        countDownLatch.await();

        long sessionId = zooKeeper.getSessionId();
        byte[] sessionPasswd = zooKeeper.getSessionPasswd();

        //zooKeeper = new ZooKeeper(HOST_ADDRESS, SESSION_TIMEOUT, new Zookeeper_Constructor_Usage_With_SID_PASSWD(), 1L, "test".getBytes());

        System.out.println("---------");

        ZooKeeper zooKeeper2 = new ZooKeeper(HOST_ADDRESS, SESSION_TIMEOUT, new Zookeeper_Constructor_Usage_With_SID_PASSWD(), sessionId, sessionPasswd);
        Thread.sleep(2000);

        System.out.println(zooKeeper.getState());
        System.out.println(zooKeeper2.getState());


        //Thread.sleep(Integer.MAX_VALUE);
    }
}
