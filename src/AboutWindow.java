import javax.swing.*;

public class AboutWindow {

    AboutWindow(){
        JFrame aboutWindowFrame = new JFrame("About");
        aboutWindowFrame.setLocationRelativeTo(null);
        aboutWindowFrame.setSize(600,400);

        JLabel description = new JLabel();
        aboutWindowFrame.add(description);
        description.setText("" +
                "This calculator has been created by Dmitry Gurylev (Moscow) " +
                "as a pet project. \n" +
                "e-mail: \"gurylev.dmitrii@mail.ru\" \n" +
                "inst: \"@dmitrygurylev\"" +
                "facebook: \"gurylev.dmitrii\" \n");

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
