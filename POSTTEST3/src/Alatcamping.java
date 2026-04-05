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

    // setter
    public void setStatusKembali(boolean statusKembali) {
        this.statusKembali = statusKembali;
    }

    // method untuk menampilkan data superclass
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
}

// subclass 1: Tenda
class Tenda extends AlatCamping {
    private int kapasitasOrang;

    public Tenda(String namaAlat, String penyewa, int lamaSewa, int kapasitasOrang) {
        super(namaAlat, penyewa, lamaSewa);
        this.kapasitasOrang = kapasitasOrang;
    }

    public void tampilData() {
        super.tampilData();
        System.out.println("Spesifikasi: Tenda Kapasitas " + this.kapasitasOrang + " Orang");
    }
}

// subclass 2: Carrier
class Carrier extends AlatCamping {
    private int kapasitasLiter;

    public Carrier(String namaAlat, String penyewa, int lamaSewa, int kapasitasLiter) {
        super(namaAlat, penyewa, lamaSewa);
        this.kapasitasLiter = kapasitasLiter;
    }

    public void tampilData() {
        super.tampilData();
        System.out.println("Spesifikasi: Carrier Ukuran " + this.kapasitasLiter + " Liter");
    }
}

// subclass 3: SleepingBag
class SleepingBag extends AlatCamping {
    private String bahan;

    public SleepingBag(String namaAlat, String penyewa, int lamaSewa, String bahan) {
        super(namaAlat, penyewa, lamaSewa);
        this.bahan = bahan;
    }

    public void tampilData() {
        super.tampilData();
        System.out.println("Spesifikasi: Sleeping Bag Bahan " + this.bahan);
    }
}