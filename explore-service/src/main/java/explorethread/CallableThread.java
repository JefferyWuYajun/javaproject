package explorethread;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author jefferywu
 * @version Id: CallableThread, v 0.1 18/2/9 下午2:36 jefferywu Exp $
 */
public class CallableThread implements Callable<Object> {

    private String taskNum;

    public CallableThread(String taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateBegin = new Date();
        Thread.sleep(Integer.parseInt(taskNum) * 1000);
        Date dateEnd = new Date();
        long excuteTime = dateEnd.getTime() - dateBegin.getTime();
        System.out.println("<<<" + taskNum + "任务终止,执行时间:" + excuteTime);
        return taskNum + "任务返回运行结果，当前任务时间[" + excuteTime + "]毫秒";
    }
}
