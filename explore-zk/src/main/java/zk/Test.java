package zk;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.apache.zookeeper.server.SessionTrackerImpl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author jefferywu
 * @version Id: Test, v 0.1 2018/4/22 下午2:32 jefferywu Exp $
 */
public class Test {

    private static final int TICKETTIME = 100;

    public static void main(String[] args) {

        //key为sessionId
        HashMap<String, SessionSample> sessionsById = new HashMap<>();
        //key为下次超时时间点
        HashMap<Long, List<SessionSample>> sessionsByExpirationTime = Maps.newHashMap();

        //将session放入map中
        for (int i = 0; i < 10; i++) {
            SessionSample sessionSample = new SessionSample(String.valueOf(i), i * 30 + 1, "name"+i);
            sessionsById.put(sessionSample.getSessionId(),sessionSample);
            long nextExpirationTime = caulateNextExpiration(sessionSample.getExirationTime());
            if (sessionsByExpirationTime.get(nextExpirationTime) == null){
                sessionsByExpirationTime.put(nextExpirationTime, Lists.newArrayList());
            }
            sessionsByExpirationTime.get(nextExpirationTime).add(sessionSample);
        }

        System.out.println(sessionsByExpirationTime);


    }

    public static long caulateNextExpiration(long expirationTime){
        return  (expirationTime / 100 + 1) * 100;
    }

    public static class SessionSample implements Serializable {

        private static final long serialVersionUID = 831441582538212135L;

        private String sessionId;
        private long expirationTime;
        private String name;

        public SessionSample(String sessionId, long expirationTime, String name) {
            this.sessionId = sessionId;
            this.expirationTime = expirationTime;
            this.name = name;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public long getExirationTime() {
            return expirationTime;
        }

        public void setExirationTime(long expirationTime) {
            this.expirationTime = expirationTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


