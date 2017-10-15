package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    private Image bgforfield;

    private GameField field;

    private JButton restart;

    private int fieldSize;
    private int difficulty;

    private JTextArea playerLeftText = new JTextArea("Player #1");
    private JTextArea playerCenterText = new JTextArea("VS");
    private JTextArea playerRightText = new JTextArea("Player #2");
    private JTextArea playerText = new JTextArea("Player");
    private JTextArea mobtText = new JTextArea("Mod");

    private Font fontOfText = new Font("Verdana", Font.BOLD, 30);

    private GridBagConstraints c;

    public GamePanel(String bgforfield, int size, int difficulty,int whichGame) {
        this(new ImageIcon(bgforfield).getImage(), size, difficulty,whichGame);
    }

    public GamePanel(Image bgforfield, int size, int difficulty,int whichGame) {
        this.bgforfield = bgforfield;
        this.fieldSize = size;
        this.difficulty = difficulty;
        setPreferredSize(new Dimension(600, 600));

        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        playerLeftText.setEditable(false);
        playerLeftText.setFont(fontOfText);
        playerLeftText.setForeground(new Color(255, 69, 0));
        playerLeftText.setBackground(new Color(81, 99, 109));

        playerCenterText.setEditable(false);
        playerCenterText.setFont(fontOfText);
        playerCenterText.setForeground(new Color(255, 255, 255));
        playerCenterText.setBackground(new Color(81, 99, 109));

        playerRightText.setEditable(false);
        playerRightText.setFont(fontOfText);
        playerRightText.setForeground(new Color(255, 218, 185));
        playerRightText.setBackground(new Color(81, 99, 109));

        playerText.setEditable(false);
        playerText.setFont(fontOfText);
        playerText.setForeground(new Color(255, 69, 0));
        playerText.setBackground(new Color(81, 99, 109));

        mobtText.setEditable(false);
        mobtText.setFont(fontOfText);
        mobtText.setForeground(new Color(255, 218, 185));
        mobtText.setBackground(new Color(81, 99, 109));

        JPanel panelfortext = new JPanel();
        panelfortext.setBackground(new Color(81, 99, 109));
        if (difficulty == 0) {
            panelfortext.add(playerLeftText);
            panelfortext.add(playerCenterText);
            panelfortext.add(playerRightText);
        } else {
            panelfortext.add(playerText);
            panelfortext.add(playerCenterText);
            panelfortext.add(mobtText);
        }
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(20, 0, 10, 0);
        c.anchor = GridBagConstraints.NORTH;
        add(panelfortext, c);

        field = new GameField(size,whichGame);
        field.setSize(400, 400);
        field.setBackground(new Color(81, 99, 109));
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 7;
        c.gridheight = 7;
        c.weightx = 5.0;
        c.weighty = 5.0;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(40, 130, 120, 130);
        c.anchor = GridBagConstraints.CENTER;
        add(field, c);

        restart = new JButton("Restart!");
        restart.addActionListener(this);
        restart.setBackground(Color.LIGHT_GRAY);
        restart.setForeground(new Color(255, 69, 0));
        restart.setPreferredSize(new Dimension(200, 70));
        restart.setFont(fontOfText);
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 4;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 20, 0);
        c.anchor = GridBagConstraints.SOUTH;
        add(restart, c);

    }

    public void paintComponent(Graphics g) {
        g.drawImage(bgforfield, 0, 0, null);
    }

    public GameField getField() {
        return field;
    }

    public JButton getRestart() {
        return restart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        XOButton[][] buttons = field.getButtons();
        for (int i = 0; i < fieldSize; i++)
            for (int j = 0; j < fieldSize; j++)
                buttons[i][j].refresh();
        PvPGameProcess.refresh();
        PvMGameProcess.refresh();
    }

}
