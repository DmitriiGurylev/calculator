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
        Dimension size = new Dimension();
        size.height = 30;
        size.width = 30;
        JButton button = new JButton(label); // новый экземпляр кнопки
        button.addActionListener(listener); // добавление обработчика событий
        panel.add(button); // при вызове метода addButton кнопка добавляется на панель
        //button.setSize(size); // должен быть указан размер кнопки
        //button.setMaximumSize(size);
    }

    public CalculatorPanel(){
        setLayout(new BorderLayout());

        result = 0; // переменная для результата
        lastCommand = "="; // переменная для отображения последней команды
        start = true; // ПОКА НЕ ПОНЯЛ

        display = new JLabel("0"); // добавляет отображение дисплея
        display.setEnabled(false); // не позволяет взаимодействовать с полем дисплея
        Dimension displaySize = new Dimension(30,30);
       // display.setMinimumSize(displaySize); // НЕ ПОНЯЛ
        add(display, BorderLayout.NORTH); // отображает дисплей сверху


        ActionListener insert = new InsertAction(); // обработчик действий: вставить
        ActionListener command = new CommandAction(); // обработчик действий: команда
        ActionListener clear = new ClearAction(); // // обработчик действий: очистить

        panel = new JPanel(); // добавление панели
        panel.setLayout(new GridLayout(5,4, 7,7)); // табличное расположение

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
        add(panel, BorderLayout.CENTER); // добавляет панель в центр
    }

    private class InsertAction implements ActionListener { // обработчик действия: вставить
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input); // отображение на дисплее
        }
    }

    private class ClearAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display.setText("0"); // при очистке удаляет весь текст и ставит "0"
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
        switch (lastCommand) {
            case "+" -> result += x;
            case "-" -> result -= x;
            case "*" -> result *= x;
            case "/" -> result /= x;
            case "=" -> result = x;
        }
        display.setText("" + result);
    }
}
