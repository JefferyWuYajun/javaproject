package zk.detailcase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author wyj40124
 * @version Id: zk.detailcase.Zookeeper_Constructor_Usage_Simple, v 0.1 2018/3/13 13:53 wyj40124 Exp $
 */
public class Zookeeper_Constructor_Usage_Simple implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zk;

    @Override
    public void process(WatchedEvent event) {
        System.out.println("【接收到回调事件】Received watched event:" + event.getState());
        if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws Exception {
        //实例化zookeeper
        zk = new ZooKeeper("127.0.0.1:2181", 5000, new Zookeeper_Constructor_Usage_Simple());
        //获取zk状态
        System.out.println(zk.getState());
        try {
            countDownLatch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(zk.getState());
        Stat stat = new Stat();
        String rslt = new String(zk.getData("/app", false, stat));
        System.out.println("getData()结果:" + rslt);
        System.out.println("Zookeeper session established");
        zk.close();
        System.out.println(zk.getState());
        //Thread.sleep(10000);
    }
}