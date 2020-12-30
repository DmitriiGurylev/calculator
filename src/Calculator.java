import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calculator {

    Calculator(){
        JFrame calculatorFrame = new JFrame("Calculator"); // создает окно калькулятора c называнием рамки
        calculatorFrame.setLocationRelativeTo(null);
        calculatorFrame.setSize(500,300); // задает размер окна
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрывает процесс
        calculatorFrame.add(new CalculatorPanel()); // добавляет панель в окно калькулятора
        calculatorFrame.setVisible(true); // задает видимоcть фигуры
        calculatorFrame.setResizable(false);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}
