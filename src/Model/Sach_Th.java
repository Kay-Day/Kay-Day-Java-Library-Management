package Model;

public class Sach_Th {
    private String tenSach;
    private String tacgia;
    private String nhaSB;
    private int soluong;

    //Constructor

    public Sach_Th(String tenSach, String tacgia, String nhaSB, int soluong) {
        this.tenSach = tenSach;
        this.tacgia = tacgia;
        this.nhaSB = nhaSB;
        this.soluong = soluong;
    }
    public Sach_Th(){

    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNhaSB() {
        return nhaSB;
    }

    public void setNhaSB(String nhaSB) {
        this.nhaSB = nhaSB;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
