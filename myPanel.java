import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class myPanel extends JPanel implements ActionListener {
    JLabel p1;
    JLabel p2;
    JLabel p1scr;
    JLabel p2scr;
    JButton p1cng;
    JButton p2cng;
    JCheckBox p1c1;
    JCheckBox p1c2;
    JCheckBox p1c3;
    JCheckBox p1c4;
    JCheckBox p1c5;
    JCheckBox p2c1;
    JCheckBox p2c2;
    JCheckBox p2c3;
    JCheckBox p2c4;
    JCheckBox p2c5;
    Deck deck;
    Player player;
    ImageIcon back;
    ArrayList<ImageIcon> cardPng;
    ArrayList<JLabel> p1CardPng;
    ArrayList<JLabel> p2CardPng;
    ArrayList<JLabel> middleCardPng;
    int counter;
    boolean isPlayer1Turn = true;
    int player1Wins;
    int player2Wins;
    boolean turnCheck;

    myPanel(){
        setBackground(Color.GRAY);
        deck = new Deck();
        player = new Player();
        setLayout(null);
        p1= new JLabel("Player 1");
        p2 = new JLabel("Player 2");
        p1scr = new JLabel("Hand's Points: "+ player.p1Score);
        p2scr = new JLabel("Hand's Points: " + player.p2Score);
        p1cng = new JButton("Change");
        p2cng = new JButton("Change");
        p1c1 = new JCheckBox();
        p1c2 = new JCheckBox();
        p1c3 = new JCheckBox();
        p1c4 = new JCheckBox();
        p1c5 = new JCheckBox();
        p2c1 = new JCheckBox();
        p2c2 = new JCheckBox();
        p2c3 = new JCheckBox();
        p2c4 = new JCheckBox();
        p2c5 = new JCheckBox();
        back= new ImageIcon(getClass().getResource("/Cards/back.png"));

        p1.setBounds(50, 20, 100, 30);
        p1scr.setBounds(150, 20, 200, 30);
        p1cng.setBounds(400, 20, 100, 30);
        p1c1.setBounds(50, 70, 20, 20);
        p1c2.setBounds(150, 70, 20, 20);
        p1c3.setBounds(250, 70, 20, 20);
        p1c4.setBounds(350, 70, 20, 20);
        p1c5.setBounds(450, 70, 20, 20);
        p2.setBounds(50, 300, 100, 30);
        p2scr.setBounds(150, 300, 200, 30);
        p2cng.setBounds(400, 300, 100, 30);
        p2c1.setBounds(50, 350, 20, 20);
        p2c2.setBounds(150, 350, 20, 20);
        p2c3.setBounds(250, 350, 20, 20);
        p2c4.setBounds(350, 350, 20, 20);
        p2c5.setBounds(450, 350, 20, 20);
        cardPng = setCardImages();
        p1CardPng = new ArrayList<>();
        p2CardPng = new ArrayList<>();
        middleCardPng = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            p1CardPng.add(new JLabel());
            p2CardPng.add(new JLabel());
        }

        for (int i = 0; i<3; i++) {
            middleCardPng.add(new JLabel());
        }

        updateCardPng();

        for (int i = 0; i < 5; i++) {
            p1CardPng.get(i).setBounds(70 + i * 100, 70, 50, 70);
            p2CardPng.get(i).setBounds(70 + i * 100, 350, 50, 70);
            add(p1CardPng.get(i));
            add(p2CardPng.get(i));
        }

        for(int i=0; i <3; i++) {
            middleCardPng.get(i).setBounds(200 + i * 100, 200, 50, 70);
            add(middleCardPng.get(i));
        }

        add(p1);
        add(p2);
        add(p1scr);
        add(p2scr);
        add(p1cng);
        add(p2cng);
        add(p1c1);
        add(p1c2);
        add(p1c3);
        add(p1c4);
        add(p1c5);
        add(p2c1);
        add(p2c2);
        add(p2c3);
        add(p2c4);
        add(p2c5);
        p1cng.addActionListener(this);
        p2cng.addActionListener(this);
        player.calculateScores();
        updateCardPng();
        p1scr.setText("Hand's Points: " + player.p1Score);
        player.calculateScores();
        updateCardPng();
        p2scr.setText("Hand's Points: " + player.p2Score);
        setTurns();
    }

    public ArrayList<ImageIcon> setCardImages() {
        ArrayList<ImageIcon> images = new ArrayList<>();
        String[] suits = {"c","d","h","s"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                String imagePath = "/Cards/"+ranks[j]+suits[i]+".jpg";
                ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagePath));
                Image scaledImage = originalIcon.getImage().getScaledInstance(50, 70, Image.SCALE_SMOOTH);
                images.add(new ImageIcon(scaledImage));
                back= new ImageIcon(getClass().getResource("/Cards/back.png"));
                Image backImage =back.getImage().getScaledInstance(50, 70, Image.SCALE_SMOOTH);
                back =new ImageIcon(backImage);
            }
        }
        return images;
    }

    public void updateCardPng() {
        for (int i = 0; i < 5; i++) {
            p1CardPng.get(i).setIcon(cardPng.get(player.cards.cards.indexOf(player.p1Cards.get(i))));
            p2CardPng.get(i).setIcon(cardPng.get(player.cards.cards.indexOf(player.p2Cards.get(i))));
        }

        for (int i=0; i<3; i++) {
            middleCardPng.get(i).setIcon(back);
        }
    }
    public void revealMiddleCards() {
        for (int i = 0; i < 3; i++) {
            middleCardPng.get(i).setIcon(cardPng.get(player.cards.cards.indexOf(player.middleCards.get(i))));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == p1cng && isPlayer1Turn) {
            ArrayList<Integer> indexes = new ArrayList<>();
            counter = 0;
            if (p1c1.isSelected()) {
                indexes.add(0);
                counter++;
            }
            if (p1c2.isSelected()) {
                indexes.add(1);
                counter++;
            }
            if (p1c3.isSelected()) {
                indexes.add(2);
                counter++;
            }
            if (p1c4.isSelected()) {
                indexes.add(3);
                counter++;
            }
            if (p1c5.isSelected()) {
                indexes.add(4);
                counter++;
            }
            if (counter > 3) {
                JOptionPane.showMessageDialog(this, "You can only select up to 3 cards!");
                p1c1.setSelected(false);
                p1c2.setSelected(false);
                p1c3.setSelected(false);
                p1c4.setSelected(false);
                p1c5.setSelected(false);
                return;
            }
            else {
                for (int i = 0; i < indexes.size(); i++) {
                    player.p1Cards.set(indexes.get(i), player.deck.draw());
                }
            }
            player.calculateScores();
            updateCardPng();
            p1scr.setText("Hand's Points: " + player.p1Score);
            isPlayer1Turn = false;
            turnCheck=false;
            setTurns();
        }

        if (e.getSource() == p2cng) {
            ArrayList<Integer> indexes = new ArrayList<>();
            counter = 0;
            if (p2c1.isSelected()) {
                indexes.add(0);
                counter++;
            }
            if (p2c2.isSelected()) {
                indexes.add(1);
                counter++;
            }
            if (p2c3.isSelected()) {
                indexes.add(2);
                counter++;
            }
            if (p2c4.isSelected()) {
                indexes.add(3);
                counter++;
            }
            if (p2c5.isSelected()) {
                indexes.add(4);
                counter++;
            }
            if (counter > 3) {
                JOptionPane.showMessageDialog(this, "You can only select up to 3 cards!");
                p2c1.setSelected(false);
                p2c2.setSelected(false);
                p2c3.setSelected(false);
                p2c4.setSelected(false);
                p2c5.setSelected(false);
                return;
            }
            else {
                for (int i = 0; i < indexes.size(); i++) {
                    player.p2Cards.set(indexes.get(i), player.deck.draw());
                }
            }
            player.calculateScores();
            updateCardPng();
            p2scr.setText("Hand's Points: " + player.p2Score);
            isPlayer1Turn = true;
            turnCheck =true;
            setTurns();
            if(turnCheck) {
                turnWinner();
                turnCheck= false;
            }

        }
    }
    public void setTurns(){
        p1cng.setVisible(isPlayer1Turn);
        p1c1.setVisible(isPlayer1Turn);
        p1c2.setVisible(isPlayer1Turn);
        p1c3.setVisible(isPlayer1Turn);
        p1c4.setVisible(isPlayer1Turn);
        p1c5.setVisible(isPlayer1Turn);

        for(int i=0; i< 5; i++) {
            if(isPlayer1Turn) {
                p2scr.setVisible(false);
                p1CardPng.get(i).setIcon(cardPng.get(player.cards.cards.indexOf(player.p1Cards.get(i))));
            }
            else {
                p2scr.setVisible(true);
                p1CardPng.get(i).setIcon(back);
            }
        }

        p2cng.setVisible(!isPlayer1Turn);
        p2c1.setVisible(!isPlayer1Turn);
        p2c2.setVisible(!isPlayer1Turn);
        p2c3.setVisible(!isPlayer1Turn);
        p2c4.setVisible(!isPlayer1Turn);
        p2c5.setVisible(!isPlayer1Turn);

        for (int i = 0; i < 5; i++) {
            if (!isPlayer1Turn) {
                p2CardPng.get(i).setIcon(cardPng.get(player.cards.cards.indexOf(player.p2Cards.get(i))));
            } else {
                p2CardPng.get(i).setIcon(back);
            }
        }
    }
    public void turnWinner(){
        revealMiddleCards();
        if(player.p1Score > player.p2Score) {
            player1Wins++;
            JOptionPane.showMessageDialog(this, "Player 1 has won this round! Total Score: "+player1Wins+"-"+player2Wins);
        }
        else if(player.p2Score >player.p1Score){
            player2Wins++;
            JOptionPane.showMessageDialog(this, "Player 2 has won this round! Total Score: "+player1Wins+"-"+player2Wins);
        }
        else {
            JOptionPane.showMessageDialog(this,"It is a tie! Total Score: "+player1Wins+"-"+player2Wins);
        }
        checkWinner();
    }
    public void checkWinner(){
        if(player1Wins==3) {
            JOptionPane.showMessageDialog(this, "Player 1 has won the game!");
            reset();
        }
        else if(player2Wins==3){
            JOptionPane.showMessageDialog(this, "Player 2 has won the game!");
            reset();
        }
    }

    public void reset(){
        player.p1Score=0;
        player.p2Score=0;
        player.deck=new Deck();
        player.cards=new Cards();
        player.p1Cards.clear();
        player.p2Cards.clear();
        player.middleCards.clear();
        player.crtCards();
        p1scr.setText("Hand's Points: " + player.p1Score);
        p2scr.setText("Hand's Points: " + player.p2Score);
        updateCardPng();
        player1Wins = 0;
        player2Wins = 0;
        isPlayer1Turn= true;
        turnCheck=false;
        setTurns();
        p1c1.setSelected(false);
        p1c2.setSelected(false);
        p1c3.setSelected(false);
        p1c4.setSelected(false);
        p1c5.setSelected(false);
        p2c1.setSelected(false);
        p2c2.setSelected(false);
        p2c3.setSelected(false);
        p2c4.setSelected(false);
        p2c5.setSelected(false);
        JOptionPane.showMessageDialog(this, "New game has been set!");
    }

}
