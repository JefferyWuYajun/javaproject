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

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        for (int i = 0; i < 5; i++) {
            Callable callable = new CallableThread(String.valueOf(i + 1));
            futures.add(pool.submit(callable));
        }
        stopWatch.stop();

        //获取线程返回的结果
        futures.forEach((Future item) -> {
            stopWatch.start();
            try {
                logger.info(item.get(3, TimeUnit.SECONDS).toString());
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                logger.error(e.getMessage(), e);
            }
            stopWatch.stop();
        });

        pool.shutdown();

        logger.info(stopWatch.prettyPrint());
    }
}
