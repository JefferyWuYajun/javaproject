package zk.app.config;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.Random;

/**
 * @author jefferywu
 * @version Id: ConfigUpdater, v 0.1 18/3/20 下午3:26 jefferywu Exp $
 */
public class ConfigUpdater {

    public static final String PATH = "/config";

    private ActiveKeyValueStore activeKeyValueStore;

    private Random random = new Random();

    public ConfigUpdater(String hosts) throws IOException, InterruptedException {
        activeKeyValueStore = new ActiveKeyValueStore();
        activeKeyValueStore.connect(hosts);
    }

    public void manualSetData(String value, int version) throws KeeperException, InterruptedException {

        activeKeyValueStore.write(PATH, value, version);
    }

    public void manualClose() throws InterruptedException {
        activeKeyValueStore.close();
    }

    public void manualGetSessionId() {
        System.out.println(activeKeyValueStore.getSessionId());
    }

    public void run() throws KeeperException, InterruptedException {
        while (true) {
            String value = random.nextInt(100) + "";
            activeKeyValueStore.write(PATH, value, -1);
            System.out.printf("Set %s to %s\n", PATH, value);
            Thread.sleep(8000);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ConfigUpdater configUpdater = new ConfigUpdater("127.0.0.1:2181");

        //configUpdater.run();
        Thread.sleep(1000);

        configUpdater.manualGetSessionId();

        configUpdater.manualClose();

        configUpdater.manualSetData("900", -1);
    }
}
