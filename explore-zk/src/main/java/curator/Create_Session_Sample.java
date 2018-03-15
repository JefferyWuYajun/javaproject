package curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author wyj40124
 * @version Id: Create_Session_Sample, v 0.1 2018/3/15 13:52 wyj40124 Exp $
 */
public class Create_Session_Sample {
    public static void main(String[] args) throws Exception {

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
        curatorFramework.start();
        System.out.println("zookeeper session established");

        CuratorFramework client1 = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")
                .sessionTimeoutMs(5000).retryPolicy(retryPolicy).namespace("base").build();
        client1.start();
        client1.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/test","test1-value".getBytes());
        System.out.println("Zookeeper session2 established. ");
    }
}