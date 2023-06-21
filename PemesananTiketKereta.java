import java.util.Scanner;

public class PemesananTiketKereta {

    public static void main(String[] args) {
        String[] rute = {"Jakarta - Bandung", "Jakarta - Surabaya", "Jakarta - Yogyakarta", "Jakarta - Semarang", "Jakarta - Solo"};
        int[] hargaEkonomi = {100000, 200000, 300000, 400000, 500000};
        int[] hargaBisnis = {200000, 400000, 600000, 800000, 1000000};
        int[] jumlahTiketEkonomi = new int[rute.length];
        int[] jumlahTiketBisnis = new int[rute.length];
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Sistem Pemesanan Tiket Kereta =======");
        System.out.print("Masukkan nama Anda: ");
        String nama = scanner.nextLine();

        System.out.println("====== Daftar Rute Kereta =======");
        for (int i = 0; i < rute.length; i++) {
            System.out.println((i + 1) + ". " + rute[i]);
        }

        System.out.print("Pilih rute (masukkan nomor rute yang ingin dipesan): ");
        int pilihanRute = scanner.nextInt();

        if (pilihanRute < 1 || pilihanRute > rute.length) {
            System.out.println("Pilihan rute tidak tersedia!");
            scanner.close();
            return;
        }

        System.out.println("Pilih jenis tiket:");
        System.out.println("1. Ekonomi");
        System.out.println("2. Bisnis");
        System.out.print("Masukkan jenis tiket (1-2): ");
        int jenisTiket = scanner.nextInt();

        if (jenisTiket < 1 || jenisTiket > 2) {
            System.out.println("Jenis tiket tidak valid!");
            scanner.close();
            return;
        }

        System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
        int jumlahTiketDipesan = scanner.nextInt();

        if (jenisTiket == 1) {
            jumlahTiketEkonomi[pilihanRute - 1] = jumlahTiketDipesan;
        } else {
            jumlahTiketBisnis[pilihanRute - 1] = jumlahTiketDipesan;
        }

        System.out.println("Pemesan tiket adalah " + nama + ":");

        int totalHargaEkonomi = 0;
        int totalHargaBisnis = 0;

        for (int i = 0; i < rute.length; i++) {
            if (jumlahTiketEkonomi[i] > 0) {
                System.out.println(rute[i] + " - Jenis tiket: Ekonomi, Jumlah tiket: " + jumlahTiketEkonomi[i] + ", Harga: Rp" + (hargaEkonomi[i] * jumlahTiketEkonomi[i]));
                totalHargaEkonomi += hargaEkonomi[i] * jumlahTiketEkonomi[i];
            }
            if (jumlahTiketBisnis[i] > 0) {
                System.out.println(rute[i] + " - Jenis tiket: Bisnis, Jumlah tiket: " + jumlahTiketBisnis[i] + ", Harga: Rp" + (hargaBisnis[i] * jumlahTiketBisnis[i]));
                totalHargaBisnis += hargaBisnis[i] * jumlahTiketBisnis[i];
            }
        }

        int totalHarga = totalHargaEkonomi + totalHargaBisnis;
        System.out.println("Total Harga: Rp" + totalHarga);

        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Kartu Kredit");
        System.out.println("2. Transfer Bank");
        System.out.println("3. OVO");
        System.out.print("Masukkan metode pembayaran (1-3): ");
        int metodePembayaran = scanner.nextInt();

        switch (metodePembayaran) { //digunakan untuk mengevaluasi pilihan
            case 1:
                System.out.println("Anda telah memilih metode pembayaran Kartu Kredit.");
                // Lakukan proses pembayaran menggunakan Kartu Kredit
                break;
            case 2:
                System.out.println("Anda telah memilih metode pembayaran Transfer Bank.");
                // Lakukan proses pembayaran menggunakan Transfer Bank
                break;
            case 3:
                System.out.println("Anda telah memilih metode pembayaran OVO.");
                // Lakukan proses pembayaran menggunakan OVO
                break;
            default:
                System.out.println("Metode pembayaran tidak valid!");
                break;
        }

        scanner.close();
    }
}
