package pbo25.week_7.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs;

    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

    public void logActivity(String activity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " " + activity;
        logs.add(logEntry);
    }

    public String getLogs() {
        if (logs.isEmpty()) {
            return "Tidak ada log aktivitas.";
        }
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}