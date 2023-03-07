import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPro extends JFrame{
    public static void main(String[] args) {
     new TestPro().setVisible(true);

    }
    private JButton button1;
    private JButton button2;

    public TestPro() {
        this.setSize(1000,1000);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }


}
