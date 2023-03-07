package DichVu;

import Connect.ChiTietPM_Connect;
import Connect.ChiTietPM_Connect;
import Model.ChiTietPhieuMuon;
import java.util.List;

public class CTPhieuMuon_Dv {
    private ChiTietPM_Connect ctpmDAO;
    public CTPhieuMuon_Dv() {
        ctpmDAO = new ChiTietPM_Connect();
    }

    public List<ChiTietPhieuMuon> getDSCHiTietPM(String maPhieuMuon) {
        return ctpmDAO.getDSCHiTietPM(maPhieuMuon);
    }

    public void updateChiTietPM(ChiTietPhieuMuon ctpm) {
        ctpmDAO.updateChiTietPM(ctpm);
    }

    public void insertChiTietPM(ChiTietPhieuMuon ctpm) {
        ctpmDAO.insertChiTietPM(ctpm);
    }

    public void deleteChiTietPM(String idPhieuMuon, String idSach) {
        ctpmDAO.deleteChiTietPM(idPhieuMuon, idSach);
    }
}
