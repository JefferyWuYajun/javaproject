package explorethread;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author jefferywu
 * @version Id: CallableThreadTest, v 0.1 18/2/9 下午2:40 jefferywu Exp $
 */
public class CallableThreadTest {

    @Test
    public void CallableThreadTest() throws ExecutionException, InterruptedException, TimeoutException {
        //线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //创建多个有返回值的任务
        List<Future> futures = Lists.newArrayList();

        for (int i = 0; i < 5; i++) {
            Callable callable = new CallableThread(String.valueOf(i + 1));
            futures.add(pool.submit(callable));
        }

        pool.shutdown();

        //获取线程返回的结果
        futures.forEach((Future item) -> {
            try {
                System.out.println(item.get(3, TimeUnit.SECONDS).toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        });

    }
}
