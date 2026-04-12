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
            System.out.println("4. Perpanjang Waktu Sewa");
            System.out.println("5. Hapus Data");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            // create
            if (pilihan == 1) {
                System.out.println("\nPilih Jenis Alat:");
                System.out.println("1. Tenda");
                System.out.println("2. Carrier");
                System.out.println("3. Sleeping Bag");
                System.out.print("Pilihan: ");
                int jenis = input.nextInt();
                input.nextLine();

                System.out.print("Nama Alat (Merk/Seri): ");
                String alat = input.nextLine();

                System.out.print("Nama Penyewa: ");
                String penyewa = input.nextLine();

                System.out.print("Lama Sewa (hari): ");
                int lama = input.nextInt();
                input.nextLine();

                if (jenis == 1) {
                    System.out.print("Kapasitas (Orang): ");
                    int kapasitas = input.nextInt();
                    input.nextLine();
                    AlatCamping tendaBaru = new Tenda(alat, penyewa, lama, kapasitas);
                    daftar.add(tendaBaru);
                    System.out.println("Data Tenda berhasil ditambahkan.");

                } else if (jenis == 2) {
                    System.out.print("Kapasitas (Liter): ");
                    int liter = input.nextInt();
                    input.nextLine();
                    AlatCamping carrierBaru = new Carrier(alat, penyewa, lama, liter);
                    daftar.add(carrierBaru);
                    System.out.println("Data Carrier berhasil ditambahkan.");

                } else if (jenis == 3) {
                    System.out.print("Bahan (contoh: Polar/Dacron): ");
                    String bahan = input.nextLine();
                    AlatCamping sbBaru = new SleepingBag(alat, penyewa, lama, bahan);
                    daftar.add(sbBaru);
                    System.out.println("Data Sleeping Bag berhasil ditambahkan.");

                } else {
                    System.out.println("Jenis tidak valid. Batal menambahkan data.");
                }
            }

            // read
            else if (pilihan == 2) {
                if (daftar.size() == 0) {
                    System.out.println("Belum ada data.");
                } else {
                    for (int i = 0; i < daftar.size(); i++) {
                        AlatCamping data = daftar.get(i);
                        System.out.println("\nData ke-" + (i + 1));

                        data.tampilData(); // Overriding 1
                        data.caraPerawatan(); // Overriding 2
                    }
                }
            }

            // update status
            else if (pilihan == 3) {
                System.out.print("Masukkan nomor data yang diupdate: ");
                int nomor = input.nextInt();
                input.nextLine();

                if (nomor > 0 && nomor <= daftar.size()) {
                    AlatCamping data = daftar.get(nomor - 1);

                    System.out.println("1. Update otomatis (Set sudah kembali)");
                    System.out.println("2. Update manual (Pilih status)");
                    System.out.print("Pilihan: ");
                    int opsi = input.nextInt();

                    if (opsi == 1) {
                        data.setStatusKembali(); // Overloading 1 (tanpa parameter)
                        System.out.println("Status berhasil diupdate menjadi sudah kembali.");
                    } else if (opsi == 2) {
                        System.out.print("Masukkan status (true=kembali / false=belum): ");
                        boolean status = input.nextBoolean();
                        data.setStatusKembali(status); // Overloading 1 (dengan parameter)
                        System.out.println("Status berhasil diupdate.");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }

            // update sewa
            else if (pilihan == 4) {
                System.out.print("Masukkan nomor data yang diperpanjang: ");
                int nomor = input.nextInt();
                input.nextLine();

                if (nomor > 0 && nomor <= daftar.size()) {
                    AlatCamping data = daftar.get(nomor - 1);

                    System.out.println("1. Perpanjang otomatis 1 hari");
                    System.out.println("2. Masukkan jumlah hari");
                    System.out.print("Pilihan: ");
                    int opsi = input.nextInt();

                    if (opsi == 1) {
                        data.tambahLamaSewa(); // Overloading 2 (tanpa parameter)
                        System.out.println("Waktu sewa ditambah 1 hari.");
                    } else if (opsi == 2) {
                        System.out.print("Masukkan tambahan hari: ");
                        int hari = input.nextInt();
                        data.tambahLamaSewa(hari); // Overloading 2 (dengan parameter)
                        System.out.println("Waktu sewa ditambah " + hari + " hari.");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }

            // delete
            else if (pilihan == 5) {
                System.out.print("Masukkan nomor data yang dihapus: ");
                int nomor = input.nextInt();

                if (nomor > 0 && nomor <= daftar.size()) {
                    daftar.remove(nomor - 1);
                    System.out.println("Data berhasil dihapus.");
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            }

        } while (pilihan != 6);

        System.out.println("Program selesai.");
    }
}