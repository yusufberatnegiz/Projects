import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000,700);
        frame.add(new myPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Card Game");
        frame.setLocationRelativeTo(null);
    }
}
// Yusuf Beraat Negiz 230201059