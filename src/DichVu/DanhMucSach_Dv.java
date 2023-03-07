package DichVu;

import Connect.DanhMucSach_Connect;
import Model.DanhMucSach;

import javax.swing.*;
import java.util.List;

public class DanhMucSach_Dv {
    private DanhMucSach_Connect dmsDao;
    public DanhMucSach_Dv(){
        dmsDao = new DanhMucSach_Connect();
    }
    public List<DanhMucSach> getDSDanhMucSach(){
        return dmsDao.getDSDanhMucSach();
    }
    public boolean checkMaDM(String maDM){
        return dmsDao.checkMaDM(maDM);
    }
    public void addDanhMucSach(DanhMucSach danhmuc, String maDM){
        if(!dmsDao.checkMaDM(maDM)){
            dmsDao.addDanhMucSach(danhmuc);
            JOptionPane.showMessageDialog(null,"Bạn đã thêm thành công");

        }else {
            JOptionPane.showMessageDialog(null,"Lỗi ! Trùng mã danh mục");
        }
    }
    public void updateDanhMucSach(DanhMucSach danhmuc){
        dmsDao.updateDanhMucSach(danhmuc);
        JOptionPane.showMessageDialog(null,"Bạn đã sửa thành công!");

    }

}
