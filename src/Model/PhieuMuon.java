package Model;

public class PhieuMuon {
    private String maPM = "";
    private String ngayMuon = "";
    private int soNgayMuon = 0;
    private String maTaiKhoan = "";
    private String maCanBo = "";
    private String ghiChu = "";
    private String trangThai = "Chưa trả";

    public PhieuMuon(){

    }
    // Constructor

    public PhieuMuon(String maPM, String ngayMuon, int soNgayMuon, String maTaiKhoan, String maCanBo, String ghiChu, String trangThai) {
        this.maPM = maPM;
        this.ngayMuon = ngayMuon;
        this.soNgayMuon = soNgayMuon;
        this.maTaiKhoan = maTaiKhoan;
        this.maCanBo = maCanBo;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public String getMaPM() {
        return maPM;
    }

    public void setMaPM(String maPM) {
        this.maPM = maPM;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public int getSoNgayMuon() {
        return soNgayMuon;
    }

    public void setSoNgayMuon(int soNgayMuon) {
        this.soNgayMuon = soNgayMuon;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
