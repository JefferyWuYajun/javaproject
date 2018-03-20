package zk.app;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author jefferywu
 * @version Id: ConnectionWatcher, v 0.1 18/3/20 下午3:11 jefferywu Exp $
 */
public class ConnectionWatcher implements Watcher {

    private static final int SESSION_TIMEOUT = 5000;

    private CountDownLatch connectedSingle = new CountDownLatch(1);

    protected ZooKeeper zk;


    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            connectedSingle.countDown();
        }
    }

    public void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        connectedSingle.await(3, TimeUnit.SECONDS);
    }

    public void close() throws InterruptedException {
        zk.close();
    }
}
