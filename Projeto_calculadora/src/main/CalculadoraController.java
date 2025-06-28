package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CalculadoraController {
    public static double Calcular (double num1, double num2, String operator, JFrame parent){
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(parent, "Erro: Divisão por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return num1;
                }
            default:
                JOptionPane.showMessageDialog(parent, "Erro: Operação invalida", "Erro", JOptionPane.ERROR_MESSAGE);
                return num1;
        }
    }
}
