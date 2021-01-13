import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AboutWindow extends JFrame {

    public AboutWindow(){
        JFrame aboutWindowFrame = new JFrame("About");
        aboutWindowFrame.setSize(600,400);
        aboutWindowFrame.setLocationRelativeTo(null);
        JPanel aboutPanel = new JPanel();
        aboutWindowFrame.add(aboutPanel);
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
        JLabel headImage;

        try {
            String imagePath = "C:\\Users\\NewUser\\Desktop\\calculator\\src\\resources\\info.png";
            BufferedImage img = ImageIO.read(new File(imagePath));
            Image scaledImg = img.getScaledInstance(70,70,Image.SCALE_SMOOTH);
            headImage = new JLabel(new ImageIcon(scaledImg));
            headImage.setSize(70,70);
            headImage.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
            aboutPanel.add(headImage);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        JLabel description = new JLabel();
        description.setText("<html><h2 align=center>What is this?</h2>" +
                "This calculator has been created by Dmitry Gurylev (Moscow) " +
                "as a pet project. <br><br>" +
                "e-mail: \"gurylev.dmitrii@mail.ru\"  <br>" +
                "inst: \"" +
                "<a href=\"https://www.instagram.com/dmitrygurylev/\">@dmitrygurylev</a>" +
                "\" <br>" +
                "facebook: \"gurylev.dmitrii\"  <br>"+
                " </html>");
        description.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        aboutPanel.add(description);

        aboutWindowFrame.setVisible(true);
        aboutWindowFrame.setResizable(false);
        aboutPanel.setEnabled(true);

    }
}


