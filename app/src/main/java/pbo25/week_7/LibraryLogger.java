import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LibraryLogger {
    private List<String> logs = new ArrayList<>();
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String logActivity(String activity) {
        String log = dtf.format(LocalDateTime.now()) + " " + activity;
        logs.add(log);
        return log;
    }

    public String getLogs() {
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}