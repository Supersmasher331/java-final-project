
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.border.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame  implements ActionListener {

    JButton button;
    JButton button1;
    JButton button2;

    MyFrame() {

        this.setTitle("Sound Wave"); // creates a title for the popup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes the window when you press the red x in the top
        // right corner
        this.setResizable(true); // lets the frame be resized
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setSize(1000, 800); // sets the dimensio0ns of the frame

        ImageIcon waveImage = new ImageIcon("C:\\Users\\dhruv\\Downloads\\sound.png"); // takes the sound image
        // downloaded onto the computer
        this.setIconImage(waveImage.getImage()); // sets the logo of the popup

        this.setVisible(true); // makes the frame visible

    
        createButtons();
        createLabels();

        JPanel title = new JPanel();
        add(title);

        title.setPreferredSize(new Dimension(600, 200));
        title.setBounds(0, 0, 1560, 500);
        title.setBackground(Color.BLACK);
        title.add(label);

        

        
    }

    private void createButtons() {

        button = new JButton();
        button.setBounds(205, 600, 200, 60);
        button.setText("Learn More!");
        button.setFocusable(false);
        button.setFont(new Font("Calibri", Font.BOLD, 25));
        button.setIconTextGap(-20);
        button.setForeground(Color.red);
        button.setBackground(Color.white);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener(this);
        add(button);

        button1 = new JButton();
        button1.setBounds(650, 600, 200, 60);
        button1.setText("Play Demo!");
        button1.setFocusable(false);
        button1.setFont(new Font("Calibri", Font.BOLD, 25));
        button1.setIconTextGap(-20);
        button1.setForeground(Color.red);
        button1.setBackground(Color.white);
        button1.setBorder(BorderFactory.createEtchedBorder());
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton();
        button2.setBounds(1075, 600, 200, 60);
        button2.setText("Exit");
        button2.setFocusable(false);
        button2.setFont(new Font("Calibri", Font.BOLD, 25));
        button2.setIconTextGap(-20);
        button2.setForeground(Color.red);
        button2.setBackground(Color.white);
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.addActionListener(this);
        add(button2);
    }

    JLabel label = new JLabel("Sound Waves demo"); //creates and sets the text of the label

    private void createLabels(){

        ImageIcon mainScreenLogo = new ImageIcon(new ImageIcon("C:\\Users\\dhruv\\Downloads\\sound.png").getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT)); //gets the image, sets it as the icon and rescales it 
        Border screenBorder = BorderFactory.createLineBorder(Color.green, 1); //sets the border of the panel to black

        label.setIcon(mainScreenLogo); //puts the image mainLogo inside the label 
        label.setHorizontalTextPosition(JLabel.CENTER); //puts the text in the center of the main logo
        label.setVerticalTextPosition(JLabel.TOP); //puts the text above the main logo
        label.setForeground(new Color(0x00FF00)); //changes the colour of the text
        label.setFont(new Font("MV Boli", Font.PLAIN,50));
        label.setIconTextGap(25); //sets a gap of 25px in between the picture and the text
        label.setBackground(Color.black); //sets the background colour of the text label to black
        label.setOpaque(true); //makes the background colour visible
        label.setBorder(screenBorder); //sets a border for the screen
        label.setVerticalAlignment(JLabel.TOP); //centers the picture and lable vertically
        label.setHorizontalAlignment(JLabel.CENTER); //centers the picture and label horizontally

        
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == button) {

            learnMore lrnMre = new learnMore();
            dispose();

        } else if (a.getSource() == button1) {
            System.exit(0);
        } else if (a.getSource() == button2) {
            System.exit(0);
        }
    }

}


