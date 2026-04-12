class AlatCamping {
    // private
    private String namaAlat;
    private String penyewa;
    private int lamaSewa;
    private boolean statusKembali;

    // constructor superclass
    public AlatCamping(String namaAlat, String penyewa, int lamaSewa) {
        this.namaAlat = namaAlat;
        this.penyewa = penyewa;
        this.lamaSewa = lamaSewa;
        this.statusKembali = false;
    }

    // getter
    public String getNamaAlat() {
        return namaAlat;
    }

    public String getPenyewa() {
        return penyewa;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public boolean getStatusKembali() {
        return statusKembali;
    }

    // --- OVERLOADING 1 ---
    // setter dengan parameter
    public void setStatusKembali(boolean statusKembali) {
        this.statusKembali = statusKembali;
    }

    // setter tanpa parameter (Overload)
    public void setStatusKembali() {
        this.statusKembali = true;
    }

    // --- OVERLOADING 2 ---
    // tambah sewa dengan parameter
    public void tambahLamaSewa(int tambahanHari) {
        this.lamaSewa += tambahanHari;
    }

    // tambah sewa tanpa parameter (Overload, default 1 hari)
    public void tambahLamaSewa() {
        this.lamaSewa += 1;
    }

    // --- OVERRIDING 1 (Superclass) ---
    public void tampilData() {
        System.out.println("Nama Alat  : " + this.namaAlat);
        System.out.println("Penyewa    : " + this.penyewa);
        System.out.println("Lama Sewa  : " + this.lamaSewa + " hari");
        if (this.statusKembali) {
            System.out.println("Status     : Sudah kembali");
        } else {
            System.out.println("Status     : Masih disewa");
        }
    }

    // --- OVERRIDING 2 (Superclass) ---
    public void caraPerawatan() {
        System.out.println("Perawatan  : Bersihkan alat setelah digunakan.");
    }
}

// subclass 1: Tenda
class Tenda extends AlatCamping {
    private int kapasitasOrang;

    public Tenda(String namaAlat, String penyewa, int lamaSewa, int kapasitasOrang) {
        super(namaAlat, penyewa, lamaSewa);
        this.kapasitasOrang = kapasitasOrang;
    }

    @Override
    public void tampilData() {
        super.tampilData();
        System.out.println("Spesifikasi: Tenda Kapasitas " + this.kapasitasOrang + " Orang");
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan  : Pastikan tenda kering sebelum dilipat agar tidak berjamur.");
    }
}

// subclass 2: Carrier
class Carrier extends AlatCamping {
    private int kapasitasLiter;

    public Carrier(String namaAlat, String penyewa, int lamaSewa, int kapasitasLiter) {
        super(namaAlat, penyewa, lamaSewa);
        this.kapasitasLiter = kapasitasLiter;
    }

    @Override
    public void tampilData() {
        super.tampilData();
        System.out.println("Spesifikasi: Carrier Ukuran " + this.kapasitasLiter + " Liter");
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan  : Jangan dicuci di mesin cuci, sikat perlahan jika kotor.");
    }
}

// subclass 3: SleepingBag
class SleepingBag extends AlatCamping {
    private String bahan;

    public SleepingBag(String namaAlat, String penyewa, int lamaSewa, String bahan) {
        super(namaAlat, penyewa, lamaSewa);
        this.bahan = bahan;
    }

    @Override
    public void tampilData() {
        super.tampilData();
        System.out.println("Spesifikasi: Sleeping Bag Bahan " + this.bahan);
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan  : Angin-anginkan setelah dipakai, hindari deterjen keras.");
    }
}