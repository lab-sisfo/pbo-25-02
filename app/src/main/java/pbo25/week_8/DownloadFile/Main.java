package main.java.pbo25.week_8.DownloadFile;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    static int successfulDownloads = 0;
    static int completedDownloads = 0;
    static int totalFiles;
    static boolean allDone = false;
    static ArrayList<Result> results = new ArrayList<>();

    // ✅ TODO (1)
    public static synchronized void recordResult(int fileId, int duration, String threadName) {
        String status = (duration <= 2) ? "Success" : "Timeout";

        if (status.equals("Success")) {
            successfulDownloads++;
        }

        completedDownloads++;
        results.add(new Result(fileId, threadName, duration, status));
    }

    public static void main(String[] args) {

        // ✅ TODO (2)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of files to download: ");
        totalFiles = scanner.nextInt();

        // ✅ TODO (3)
        ExecutorService downloadExecutor = Executors.newFixedThreadPool(3);
        ExecutorService uiExecutor = Executors.newSingleThreadExecutor();

        // Mencatat waktu mulai
        long startTime = System.currentTimeMillis();

        // ✅ TODO (4)
        uiExecutor.execute(() -> {
            int seconds = 0;
            while (!allDone) {
                try {
                    Thread.sleep(1000);
                    seconds++;
                    System.out.println("Downloading files... (" + seconds + "s)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // ✅ TODO (5)
        for (int i = 1; i <= totalFiles; i++) {
            int fileId = i;
            downloadExecutor.execute(() -> {
                Random rand = new Random();
                int duration = rand.nextInt(3) + 1; // 1 to 3 seconds

                try {
                    Thread.sleep(duration * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String threadName = Thread.currentThread().getName();
                recordResult(fileId, duration, threadName);
            });
        }

        // ✅ TODO (6)
        downloadExecutor.shutdown();

        // ✅ TODO (7)
        try {
            downloadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ✅ TODO (8)
        allDone = true;
        uiExecutor.shutdown();
        try {
            uiExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mencatat total waktu proses secara keseluruhan
        long endTime = System.currentTimeMillis();
        int totalTime = (int) ((endTime - startTime) / 1000);

        // Header tabel
        System.out.println("--------------------------------------------------");
        System.out.println("                  Detailed Report                 ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s | %-18s | %-8s | %-8s%n",
                "File ID", "Thread", "Duration", "Status");
        System.out.println("--------------------------------------------------");

        // Urutkan hasil berdasarkan fileId
        results.sort(Comparator.comparingInt(r -> r.fileId));

        // Tampilan hasil setiap proses download dalam bentuk table
        for (Result r : results) {
            System.out.printf("%-8d | %-18s | %-8s | %-8s%n",
                    r.fileId, r.threadName, r.duration + "s", r.status);
        }

        // Ringkasan Proses
        System.out.println("--------------------------------------------------");
        System.out.println("                     Summary                      ");
        System.out.println("--------------------------------------------------");
        System.out.println("Successful downloads : " + successfulDownloads);
        System.out.println("Failed downloads     : " + (totalFiles - successfulDownloads));
        System.out.printf("Total time           : %ds%n", totalTime);
    }
}
