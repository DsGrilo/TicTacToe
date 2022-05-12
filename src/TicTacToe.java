import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerOneTurn;
    boolean restart;
    int scoreX;
    int scoreO;

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for(var i = 0; i<9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
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
                        textField.setText("O Turn");
                        check();
                    }
                }else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        playerOneTurn = true;
                        textField.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }



    public void firstTurn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2) ==0){
            playerOneTurn = true;
            textField.setText("X Turn");
        }else{
            playerOneTurn = false;
            textField.setText("O Turn");
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
        textField.setText("X Wins");

        scoreX++;
        restart = true;

//        restartGame();
        restart = false;
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (var i = 0; i<9; i++)
            buttons[i].setEnabled(false);
        textField.setText("O Wins");

        scoreO++;
        restart = true;
//        restartGame();
        restart = false;
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
            textField.setText("X TIE O");
            return true;
        }
        return false;
    }

    public void restartGame(){
        for(var i = 0; i<9; i++){
            buttons[i].setText("");
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setEnabled(true);
        }
        firstTurn();
    }
}
