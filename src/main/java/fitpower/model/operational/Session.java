package fitpower.model.operational;

import java.util.HashMap;

public class Session extends Meeting {

    public final HashMap<String, Session> sessionMap = new HashMap<>();

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
