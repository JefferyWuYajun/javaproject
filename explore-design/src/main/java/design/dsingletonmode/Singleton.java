package design.dsingletonmode;

/**
 * @author wyj40124
 * @version Id: Singleton, v 0.1 2018/3/9 14:44 wyj40124 Exp $
 */
public class Singleton {

    private Singleton() {
    }

    public void eat(){
        System.out.println("吃东西");
    }

    public void drink() {
        System.out.println("喝东西");
    }

    /**
     *    类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     *    没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private static class SingleHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingleHolder.instance;
    }
}