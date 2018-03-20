package zk.app.config;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.io.IOException;

/**
 * @author jefferywu
 * @version Id: ConfigWatcher, v 0.1 18/3/20 下午3:38 jefferywu Exp $
 */
public class ConfigWatcher implements Watcher {

    private ActiveKeyValueStore activeKeyValueStore;

    public ConfigWatcher(String hosts) throws IOException, InterruptedException {
        activeKeyValueStore = new ActiveKeyValueStore();
        activeKeyValueStore.connect(hosts);
    }

    public void displayConfig() throws KeeperException, InterruptedException {
        String value = activeKeyValueStore.read(ConfigUpdater.PATH, this);
        System.out.printf("Read %s as %s\n", ConfigUpdater.PATH, value);
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getType() == Event.EventType.NodeDataChanged) {
            try {
                displayConfig();
            } catch (KeeperException e) {
                System.err.println(e);
            } catch (InterruptedException e) {
                System.err.println(e);
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ConfigWatcher configWatcher= new ConfigWatcher("127.0.0.1:2181");
        configWatcher.displayConfig();
        Thread.sleep(Long.MAX_VALUE);
    }
}
