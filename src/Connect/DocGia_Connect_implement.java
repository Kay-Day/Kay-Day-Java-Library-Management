package Connect;

import Model.Docgia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DocGia_Connect_implement implements DocGia_Connect{


    @Override
    public List<Docgia> getAllDocgia() {
        String sql = "select * from TaiKhoan";
        List<Docgia> listAlldg = new ArrayList<>();
        try{
            PreparedStatement stm = connectionSQL.getConnection().prepareStatement(sql);
            ResultSet allDocgia = null;
            allDocgia = stm.executeQuery();
            while(allDocgia.next()) {
                listAlldg.add(new Docgia(allDocgia.getString(1),allDocgia.getString(3),allDocgia.getString(4), Integer.parseInt(allDocgia.getString(5)),allDocgia.getString(6),allDocgia.getString(7)));
            }
            return listAlldg;



        }catch(SQLException e){
            Logger.getLogger(DocGia_Connect_implement.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }

    @Override
    public int addDocgia(Docgia dg) {
        String sql =  "insert into TaiKhoan(maTaiKhoan, matKhau, tenNguoiDung, ngaySinh, gioiTinh, email, sdt)"
                + "values (?,?,?,?,?,?,?)";
        try{
           PreparedStatement stm = connectionSQL.getConnection().prepareStatement(sql);
           stm.setString(1, dg.getMaTK());
           stm.setString(2,"abc123");
           stm.setString(3,dg.getTenTk());
           stm.setString(4,dg.getNgaySinh());
           stm.setString(5,Integer.toString(dg.getGioiTinh()));
           stm.setString(6,dg.getEmail());
           stm.setString(7,dg.getSdt());

           return stm.executeUpdate();

        }catch(SQLException e){
           Logger.getLogger(DocGia_Connect_implement.class.getName()).log(Level.SEVERE,null,e);

        }
        return 0;
    }

    @Override
    public int deleteDocgia(String madocgia) {
        String sql = "update TaiKhoan set status = 0 where maTaiKhoan = ?";
        try{
            PreparedStatement stm = connectionSQL.getConnection().prepareStatement(sql);
            stm.setString(1,madocgia);
            return stm.executeUpdate();



        }catch (SQLException e){
            Logger.getLogger(DocGia_Connect_implement.class.getName()).log(Level.SEVERE,null,e);

        }
        return 0;
    }

    @Override
    public int updateDocgia(Docgia dg) {
//        String sql ="update TaiKhoan set tenNguoiDung =?  where maTaiKhoan = ?";
        String sql = "update TaiKhoan set tenNguoiDung = ?,ngaySinh= ?, gioiTinh= ? , email= ?, sdt=?  where maTaiKhoan = ?";
        try{
            PreparedStatement stm = connectionSQL.getConnection().prepareStatement(sql);
            stm.setString(1, dg.getTenTk());
            stm.setString(2, dg.getNgaySinh());
            stm.setString(3,Integer.toString(dg.getGioiTinh()));
            stm.setString(4, dg.getEmail());
            stm.setString(5, dg.getSdt());
            stm.setString(6, dg.getMaTK());
            System.out.println(dg.getTenTk());
            System.out.println(dg.getMaTK());
            return stm.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DocGia_Connect_implement.class.getName()).log(Level.SEVERE,null,e);

        }
        return 0;
    }

    @Override
    public Docgia searchDg(String madocgia) {
        String sql = "select * from TaiKhoan where maTaiKhoan = ?";
        try{
            PreparedStatement stm = connectionSQL.getConnection().prepareStatement(sql);
            ResultSet allDocgia = null;
            stm.setString(1,madocgia);
            allDocgia = stm.executeQuery();
            while (allDocgia.next()){
                return (new Docgia(allDocgia.getString(1),allDocgia.getString(3),allDocgia.getString(4),Integer.parseInt(allDocgia.getString(5)),allDocgia.getString(6),allDocgia.getString(7)));

            }

        }catch(SQLException e){
            Logger.getLogger(DocGia_Connect_implement.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }

    @Override
    public int getOneDocgia(String madocgia) {
        String sql = "select [status] from TaiKhoan where maTaiKhoan = ?";
        try{
            PreparedStatement stm = connectionSQL.getConnection().prepareStatement(sql);
            ResultSet oneDocgia = null;
            stm.setString(1,madocgia);
            oneDocgia = stm.executeQuery();

            while (oneDocgia.next()){
                return oneDocgia.getInt(1);

            }
        }catch (SQLException e){
            Logger.getLogger(DocGia_Connect_implement.class.getName()).log(Level.SEVERE,null,e);
        }
        return 0;
    }

    @Override
    public int unlock(String madocgia) {
        String sql ="update TaiKhoan set status = 1 where maTaiKhoan = ?";
        try{
            PreparedStatement stm = connectionSQL.getConnection().prepareStatement(sql);
            stm.setString(1, madocgia);
            return stm.executeUpdate();
        }catch (SQLException e){
            Logger.getLogger(DocGia_Connect_implement.class.getName()).log(Level.SEVERE,null,e);

        }
        return 0;
    }
}
