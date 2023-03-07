
package Connect;

import Model.Sach_Th;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sach_Connect_implement implements Sach_Connect_Th{

    @Override
    public List<Sach_Th> getAllSach() {
        String sql = "select * from Sach";
        List<Sach_Th> allSach = new ArrayList<>();
        try {
            PreparedStatement pre = connectionSQL.getConnection().prepareStatement(sql);
            ResultSet sach = pre.executeQuery();
            while(sach.next()) {
                //Lấy dòng
                allSach.add(new Sach_Th(sach.getString(2), sach.getString(5), sach.getString(6), sach.getInt(8)));
            }
            return allSach;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Connect_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Sach_Th> getSachByCategory(String category) {
        String sql = "select * from Sach where maDMSach = ?";
        List<Sach_Th> allSach = new ArrayList<>();
        try {
            PreparedStatement pre = connectionSQL.getConnection().prepareStatement(sql);
            pre.setString(1, category);
            ResultSet sach = pre.executeQuery();
            while(sach.next()) {
                allSach.add(new Sach_Th(sach.getString(2), sach.getString(5), sach.getString(6), sach.getInt(8)));
            }
            return allSach;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Connect_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Sach_Th> getSachByTheloai(String theloai) {
        String sql = "select * from Sach where maTheLoai = ?";
        List<Sach_Th> allSach = new ArrayList<>();
        try {
            PreparedStatement pre = connectionSQL.getConnection().prepareStatement(sql);
            pre.setString(1, theloai);
            ResultSet sach = pre.executeQuery();
            while(sach.next()) {
                allSach.add(new Sach_Th(sach.getString(2), sach.getString(5), sach.getString(6), sach.getInt(8)));
            }
            return allSach;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Connect_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public List<Sach_Th> getSachBySearch(String searchString) {
        String sql = "select * from Sach where tenSach like ?";
        List<Sach_Th> searchSach = new ArrayList<>();
        try {
            PreparedStatement pre = connectionSQL.getConnection().prepareStatement(sql);
            pre.setString(1, searchString);
            ResultSet sach = pre.executeQuery();
            while(sach.next()) {
                searchSach.add(new Sach_Th(sach.getString(2), sach.getString(5), sach.getString(6), sach.getInt(8)));
            }
            return searchSach;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Connect_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
