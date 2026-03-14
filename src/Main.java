import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<AlatCamping> daftar = new ArrayList<>();

        int pilihan;
        do {
            System.out.println("\n=== Sistem Penyewaan & Monitoring Pengembalian Alat Camping ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Update Status Pengembalian");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            // create
            if (pilihan == 1) {

                System.out.print("Nama Alat: ");
                String alat = input.nextLine();

                System.out.print("Nama Penyewa: ");
                String penyewa = input.nextLine();

                System.out.print("Lama Sewa (hari): ");
                int lama = input.nextInt();
                input.nextLine();

                AlatCamping data = new AlatCamping(alat, penyewa, lama);
                daftar.add(data);

                System.out.println("Data berhasil ditambahkan.");
            }

            // read
            else if (pilihan == 2) {

                if (daftar.size() == 0) {
                    System.out.println("Belum ada data.");
                } else {

                    for (int i = 0; i < daftar.size(); i++) {

                        AlatCamping data = daftar.get(i);

                        System.out.println("\nData ke-" + (i + 1));
                        System.out.println("Nama Alat  : " + data.getNamaAlat());
                        System.out.println("Penyewa    : " + data.getPenyewa());
                        System.out.println("Lama Sewa  : " + data.getLamaSewa() + " hari");

                        if (data.getStatusKembali()) {
                            System.out.println("Status     : Sudah kembali");
                        } else {
                            System.out.println("Status     : Masih disewa");
                        }
                    }
                }
            }

            // update
            else if (pilihan == 3) {

                System.out.print("Masukkan nomor data yang dikembalikan: ");
                int nomor = input.nextInt();

                if (nomor <= daftar.size()) {

                    AlatCamping data = daftar.get(nomor - 1);
                    data.setStatusKembali(true);

                    System.out.println("Status berhasil diupdate.");
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }

            // delete
            else if (pilihan == 4) {

                System.out.print("Masukkan nomor data yang dihapus: ");
                int nomor = input.nextInt();

                if (nomor <= daftar.size()) {

                    daftar.remove(nomor - 1);
                    System.out.println("Data berhasil dihapus.");
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }

        } while (pilihan != 5);

        System.out.println("Program selesai.");
    }
}