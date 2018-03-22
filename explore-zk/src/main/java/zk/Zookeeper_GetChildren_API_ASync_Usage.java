package zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author jefferywu
 * @version Id: Zookeeper_GetChildren_API_ASync_Usage, v 0.1 18/3/22 下午5:11 jefferywu Exp $
 */
public class Zookeeper_GetChildren_API_ASync_Usage implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper = null;

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            if (event.getType() == Event.EventType.None && event.getPath() == null) {
                countDownLatch.countDown();
            } else if (event.getType() == Event.EventType.NodeChildrenChanged) {
                try {
                    System.out.println("重新获取子节点:" + zooKeeper.getChildren(event.getPath(), true));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Zookeeper_GetChildren_API_ASync_Usage());
        countDownLatch.await();

        String path = "/zk-bookk";
        zooKeeper.create(path, "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zooKeeper.create(path + "/c1", "11".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        zooKeeper.getChildren(path, true, new ChildrenChange(), null);

        zooKeeper.create(path + "/c2", "22".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        Thread.sleep(Integer.MAX_VALUE);

    }

    public static class ChildrenChange implements AsyncCallback.ChildrenCallback {

        @Override
        public void processResult(int rc, String path, Object ctx, List<String> children) {
            System.out.println(rc + "&&" + path + "&&" + ctx + "&&" + children);
        }
    }
}
