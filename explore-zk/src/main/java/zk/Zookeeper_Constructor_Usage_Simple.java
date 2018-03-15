package zk;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author wyj40124
 * @version Id: zk.Zookeeper_Constructor_Usage_Simple, v 0.1 2018/3/13 13:53 wyj40124 Exp $
 */
public class Zookeeper_Constructor_Usage_Simple implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Received watched event:" + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            /*try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws IOException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000, new Zookeeper_Constructor_Usage_Simple());
        System.out.println(zk.getState());

        try {
            countDownLatch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Zookeeper session established");
    }
}