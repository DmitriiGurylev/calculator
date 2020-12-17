import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame(){
        setTitle("Calculator"); // название рамки
        CalculatorPanel panel = new CalculatorPanel();
        add(panel); // добавляет панель в рамку
        //pack(); // устанавливает такой размер контейнера, при котором отображаются все элементы; ПОКА НЕ ПОНЯЛ, НУЖЕН ЭТОТ МЕТОД ИЛИ НЕТ
    }
}
