import java.util.Scanner;

public class RekapLaundry05 {

    public static void inputData(Scanner input, int[][] data,
            String[] namaLayanan, int[] hargaPerKg) {

        for (int i = 0; i < data.length; i++) {
            System.out.println("\n" + namaLayanan[i]);

            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Berat cucian Hari ke-" + (j + 1) + ": ");
                data[i][j] = input.nextInt();
            }
        }
    }

    public static void tampilData(int[][] data,
            String[] namaLayanan, int[] hargaPerKg) {

        System.out.println("\n================ REKAP BERAT CUCIAN ================");

        System.out.printf("%-18s %12s", "Layanan", "Harga/kg");

        for (int j = 0; j < data[0].length; j++) {
            System.out.printf("%10s", "Hari ke-" + (j + 1));
        }

        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-18s Rp%-10d", namaLayanan[i], hargaPerKg[i]);

            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%10d", data[i][j]);
            }

            System.out.println();
        }
    }

    public static int totalPerLayanan(int[][] data, int idLayanan) {
        int total = 0;

        for (int j = 0; j < data[idLayanan].length; j++) {
            total += data[idLayanan][j];
        }

        return total;
    }

    public static void tampilLayananTerbanyak(int[][] data,
            String[] namaLayanan) {

        int indeksTerbesar = 0;

        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) >
                    totalPerLayanan(data, indeksTerbesar)) {
                indeksTerbesar = i;
            }
        }

        System.out.println("\nLayanan dengan berat cucian tertinggi: "
                + namaLayanan[indeksTerbesar]);
        System.out.println("Total berat: "
                + totalPerLayanan(data, indeksTerbesar) + " kg");
    }

    public static int hariTersibuk(int[] data) {
        int indeksTerbesar = 0;

        for (int i = 1; i < data.length; i++) {
            if (data[i] > data[indeksTerbesar]) {
                indeksTerbesar = i;
            }
        }

        return indeksTerbesar;
    }

    public static void tampilPendapatan(int[][] data,
            String[] namaLayanan, int[] hargaPerKg) {

        double totalPendapatan = 0;

        System.out.println("\n================ PENDAPATAN LAUNDRY ================");

        for (int i = 0; i < data.length; i++) {
            double pendapatan =
                    (double) totalPerLayanan(data, i) * hargaPerKg[i];

            System.out.println(namaLayanan[i] + ": Rp" + pendapatan);
            totalPendapatan += pendapatan;
        }

        System.out.println("Total pendapatan: Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = input.nextInt();

        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = input.nextInt();
        input.nextLine();

        String[] namaLayanan = new String[jumlahLayanan];
        int[] hargaPerKg = new int[jumlahLayanan];
        int[][] data = new int[jumlahLayanan][jumlahHari];

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.print("\nMasukkan nama layanan ke-" + (i + 1) + ": ");
            namaLayanan[i] = input.nextLine();

            System.out.print("Masukkan harga per kg: ");
            hargaPerKg[i] = input.nextInt();
            input.nextLine();
        }

        inputData(input, data, namaLayanan, hargaPerKg);

        tampilData(data, namaLayanan, hargaPerKg);

        System.out.println("\n================ TOTAL PER LAYANAN ================");

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println(namaLayanan[i] + ": "
                    + totalPerLayanan(data, i) + " kg");
        }

        tampilLayananTerbanyak(data, namaLayanan);

        int[] totalPerHari = new int[jumlahHari];

        for (int j = 0; j < jumlahHari; j++) {
            for (int i = 0; i < jumlahLayanan; i++) {
                totalPerHari[j] += data[i][j];
            }
        }

        int hariTerbesar = hariTersibuk(totalPerHari);

        System.out.println("\nHari tersibuk: Hari ke-" + (hariTerbesar + 1));
        System.out.println("Total cucian: " + totalPerHari[hariTerbesar] + " kg");

        tampilPendapatan(data, namaLayanan, hargaPerKg);

        input.close();
    }
}
