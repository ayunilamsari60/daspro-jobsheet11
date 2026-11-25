import java.util.Scanner;

public class Kafe05 {

    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman.");
        }

        System.out.println("\n===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga05(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        if (pilihanMenu < 1 || pilihanMenu > 6) {
            return -1;
        }

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;

        return hargaTotal;
    }

    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        int diskon = 0;

        if (kodePromo.equals("DISKON50")) {
            diskon += total * 50 / 100;
        } else if (kodePromo.equals("DISKON30")) {
            diskon += total * 30 / 100;
        } else {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            diskon += total * 10 / 100;
        }

        return diskon;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = sc.nextLine();

        System.out.print("Apakah Anda member? (y/n): ");
        char status = sc.next().charAt(0);

        boolean isMember = (status == 'y' || status == 'Y');

        System.out.print("Masukkan jam kunjung: ");
        int jamKunjung = sc.nextInt();

        Menu(namaPelanggan, isMember, jamKunjung);

        System.out.print("\nMasukkan jumlah jenis menu yang ingin dipesan: ");
        int jumlahMenu = sc.nextInt();

        int totalBayar = 0;

        for (int i = 1; i <= jumlahMenu; i++) {
            System.out.print("\nMasukkan nomor menu ke-" + i + ": ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Menu tidak tersedia");
                i--;
                continue;
            }

            System.out.print("Masukkan jumlah item: ");
            int banyakItem = sc.nextInt();

            totalBayar += hitungTotalHarga05(pilihanMenu, banyakItem);
        }

        System.out.print("\nMasukkan kode promo: ");
        String kodePromo = sc.next();

        int diskon = hitungDiskon(totalBayar, kodePromo, isMember);

        int totalAkhir = totalBayar - diskon;

        System.out.println("\n===== RINCIAN PEMBAYARAN =====");
        System.out.println("Total harga  : Rp " + totalBayar);
        System.out.println("Besar diskon : Rp " + diskon);
        System.out.println("Total bayar  : Rp " + totalAkhir);

        sc.close();
    }
}