package zk.detailcase;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * 创建节点-同步方式
 *
 * @author wyj40124
 * @version Id: zk.detailcase.Zookeeper_Create_API_Sync_Usage, v 0.1 2018/3/15 10:18 wyj40124 Exp $
 */
public class Zookeeper_Create_API_Sync_Usage implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Zookeeper_Create_API_Sync_Usage());
        countDownLatch.await();


//        String rootpath = zooKeeper.create("/test", "test-root-path".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//        String path1 = zooKeeper.create("/test/zk-test-", "jeffery".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);

        Stat stat = new Stat();
        String value = new String(zooKeeper.getData("/test", new getDataWatch(), stat));
        System.out.println("节点值: " + value);
        Thread.sleep(Integer.MAX_VALUE);
    }


}

class getDataWatch implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        System.out.println("state:" + event.getState());
        System.out.println("type:" + event.getType());
    }
}