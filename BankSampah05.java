
import java.util.Scanner;

public class BankSampah05 {

    public static double[] inputSetoran(int n, Scanner input) {
        double[] setoran = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + ": ");
            setoran[i] = input.nextDouble();
        }

        return setoran;
    }

    public static void tampilSetoran(double[] setoran) {
        System.out.println("\n===== DATA SETORAN =====");

        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    public static double totalSetoran(double[] setoran) {
        double total = 0;

        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }

        return total;
    }

    public static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    public static int nasabahTerbanyak(double[] setoran) {
        int indeksTerbesar = 0;

        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeksTerbesar]) {
                indeksTerbesar = i;
            }
        }

        return indeksTerbesar;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double hargaPerKg = 3000;

        System.out.print("Masukkan jumlah nasabah: ");
        int n = input.nextInt();

        double[] setoran = inputSetoran(n, input);

        tampilSetoran(setoran);

        System.out.println("\n===== SALDO NASABAH =====");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], hargaPerKg);
            System.out.println("Saldo nasabah ke-" + (i + 1) + ": Rp" + saldo);
        }

        double total = totalSetoran(setoran);
        System.out.println("\nTotal berat seluruh setoran: " + total + " kg");

        int terbesar = nasabahTerbanyak(setoran);
        System.out.println("Nasabah dengan setoran terbesar: Nasabah ke-" + (terbesar + 1));
        System.out.println("Berat setoran terbesar: " + setoran[terbesar] + " kg");

        input.close();
    }
}
