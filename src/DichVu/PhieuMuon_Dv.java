package DichVu;

import Connect.PhieuMuon_Connect;
import Connect.PhieuMuon_Connect;
import Model.PhieuMuon;
import java.util.List;

public class PhieuMuon_Dv {
    private PhieuMuon_Connect pmDAO;
    public PhieuMuon_Dv() {
        pmDAO = new PhieuMuon_Connect();
    }

    public List<PhieuMuon> getAllDSPhieuMuon() {
        return pmDAO.getAllDSPhieuMuon();
    }

    public List<PhieuMuon> getDSPhieuMuon() {
        return pmDAO.getDSPhieuMuon();
    }

    public void addPhieuMuon(PhieuMuon phieuMuon) {
        pmDAO.addPhieuMuon(phieuMuon);
    }

    public void updatePhieuMuon(PhieuMuon phieuMuon) {
        pmDAO.updatePhieuMuon(phieuMuon);
    }

    public String getMaPMInserted() {
        return pmDAO.getMaPMInserted();
    }
}