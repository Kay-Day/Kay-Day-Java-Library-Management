package Connect;

import Model.BanDoc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BanDoc_Connect {
    public List<BanDoc> getDSBanDocForFind(){
    List<BanDoc> listBanDoc = new ArrayList<BanDoc>();
        Connection connection = connectionSQL.getConnection();
        String sql = "SELECT * FROM TaiKhoan";
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                BanDoc banDoc = new BanDoc();
                banDoc.setMaTK(rs.getString("maTaiKhoan"));
                banDoc.setMatkhau(rs.getString("matKhau"));
                banDoc.setTenNguoiDung(rs.getString("tenNguoiDung"));
                banDoc.setNgaySinh(rs.getString("ngaySinh"));
                banDoc.setGioiTinh(rs.getString("gioiTinh"));
                banDoc.setEmail(rs.getString("email"));
                banDoc.setSdt(rs.getString("sdt"));
                banDoc.setStatus(rs.getInt("status"));
                banDoc.setSoLuongMuon(rs.getInt("soLuongMuon"));

                listBanDoc.add(banDoc);

            }
        }catch(SQLException e){

        }
        return listBanDoc;
    }
}

