import java.util.Scanner;

public class nomorTiga {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split("-");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            year += (year < 50) ? 2000 : 1900;

            String[] bulan = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            };

            
            int[] hariPerBulan = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
            };

            
            if (isKabisat(year)) {
                hariPerBulan[1] = 29;
            }

            
            if (month < 1 || month > 12 || day < 1 || day > hariPerBulan[month - 1]) {
                System.out.println("Tanggal tidak valid.");
            } else {
                System.out.println(day + " " + bulan[month - 1] + " " + year);
            }

        } catch (Exception e) {
            System.out.println("Format input salah! Gunakan format dd-mm-yy.");
        } finally {
            scanner.close();
        }
    }

    public static boolean isKabisat(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
