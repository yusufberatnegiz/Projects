import java.util.ArrayList;

public class Cards {
    ArrayList<String> cards;
    String spades = "spades", hearts = "hearts", clubs = "clubs", diamonds = "diamonds";

    public Cards() {
        cards = new ArrayList<>();
        addCards();
    }

    public void addCards() {
        for (int i = 2; i<= 10; i++) {
            cards.add(i + "_of_" + clubs);
            cards.add(i + "_of_" + diamonds);
            cards.add(i + "_of_" + hearts);
            cards.add(i + "_of_" + spades);
        }
        for(int i = 11; i<= 14; i++) {
            switch (i){
                case 11:
                    cards.add("jack_of_" + clubs);
                    cards.add("jack_of_" + diamonds);
                    cards.add("jack_of_" + hearts);
                    cards.add("jack_of_" + spades);
                    break;
                case 12:
                    cards.add("queen_of_" + clubs);
                    cards.add("queen_of_" + diamonds);
                    cards.add("queen_of_" + hearts);
                    cards.add("queen_of_" + spades);
                    break;
                case 13:
                    cards.add("king_of_" + clubs);
                    cards.add("king_of_" + diamonds);
                    cards.add("king_of_" + hearts);
                    cards.add("king_of_" + spades);
                    break;
                case 14:
                    cards.add("ace_of_" + clubs);
                    cards.add("ace_of_" + diamonds);
                    cards.add("ace_of_" + hearts);
                    cards.add("ace_of_" + spades);
                    break;
            }

        }
    }
}