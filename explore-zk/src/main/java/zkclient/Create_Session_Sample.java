package zkclient;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author wyj40124
 * @version Id: Create_Session_Sample, v 0.1 2018/3/15 13:37 wyj40124 Exp $
 */
public class Create_Session_Sample {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181",5000);
        String path = "/appconfig";
        //zkClient.createPersistent(path, true);
        zkClient.deleteRecursive(path);
        System.out.println("zookeeper session established");
    }
}