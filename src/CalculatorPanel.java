import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.activation.ActivationGroupDesc;

public class CalculatorPanel extends JPanel {
    private double result;
    private String lastCommand;
    private boolean start;
    private JLabel display;
    private JPanel panel;

    private void addButton(String label, ActionListener listener){
        JButton button = new JButton(label); // новый экземпляр кнопки
        button.addActionListener(listener); // добавление обработчика событий
        panel.add(button); // при вызове метода addButton кнопка добавляется на панель
    }

    public CalculatorPanel(){
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

        display = new JLabel("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();
        ActionListener clear = new ClearAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(5,4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", insert);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", insert);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", insert);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", insert);
        addButton("+", insert);
        addButton("C+", insert);
        add(panel, BorderLayout.CENTER);
    }

    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    private class ClearAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display.setText("0");
        }
    }

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String command = evt.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                } else
                    lastCommand = command;
            } else {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    public void calculate(double x) {
        if (lastCommand.equals("+"))
            result += x;
        else if (lastCommand.equals("-"))
            result -= x;
        else if (lastCommand.equals("*"))
            result *= x;
        else if (lastCommand.equals("/"))
            result /= x;
        else if (lastCommand.equals("="))
            result = x;
        display.setText("" + result);
    }
}
