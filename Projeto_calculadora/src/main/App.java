package main;

import ui.CalculadoraGUI;

public class App {
    public static void main(String[] args) throws Exception {
        javax.swing.SwingUtilities.invokeLater(()->{
            CalculadoraGUI calc = new CalculadoraGUI();
            calc.setVisible(true);
        });
    }
}
