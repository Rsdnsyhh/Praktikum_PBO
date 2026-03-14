class AlatCamping {

    // private
    private String namaAlat;
    private String penyewa;
    private int lamaSewa;
    private boolean statusKembali;

    // constructor
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

    // protected
    protected void infoAlat() {
        System.out.println("Informasi alat: " + namaAlat);
    }

    // default
    void tampilStatus() {
        if (statusKembali) {
            System.out.println("Status: Sudah kembali");
        } else {
            System.out.println("Status: Masih disewa");
        }
    }
}