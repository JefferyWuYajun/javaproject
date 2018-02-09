package explorethread;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author jefferywu
 * @version Id: CallableThreadTest, v 0.1 18/2/9 下午2:40 jefferywu Exp $
 */
public class CallableThreadTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void CallableThreadTest() throws ExecutionException, InterruptedException, TimeoutException {
        //线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //创建多个有返回值的任务
        List<Future> futures = Lists.newArrayList();
        //线程计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        //计时器
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("创建线程");
        for (int i = 0; i < 5; i++) {
            CallableThread callable = new CallableThread(String.valueOf(i + 1), countDownLatch);
            futures.add(pool.submit(callable));
        }
        stopWatch.stop();


        try {
            stopWatch.start("主线程等待");
            countDownLatch.await(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.warn("countDownLatch异常", e);
        } finally {
            stopWatch.stop();
        }

        //获取线程返回的结果
        final int[] i = {0};
        futures.forEach((Future item) -> {
            i[0]++;
            stopWatch.start("线程:" + i[0] + "取值");
            try {
                logger.info(item.get(0, TimeUnit.SECONDS).toString());
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                logger.error("从子线程:" + i[0] + "获取值异常", e);
            }
            stopWatch.stop();
        });

        //关闭线程池
        pool.shutdown();

        logger.info(stopWatch.prettyPrint());

        //防止主线程结束,子线程还未跑完
        Thread.sleep(10000);
    }
}
