import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import static java.awt.BorderLayout.SOUTH;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel titleField = new JLabel();
    JLabel scoreField = new JLabel();
    JButton restartButton = new JButton();
    JButton[] buttons = new JButton[9];
    boolean playerOneTurn;
    int scoreX;
    int scoreO;

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        createTitleField();
        createFooterField();

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        footerPanel.setLayout(new BorderLayout());
        footerPanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        addButtonsOnPanel();

        titlePanel.add(titleField);
        footerPanel.add(scoreField);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);
        frame.add(footerPanel, SOUTH);

        firstTurn();
    }

    private void updateScore(){
        scoreField.setText("X: " + scoreX + "  -  O: " + scoreO);
    }

    private void createTitleField(){
        titleField.setBackground(new Color(25, 25,25));
        titleField.setForeground(new Color(25,255,0));
        titleField.setFont(new Font("Ink Free", Font.BOLD, 75));
        titleField.setHorizontalAlignment(JLabel.CENTER);
        titleField.setText("Tic-Tac-Toe");
        titleField.setOpaque(true);
    }

    private void createFooterField(){
        scoreField.setBackground(new Color(25, 25,25));
        scoreField.setForeground(new Color(25,255,0));
        scoreField.setFont(new Font("Ink Free", Font.BOLD, 75));
        scoreField.setHorizontalAlignment(JLabel.CENTER);
        scoreField.setText("X: " + scoreX + "  -  O: " + scoreO);
        scoreField.setOpaque(true);
    }

    private void addButtonsOnPanel(){
        for(var i = 0; i<9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(var i = 0; i<9; i++){
            if(e.getSource()==buttons[i]){
                if(playerOneTurn){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        playerOneTurn = false;
                        titleField.setText("O Turn");
                        check();
                    }
                }else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        playerOneTurn = true;
                        titleField.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }



    public void firstTurn(){
        if(random.nextInt(2) ==0){
            playerOneTurn = true;
            titleField.setText("X Turn");
        }else{
            playerOneTurn = false;
            titleField.setText("O Turn");
        }
    }

    public void check(){
        checkTie();
        checkPlayerO();
        checkPlayerX();
    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (var i = 0; i<9; i++)
            buttons[i].setEnabled(false);
        titleField.setText("X Wins");

        scoreX++;
        updateScore();
        restartGame();
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (var i = 0; i<9; i++)
            buttons[i].setEnabled(false);
        titleField.setText("O Wins");

        scoreO++;

        updateScore();
        restartGame();
    }

    public boolean checkPlayerX(){
        if((buttons[0].getText().equals("X") &&
                buttons[1].getText().equals("X") &&
                buttons[2].getText().equals("X"))){
            xWins(0, 1, 2);
            return true;
        }
        if((buttons[3].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[5].getText().equals("X"))){
            xWins(3, 4, 5);
            return true;

        }
        if((buttons[6].getText().equals("X") &&
                buttons[7].getText().equals("X") &&
                buttons[8].getText().equals("X"))){
            xWins(6, 7, 8);
            return true;

        }
        if((buttons[0].getText().equals("X") &&
                buttons[3].getText().equals("X") &&
                buttons[6].getText().equals("X"))){
            xWins(0, 3, 6);
            return true;

        }
        if((buttons[1].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[7].getText().equals("X"))){
            xWins(1, 4, 7);
            return true;
        }
        if((buttons[2].getText().equals("X") &&
                buttons[5].getText().equals("X") &&
                buttons[8].getText().equals("X"))){
            xWins(2, 5, 8);
            return true;
        }
        if((buttons[0].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[8].getText().equals("X"))){
            xWins(0, 4, 8);
            return true;
        }
        if((buttons[2].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[6].getText().equals("X"))){
            xWins(2, 4, 6);
            return true;
        }
        return false;
    }

    public boolean checkPlayerO(){
        if((buttons[0].getText().equals("O") &&
                buttons[1].getText().equals("O") &&
                buttons[2].getText().equals("O"))){
            oWins(0, 1, 2);
            return true;
        }
        if((buttons[3].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[5].getText().equals("O"))){
            oWins(3, 4, 5);
            return true;
        }
        if((buttons[6].getText().equals("O") &&
                buttons[7].getText().equals("O") &&
                buttons[8].getText().equals("O"))){
            oWins(6, 7, 8);
            return true;
        }
        if((buttons[0].getText().equals("O") &&
                buttons[3].getText().equals("O") &&
                buttons[6].getText().equals("O"))){
            oWins(0, 3, 6);
            return true;
        }
        if((buttons[1].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[7].getText().equals("O"))){
            oWins(1, 4, 7);
            return true;
        }
        if((buttons[2].getText().equals("O") &&
                buttons[5].getText().equals("O") &&
                buttons[8].getText().equals("O"))){
            oWins(2, 5, 8);
            return true;
        }
        if((buttons[0].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[8].getText().equals("O"))){
            oWins(0, 4, 8);
            return true;
        }
        if((buttons[2].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[6].getText().equals("O"))){
            oWins(2, 4, 6);
            return true;
        }
        return false;
    }

    public boolean checkTie(){
        var buttonPressed = 0;
        for (var i = 0; i<9; i++){
            if(!buttons[i].getText().equals(""))
                buttonPressed++;
        }
        if(buttonPressed==9 && !checkPlayerX() || buttonPressed==9 && !checkPlayerO()){
            for (var i = 0; i<9; i++)
                buttons[i].setEnabled(false);
            titleField.setText("X TIE O");
            restartGame();
            return true;
        }
        return false;
    }

    public void restartGame(){
        restartButton.setText("New Game");
        restartButton.setVisible(true);
        restartButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        restartButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                restartButton.setVisible(false);
                buttonPanel.removeAll();
                addButtonsOnPanel();
                firstTurn();
            }
        });

        titlePanel.add(restartButton, SOUTH);

    }

}
