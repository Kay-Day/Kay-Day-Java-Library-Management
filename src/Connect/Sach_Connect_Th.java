package Connect;

import Model.Sach_Th;

import java.util.List;
//        Một Interface trong Java là một bản thiết kế của một lớp. Nó chỉ có các phương thức trừu tượng
//        Interface là một kỹ thuật để thu được tính trừu tượng hoàn toàn và đa kế thừa trong Java.
public interface Sach_Connect_Th {
    public List<Sach_Th> getAllSach ();
    public List<Sach_Th> getSachByCategory(String category);
    public List<Sach_Th> getSachByTheloai(String theloai);
    public List<Sach_Th> getSachBySearch(String searString);
}
