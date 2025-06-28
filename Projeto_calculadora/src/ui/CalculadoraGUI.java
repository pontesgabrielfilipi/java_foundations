package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.CalculadoraController;

public class CalculadoraGUI extends JFrame implements ActionListener {
    // iniciando objetos
    private JTextField campoTexto;
    private String operador;
    private double primeiroNumero;
    private boolean novoNumero = true;
    private boolean mostrandoOperador = false;

    // GUI
    public CalculadoraGUI () {
        // Configurações do JFrame
        setTitle("Calculadora");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Configurações do visor da calculadora
        campoTexto = new JTextField("0");
        campoTexto.setEditable(false);
        // campoTexto.setFont(new Font("Arial", Font.BOLD, 32));
        campoTexto.setFont(new Font("Consolas", Font.BOLD, 28));

        setBackground(new Color(34, 34, 34));
        campoTexto.setBackground(new Color(48, 48, 48));
        campoTexto.setForeground(Color.WHITE);

        //Iniciando o painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(5,4,5,5));

        String [] botoes = {
            "C", "", "", "⌫",
            "7", "8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+"
        };

        for (String texto : botoes){
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.PLAIN, 24));
            if (!texto.equals("")) {
                botao.addActionListener(this);
            } else {
                botao.setEnabled(false);
            }
            painelBotoes.add(botao);
        }
        
        setLayout(new BorderLayout(10, 10));
        JPanel painelTexto = new JPanel(new BorderLayout());
        painelTexto.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5)); // top, left, bottom, right
        painelTexto.add(campoTexto, BorderLayout.CENTER);
        add(painelTexto, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
    }

    // Logíca
    @Override
    public void actionPerformed(ActionEvent e){
        String comando = e.getActionCommand();

        if (comando.matches("[0-9]")) {
                if (novoNumero || campoTexto.getText().equals("0") || mostrandoOperador){
                    campoTexto.setText(comando);
                } else {
                    campoTexto.setText(campoTexto.getText() + comando);
                }
                novoNumero = false;
                mostrandoOperador = false;
        } else if (comando.equals(".")){
            if (mostrandoOperador || novoNumero) {
                campoTexto.setText("0.");
                novoNumero = false;
                mostrandoOperador = false;
            } else if (!campoTexto.getText().contains(".")) {
                campoTexto.setText(campoTexto.getText()+".");
            }
        } else if (comando.equals("C")) {
            campoTexto.setText("0");
            operador = null;
            primeiroNumero = 0;
            novoNumero = true;
            mostrandoOperador = false;
        } else if (comando.equals("⌫")) {
            String textoAtual = campoTexto.getText();
            if (mostrandoOperador){
                campoTexto.setText(formataNumero(primeiroNumero));
                mostrandoOperador = false;
                novoNumero = true;
            } else if (textoAtual.length() > 1) {
                campoTexto.setText(textoAtual.substring(0, textoAtual.length()-1));
            } else {
                campoTexto.setText("0");
                novoNumero = true;
            }
        }else if (comando.equals("=")){
            double segundoNumero = Double.parseDouble(campoTexto.getText());
            double resultado = CalculadoraController.Calcular(primeiroNumero, segundoNumero, operador, this);
            campoTexto.setText(formataNumero(resultado));
            operador = null;
            novoNumero = true;
            mostrandoOperador = false;
        } else {
            operador = comando;
            primeiroNumero = Double.parseDouble(campoTexto.getText());
            campoTexto.setText(operador);
            novoNumero = true;
            mostrandoOperador = true;
        }
    }
    private String formataNumero(double numero) {
    if (numero == (long) numero)
        return String.format("%d", (long) numero);
    else
        return String.valueOf(numero);
    }
}
