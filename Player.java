import java.util.ArrayList;

public class Player {
    int p1Score = 0;
    int p2Score = 0;
    Deck deck;
    Cards cards;
    ArrayList<String> p1Cards;
    ArrayList<String> p2Cards;
    ArrayList<String> middleCards;

    Player(){
        deck = new Deck();
        cards = new Cards();
        p1Cards = new ArrayList<>();
        p2Cards = new ArrayList<>();
        middleCards = new ArrayList<>();
        crtCards();
    }
    public void crtCards() {
        p1Cards.add(deck.draw());
        p1Cards.add(deck.draw());
        p1Cards.add(deck.draw());
        p1Cards.add(deck.draw());
        p1Cards.add(deck.draw());
        deck.shuffle();
        p2Cards.add(deck.draw());
        p2Cards.add(deck.draw());
        p2Cards.add(deck.draw());
        p2Cards.add(deck.draw());
        p2Cards.add(deck.draw());
        deck.shuffle();
        middleCards.add(deck.draw());
        middleCards.add(deck.draw());
        middleCards.add(deck.draw());
    }

    public int calculate(ArrayList<String> playerCards){
        int score = 0;

        for(int i = 0; i<playerCards.size(); i++) {
            String card = playerCards.get(i);
            String[] split = card.split("_");
            String type = split[0];

            switch (type) {
                case "jack":
                    score=score+11;
                    break;
                case "queen":
                    score=score+12;
                    break;
                case "king":
                    score= score+13;
                    break;
                case "ace":
                    score= score+ 14;
                    break;
                default:
                    score = score + Integer.parseInt(type);
                    break;
            }
        }
        return score;
    }

    public int calculateMulti(ArrayList<String> playerCards) {
        int[] numCount = new int[15];
        int defMulti = 1;

        for (int i = 0; i<playerCards.size(); i++) {
            String card = playerCards.get(i);
            String[] split = card.split("_");
            String type = split[0];

            int cardNum = 0;

            switch (type) {
                case "jack":
                    cardNum = 11;
                    break;
                case "queen":
                    cardNum = 12;
                    break;
                case "king":
                    cardNum = 13;
                    break;
                case "ace":
                    cardNum = 14;
                    break;
                default:
                    cardNum = Integer.parseInt(type);
                    break;
            }

            numCount[cardNum]++;
        }

        for (int i = 0; i <= 14; i++) {
            if (numCount[i] == 4) {
                defMulti = Math.max(defMulti, 4);
            }
            else if (numCount[i] == 3) {
                defMulti = Math.max(defMulti, 3);
            }
            else if (numCount[i] == 2) {
                defMulti = Math.max(defMulti, 2);
            }
        }

        int unique = 0;
        for (int i = 0; i <= 14; i++) {
            if (numCount[i] > 0) {
                unique++;
                if (unique >= 5) {
                    defMulti = Math.max(defMulti, 5);
                }
            }
            else {
                unique = 0;
            }
        }

        return defMulti;
    }

    public void calculateScores() {
        p1Score = calculate(p1Cards) * calculateMulti(p1Cards);
        p2Score = calculate(p2Cards) * calculateMulti(p2Cards);
    }

}
