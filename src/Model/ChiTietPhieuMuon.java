package Model;

public class ChiTietPhieuMuon {
    private String maPM = "";
    private String maSach = "";
    private String ngayThucTra = "";
    private String tinhTrangSach = "";
    private int tienPhat = 0;

    public ChiTietPhieuMuon(){

    }
// Constructor
    public ChiTietPhieuMuon(String maPM, String maSach, String ngayThucTra, String tinhTrangSach, int tienPhat) {
        this.maPM = maPM;
        this.maSach = maSach;
        this.ngayThucTra = ngayThucTra;
        this.tinhTrangSach = tinhTrangSach;
        this.tienPhat = tienPhat;
    }

    public ChiTietPhieuMuon(String maPM, String valueOf) {
    }

    public String getMaPM() {
        return maPM;
    }

    public void setMaPM(String maPM) {
        this.maPM = maPM;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNgayThucTra() {
        return ngayThucTra;
    }

    public void setNgayThucTra(String ngayThucTra) {
        this.ngayThucTra = ngayThucTra;
    }

    public String getTinhTrangSach() {
        return tinhTrangSach;
    }

    public void setTinhTrangSach(String tinhTrangSach) {
        this.tinhTrangSach = tinhTrangSach;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }
}
