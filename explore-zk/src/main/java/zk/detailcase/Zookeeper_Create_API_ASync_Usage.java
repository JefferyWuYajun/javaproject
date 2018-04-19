package zk.detailcase;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.*;

/**
 * 创建节点-异步方式
 *
 * @author wyj40124
 * @version Id: zk.detailcase.Zookeeper_Create_API_ASync_Usage, v 0.1 2018/3/15 10:27 wyj40124 Exp $
 */
public class Zookeeper_Create_API_ASync_Usage implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Zookeeper_Create_API_ASync_Usage());
        System.out.println(zooKeeper.getState());
        countDownLatch.await();

        zooKeeper.create("/zk-test", "jeffery2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL, new IStringCallbackImpl(), "");


        Thread.sleep(Integer.MAX_VALUE);
    }
}

class IStringCallbackImpl implements AsyncCallback.StringCallback {

    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        System.out.println("Create path result: [" + rc + ", " + path + ", " + ctx + ", real path name: " + name);
    }
}