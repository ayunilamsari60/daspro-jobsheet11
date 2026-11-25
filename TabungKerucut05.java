
import java.util.Scanner;

public class TabungKerucut05 {

    public static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    public static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    public static double luasPermukaanTabung(double r, double t) {
        return 2 * luasLingkaran(r) + 2 * Math.PI * r * t;
    }

    public static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;
        double r, t, hasil;

        do {
            System.out.println("\n===== MENU PERHITUNGAN =====");
            System.out.println("1. Luas Lingkaran");
            System.out.println("2. Volume Tabung");
            System.out.println("3. Luas Permukaan Tabung");
            System.out.println("4. Volume Kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();

                    hasil = luasLingkaran(r);
                    System.out.println("Luas lingkaran: " + hasil);
                    break;

                case 2:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    t = input.nextDouble();

                    hasil = volumeTabung(r, t);
                    System.out.println("Volume tabung: " + hasil);
                    break;

                case 3:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    t = input.nextDouble();

                    hasil = luasPermukaanTabung(r, t);
                    System.out.println("Luas permukaan tabung: " + hasil);
                    break;

                case 4:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    t = input.nextDouble();

                    hasil = volumeKerucut(r, t);
                    System.out.println("Volume kerucut: " + hasil);
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);

        input.close();
    }
}
