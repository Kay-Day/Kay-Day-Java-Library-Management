package Connect;

import Model.DanhMucSach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhMucSach_Connect {
    public List<DanhMucSach> getDSDanhMucSach(){
        List<DanhMucSach> dms = new ArrayList<DanhMucSach>();
        Connection connection = connectionSQL.getConnection();
        String sql = "SELECT * FROM DanhMucSach";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                DanhMucSach danhmuc = new DanhMucSach();

                danhmuc.setMaDM(rs.getString("maDMSach"));
                danhmuc.setTenDM(rs.getString("tenDMSach"));

                dms.add(danhmuc);

            }
        }catch(SQLException e){}
          return dms ;
    }
    public void addDanhMucSach(DanhMucSach danhmuc){
        Connection connection = connectionSQL.getConnection();
        String sql = "INSERT INTO DanhMucSach VALUES (?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, danhmuc.getMaDM());
            preparedStatement.setString(2, danhmuc.getTenDM());

            preparedStatement.executeUpdate();

        }catch (Exception e){

        }
    }
    public boolean checkMaDM(String maDM){
        Connection connection = connectionSQL.getConnection();
        String sql ="SELECT * FROM DanhMucSach WHERE maDMSach like '%" + maDM +"%'";
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

        }catch(Exception e){

        }
        return false;
    }
    public void updateDanhMucSach(DanhMucSach danhmuc){
        Connection connection = connectionSQL.getConnection();
        String sql = "UPDATE DanhMucSach SET maDMSach = ?, tenDMSach = ? WHERE maDMSach = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, danhmuc.getMaDM());
            preparedStatement.setString(2,danhmuc.getTenDM());
            preparedStatement.setString(3, danhmuc.getMaDM());
        }catch (Exception e){

        }
    }
}
