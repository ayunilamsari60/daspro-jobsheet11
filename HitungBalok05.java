
import java.util.Scanner;

public class HitungBalok05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p, l, t, L, vol, LP;

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nBalok ke-" + i);

            System.out.print("Masukkan panjang: ");
            p = input.nextInt();

            System.out.print("Masukkan lebar: ");
            l = input.nextInt();

            System.out.print("Masukkan tinggi: ");
            t = input.nextInt();

            L = hitungLuas(p, l);
            vol = hitungVolume(t, p, l);
            LP = hitungLuasPermukaanBalok(p, l, t);

            System.out.println("Luas alas: " + L);
            System.out.println("Volume balok: " + vol);
            System.out.println("Luas permukaan balok: " + LP);
        }

        input.close();
    }

    public static int hitungLuas(int pjg, int lb) {
        return pjg * lb;
    }

    public static int hitungVolume(int tinggi, int a, int b) {
        return hitungLuas(a, b) * tinggi;
    }

    public static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t)
                + hitungLuas(l, t));
    }
}
