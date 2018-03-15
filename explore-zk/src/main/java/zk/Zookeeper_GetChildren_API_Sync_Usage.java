package zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author wyj40124
 * @version Id: zk.Zookeeper_GetChildren_API_Sync_Usage, v 0.1 2018/3/15 10:43 wyj40124 Exp $
 */
public class Zookeeper_GetChildren_API_Sync_Usage implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;

    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        } else if (event.getType() == Event.EventType.NodeChildrenChanged) {
            try {
                System.out.println("ReGet Child:" + zk.getChildren(event.getPath(), true));
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws IOException,InterruptedException,KeeperException {
        String path = "/zk-book-1";
        zk = new ZooKeeper("127.0.0.1:2181", 5000, new Zookeeper_GetChildren_API_Sync_Usage());
        connectedSemaphore.await();

        try {
            zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("success create znode: " + path);

        zk.create(path + "/c1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("success create znode: " + path + "/c1");

        List<String> childrenList = zk.getChildren(path, true);
        System.out.println(childrenList);

        zk.create(path + "/c2", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("success create znode: " + path + "/c2");
        Thread.sleep(1000);

        zk.create(path + "/c3", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("success create znode: " + path + "/c3");
        Thread.sleep(Integer.MAX_VALUE);
    }
}