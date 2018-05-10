package zk;

import java.util.HashMap;
import java.util.Map;

/**
 * 链式编程
 * 每个方法（接口）的返回值都是this（当前对象），调用多个方法时一直用点号添加。
 * 好处：这样写法的好处在于一方面可以尽可能少去进行类型转换的判定，而且大大增强了代码的阅读性，同时也减少了代码量
 * @author jefferywu
 * @version Id: Test2, v 0.1 2018/4/28 上午11:35 jefferywu Exp $
 */
public class Test2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("start:");
        stringBuilder.append("test1").append(",").append("test2");
        System.out.println(stringBuilder.toString());

        MemberInfoChain memberInfoChain = new MemberInfoChain();
        //memberInfoChain.otherInfo = "aa,";
        memberInfoChain.setId("111")
                .setName("jeffery")
                .setBaseInfo("age",10)
                .setBaseInfo("memberLevel","TT")
                .setOtherInfo("o1,")
                .setOtherInfo("o2,")
                .setOtherInfo("o3,");

        System.out.println(memberInfoChain);
    }


    public static class MemberInfoChain {

        private String id;
        private String name;
        private Map<String, Object> baseInfo;
        private String otherInfo;

        public MemberInfoChain setId(String id) {
            this.id = id;
            return this;
        }

        public MemberInfoChain setName(String name) {
            this.name = name;
            return this;
        }

        public MemberInfoChain setBaseInfo(String key, Object value) {
            if(this.baseInfo == null){
                this.baseInfo = new HashMap<>();
            }
            this.baseInfo.put(key,value);
            return this;
        }


        public MemberInfoChain setOtherInfo(String otherInfo) {
            this.otherInfo = new String(new StringBuffer().append(this.otherInfo).append(otherInfo));
            return this;
        }

        @Override
        public String toString() {
            return "MemberInfoChain{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", baseInfo=" + baseInfo +
                    ", otherInfo='" + otherInfo + '\'' +
                    '}';
        }
    }
}
