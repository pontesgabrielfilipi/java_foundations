package delete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MiniMinecraftGUI extends JPanel implements KeyListener {
    static final int ALTURA = 15;
    static final int LARGURA = 30;
    static final int TAM_BLOCO = 32; // tamanho em pixels

    enum Bloco {
        AR("  ", false, Color.CYAN),
        TERRA("🟫", true, new Color(139, 69, 19)),
        PEDRA("🪨", true, Color.GRAY),
        GRAMA("🌿", true, Color.GREEN),
        AGUA("🌊", false, Color.BLUE),
        FOGO("🔥", false, Color.ORANGE),
        MONSTRO("👾", false, Color.RED),
        NPC("🧙‍♂️", false, Color.MAGENTA);

        final String emoji;
        final boolean solido;
        final Color cor;

        Bloco(String emoji, boolean solido, Color cor) {
            this.emoji = emoji;
            this.solido = solido;
            this.cor = cor;
        }
    }

    Bloco[][] mundo = new Bloco[ALTURA][LARGURA];
    int jogadorX, jogadorY;
    Map<Bloco, Integer> inventario = new HashMap<>();
    Random random = new Random();

    public MiniMinecraftGUI() {
        setPreferredSize(new Dimension(LARGURA * TAM_BLOCO, ALTURA * TAM_BLOCO + 40));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        gerarMundoAleatorio();
        posicionarJogador();
        adicionarInventario(Bloco.TERRA, 5);
    }

    void gerarMundoAleatorio() {
        for (int i = 0; i < ALTURA; i++) {
            for (int j = 0; j < LARGURA; j++) {
                if (i > ALTURA * 0.7) {
                    mundo[i][j] = random.nextBoolean() ? Bloco.TERRA : Bloco.PEDRA;
                } else if (i == (int)(ALTURA * 0.7)) {
                    mundo[i][j] = Bloco.GRAMA;
                } else if (i > ALTURA * 0.5) {
                    mundo[i][j] = random.nextInt(10) == 0 ? Bloco.AGUA : Bloco.AR;
                } else {
                    mundo[i][j] = Bloco.AR;
                }
            }
        }
        for (int k = 0; k < 5; k++) {
            int x = random.nextInt(ALTURA - 3);
            int y = random.nextInt(LARGURA);
            mundo[x][y] = k % 2 == 0 ? Bloco.MONSTRO : Bloco.NPC;
        }
    }

    void posicionarJogador() {
        jogadorX = (int)(ALTURA * 0.6);
        jogadorY = LARGURA / 2;
    }

    void adicionarInventario(Bloco b, int qtd) {
        inventario.put(b, inventario.getOrDefault(b, 0) + qtd);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenhar o mundo
        for (int i = 0; i < ALTURA; i++) {
            for (int j = 0; j < LARGURA; j++) {
                Bloco bloco = mundo[i][j];
                int x = j * TAM_BLOCO;
                int y = i * TAM_BLOCO;
                g.setColor(bloco.cor);
                g.fillRect(x, y, TAM_BLOCO, TAM_BLOCO);

                // Desenhar emoji no centro
                g.setColor(Color.WHITE);
                g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
                g.drawString(bloco.emoji, x + 6, y + 24);
            }
        }

        // Desenhar jogador
        int px = jogadorY * TAM_BLOCO;
        int py = jogadorX * TAM_BLOCO;
        g.setColor(Color.YELLOW);
        g.fillOval(px + 4, py + 4, TAM_BLOCO - 8, TAM_BLOCO - 8);

        // Desenhar inventário abaixo
        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        StringBuilder invText = new StringBuilder("Inventário: ");
        if (inventario.isEmpty()) invText.append("(vazio)");
        else
            inventario.forEach((bloco, qtd) -> invText.append(bloco.emoji).append("x").append(qtd).append(" "));
        g.drawString(invText.toString(), 10, ALTURA * TAM_BLOCO + 30);
    }

    boolean dentroLimites(int x, int y) {
        return x >= 0 && x < ALTURA && y >= 0 && y < LARGURA;
    }

    boolean podeAndar(int nx, int ny) {
        if (!dentroLimites(nx, ny)) return false;
        return !mundo[nx][ny].solido;
    }

    void moverJogador(int dx, int dy) {
        int nx = jogadorX + dx;
        int ny = jogadorY + dy;
        if (podeAndar(nx, ny)) {
            jogadorX = nx;
            jogadorY = ny;
            repaint();
        }
    }

    void quebrarBloco() {
        Bloco bloco = mundo[jogadorX][jogadorY];
        if (bloco == Bloco.AR || bloco == Bloco.MONSTRO || bloco == Bloco.NPC) {
            JOptionPane.showMessageDialog(this, "Nada para quebrar aqui!");
            return;
        }
        adicionarInventario(bloco, 1);
        mundo[jogadorX][jogadorY] = Bloco.AR;
        repaint();
    }

    void colocarBloco() {
        Bloco blocoColocado = Bloco.TERRA; // só terra por enquanto
        if (!inventario.containsKey(blocoColocado) || inventario.get(blocoColocado) <= 0) {
            JOptionPane.showMessageDialog(this, "Você não tem blocos para colocar!");
            return;
        }
        if (mundo[jogadorX][jogadorY] != Bloco.AR) {
            JOptionPane.showMessageDialog(this, "Espaço ocupado!");
            return;
        }
        mundo[jogadorX][jogadorY] = blocoColocado;
        inventario.put(blocoColocado, inventario.get(blocoColocado) - 1);
        if (inventario.get(blocoColocado) == 0) inventario.remove(blocoColocado);
        repaint();
    }

    void craftar() {
        int qtdTerra = inventario.getOrDefault(Bloco.TERRA, 0);
        if (qtdTerra >= 2) {
            inventario.put(Bloco.TERRA, qtdTerra - 2);
            if (inventario.get(Bloco.TERRA) == 0) inventario.remove(Bloco.TERRA);
            adicionarInventario(Bloco.PEDRA, 1);
            JOptionPane.showMessageDialog(this, "Craft: 2 TERRA -> 1 PEDRA");
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Precisa de 2 blocos de terra para craftar pedra.");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: moverJogador(-1, 0); break;
            case KeyEvent.VK_S: moverJogador(1, 0); break;
            case KeyEvent.VK_A: moverJogador(0, -1); break;
            case KeyEvent.VK_D: moverJogador(0, 1); break;
            case KeyEvent.VK_B: quebrarBloco(); break;
            case KeyEvent.VK_P: colocarBloco(); break;
            case KeyEvent.VK_C: craftar(); break;
        }
    }
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Minecraft GUI");
        MiniMinecraftGUI game = new MiniMinecraftGUI();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
