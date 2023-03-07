package DichVu;

import Connect.BanDoc_Connect;
import Model.BanDoc;

import java.util.List;

public class BanDoc_Dv {
    private BanDoc_Connect banDoc_connect;
    public BanDoc_Dv(){
        banDoc_connect = new BanDoc_Connect();
    }
    public List<BanDoc> getDSBanDocForFind(){
    return banDoc_connect.getDSBanDocForFind();
    }
}
