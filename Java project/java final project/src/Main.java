import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.border.*;
import java.awt.Image;

public class Main {
    public static void main(String[] args) throws Exception {


        MyFrame popup = new MyFrame();

        JPanel buttons = new JPanel();

        popup.add(buttons);

        buttons.setPreferredSize(new Dimension(600, 200));
        buttons.setBounds(0, 200, 1560, 602);
        buttons.setBackground(Color.BLACK);

        //popup.setResizable(false);

        

    }
} 




