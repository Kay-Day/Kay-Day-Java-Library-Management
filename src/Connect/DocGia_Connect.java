package Connect;

import Model.Docgia;

import java.util.List;

public interface DocGia_Connect {
    public List<Docgia> getAllDocgia();
    public int addDocgia (Docgia dg);
    public int deleteDocgia (String madocgia);
    public int updateDocgia (Docgia dg);
    public Docgia searchDg (String madocgia);
    public int getOneDocgia(String madocgia);
    public int unlock (String madocgia);
}
