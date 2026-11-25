
public class PengunjungCafe05 {

    public static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Nomor Meja: " + nomorMeja);
        System.out.println("Daftar Nama Pengunjung:");

        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static int hitungTotalBelanja(int... harga) {
    int total = 0;

    for (int nilai : harga) {
            total += nilai;
        }

        return total;
    }

    public static void main(String[] args) {
        int total1 = hitungTotalBelanja(15000);
        int total3 = hitungTotalBelanja(15000, 20000, 10000);
        int total5 = hitungTotalBelanja(15000, 20000, 10000, 12000, 18000);

        System.out.println("Total belanja 1 harga: Rp " + total1);
        System.out.println("Total belanja 3 harga: Rp " + total3);
        System.out.println("Total belanja 5 harga: Rp " + total5);
    }
}
