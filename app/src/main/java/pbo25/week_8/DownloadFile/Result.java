package pbo25.week_8.DownloadFile;

public class Result {
    int fileId;
    String threadName;
    int duration;
    String status;

    Result(int fileId, String threadName, int duration, String status) {
        this.fileId = fileId;
        this.threadName = threadName;
        this.duration = duration;
        this.status = status;
    }
}
