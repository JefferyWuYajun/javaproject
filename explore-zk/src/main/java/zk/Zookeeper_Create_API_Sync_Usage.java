package zk;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.*;

/**
 * 创建节点-同步方式
 *
 * @author wyj40124
 * @version Id: zk.Zookeeper_Create_API_Sync_Usage, v 0.1 2018/3/15 10:18 wyj40124 Exp $
 */
public class Zookeeper_Create_API_Sync_Usage implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws IOException,InterruptedException,KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Zookeeper_Create_API_Sync_Usage());
        System.out.println(zooKeeper.getState());
        countDownLatch.await();

        String path1 = zooKeeper.create("/zk-test","jeffery".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println("Success create znode: " + path1);
    }
}