import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalculatorPanel extends JPanel {
    private JLabel display;
    private JPanel panel;

    String s0 = ""; // первое число
    String s1 = ""; // оператор
    String s2 = ""; // второе число
    double result = 0; // результат

    public CalculatorPanel(){
        setLayout(new BorderLayout());
        display = new JLabel("0"); // добавляет дисплей
        display.setEnabled(false); // не позволяет взаимодействовать с полем дисплея
        add(display, BorderLayout.NORTH); // отображает дисплей сверху
        panel = new JPanel(); // добавление панели
        panel.setLayout(new GridLayout(5,4, 2,2)); // табличное расположение
        add(panel); // добавляет панель
        panel.setVisible(true);

        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton bEqual = new JButton("=");
        JButton bPlus = new JButton("+");
        JButton bMinus = new JButton("-");
        JButton bMultiply = new JButton("*");
        JButton bDivide = new JButton("/");
        JButton bDelete = new JButton("C");
        JButton bDot = new JButton(".");

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bDelete);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bMultiply);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bDivide);
        panel.add(b0);
        panel.add(bDot);
        panel.add(bEqual);
        panel.add(bMinus);
        panel.add(bPlus);

        panel.setBackground(Color.GRAY);

        b0.addActionListener(this::valuePerformed);
        b1.addActionListener(this::valuePerformed);
        b2.addActionListener(this::valuePerformed);
        b3.addActionListener(this::valuePerformed);
        b4.addActionListener(this::valuePerformed);
        b5.addActionListener(this::valuePerformed);
        b6.addActionListener(this::valuePerformed);
        b7.addActionListener(this::valuePerformed);
        b8.addActionListener(this::valuePerformed);
        b9.addActionListener(this::valuePerformed);
        bPlus.addActionListener(this::operatorPerformed);
        bMultiply.addActionListener(this::operatorPerformed);
        bMinus.addActionListener(this::operatorPerformed);
        bEqual.addActionListener(this::operatorPerformed);
        bDot.addActionListener(this::valuePerformed);
        bDivide.addActionListener(this::operatorPerformed);
        bDelete.addActionListener(this::operatorPerformed);
    }

    private void valuePerformed(ActionEvent ae) {
        char ch = ae.getActionCommand().charAt(0);
        if (!s0.equals("") && result == Double.valueOf(s0) && s1.equals("")){
            result = 0;
            s0 = ""+ch;
        }

        else{
            if (s1.equals("")){
                if ((s0.equals("0") || s0.equals("")) && ch == '0')
                {}
                else {
                    s0 = s0+ch;
                }
            }

            else{
                if ((s0.equals("0") || s0.equals("")) && ch == '0')
                {}
                else {
                    s2 = s2 + ch;
                }
            }
        }
        display.setText(
                (s0.equals("") && s1.equals("") && s2.equals("")) ?
                        "0" :
                        (s0+s1+s2)
        );
    }
    private void operatorPerformed(ActionEvent ae) {
        char ch = ae.getActionCommand().charAt(0);

        if (ch == 'C'){
            s0=s1=s2="";
            display.setText("0");
        }

        else if (ch == '='){
            if (!s2.equals("")){
                switch (s1) {
                    case "+" -> result = Double.parseDouble(s0) + Double.parseDouble(s2);
                    case "-" -> result = Double.parseDouble(s0) - Double.parseDouble(s2);
                    case "*" -> result = Double.parseDouble(s0) * Double.parseDouble(s2);
                    case "/" -> result = Double.parseDouble(s0) / Double.parseDouble(s2);
                }
            }
            else{
                result = (s0.equals("")) ? 0 : Double.parseDouble(s0);
            }
            if (result % 1 != 0){
                display.setText(""+result);
            }
            else{
                display.setText(""+ (int)result);
            }

            s0 = Double.toString(result);
            s1=s2="";
        }

        else{
            s1 = Character.toString(ch);
            display.setText(s0+s1+s2);
        }
    }
}

