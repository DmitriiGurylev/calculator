import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AboutWindow extends JFrame {

    public AboutWindow(){
        JFrame aboutWindowFrame = new JFrame("About");
        aboutWindowFrame.setLocationRelativeTo(null);
        aboutWindowFrame.setSize(600,400);
        aboutWindowFrame.setLayout(new BorderLayout());


        try {
            String imagePath = "C:\\Users\\NewUser\\Desktop\\calculator\\src\\resources\\info.png";
            BufferedImage img = ImageIO.read(new File(imagePath));
            Image scaledImg = img.getScaledInstance(70,70,Image.SCALE_SMOOTH);
            JLabel headImage = new JLabel(new ImageIcon(scaledImg));
            headImage.setSize(70,70);
            aboutWindowFrame.add(headImage);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        JLabel description = new JLabel();
        aboutWindowFrame.add(description);
        description.setText("<html><h2>What is this?</h2>" +
                "This calculator has been created by Dmitry Gurylev (Moscow) " +
                "as a pet project. <br><br>" +
                "e-mail: \"gurylev.dmitrii@mail.ru\"  <br>" +
                "inst: \"@dmitrygurylev\" <br>" +
                "facebook: \"gurylev.dmitrii\"  <br>"+
                " </html>");
        aboutWindowFrame.setVisible(true);
        aboutWindowFrame.setResizable(false);
    }
}


