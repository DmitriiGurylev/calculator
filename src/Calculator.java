import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calculator {
   public static void main(String[] args){
       EventQueue.invokeLater(new Runnable() { // посылвает задание потока на очередь
           @Override
           public void run(){
               CalculatorFrame cFrame = new CalculatorFrame(); // представляет собой главное окно калькулятора
               cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрывает процесс
               cFrame.setBounds(300,400, 300,300); // задает положение и размер окна
//               cFrame.setLocation(300,300);
//               cFrame.setSize(300,400);
               cFrame.setVisible(true); // задает видимоcть фигуры
           }
   });
}
}
