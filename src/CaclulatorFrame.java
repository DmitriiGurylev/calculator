import javax.swing.*;

public class CaclulatorFrame extends JFrame {
    public CaclulatorFrame(){
        setTitle("Calculator"); // название рамки
        setBounds(300,400, 300,300); // задает положение и размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрывает процесс
        add(new CalculatorPanel()); // добавляет панель в окно калькулятора
        setVisible(true); // задает видимоcть фигуры

    }
}
