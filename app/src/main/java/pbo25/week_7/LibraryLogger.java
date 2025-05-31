import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs;

    public LibraryLogger() {
        logs = new ArrayList<>();
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String log = timestamp + " " + activity;
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
