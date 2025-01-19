import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myFrame extends JFrame implements ActionListener {
    JLabel calculation;
    JTextField result;
    JRadioButton decimal;
    JRadioButton hexadecimal;
    JRadioButton binary;
    JButton a, b, c, d, e, f, not, and, or, xor, leftShft, rightShft, clear, b0, b1,
            b2, b3, b4, b5, b6, b7, b8, b9, add, sub, multi, div, equals, dot;
    String operand1 = "";
    String operator = "";
    String operand2 = "";
    boolean isFirst = true;

    myFrame(){
        this.setTitle("Programmer Calculator");
        this.setSize(550,600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        calculation = new JLabel();
        result = new JTextField();
        decimal = new JRadioButton("Decimal");
        hexadecimal = new JRadioButton("Hexadecimal");
        binary = new JRadioButton("Binary");
        a = new JButton("A");
        b = new JButton("B");
        c = new JButton("C");
        d = new JButton("D");
        e = new JButton("E");
        f = new JButton("F");
        not = new JButton("NOT");
        and = new JButton("AND");
        or = new JButton("OR");
        xor = new JButton("XOR");
        leftShft = new JButton("<<");
        rightShft = new JButton(">>");
        clear = new JButton("CLEAR");
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        add = new JButton("+");
        sub = new JButton("-");
        multi = new JButton("*");
        div = new JButton("/");
        equals = new JButton("=");
        dot = new JButton(".");

        ButtonGroup group = new ButtonGroup();
        group.add(decimal);
        group.add(hexadecimal);
        group.add(binary);

        hexadecimal.setBounds(20, 20, 100, 30);
        decimal.setBounds(130, 20, 100, 30);
        binary.setBounds(240, 20, 100, 30);
        result.setBounds(20, 60, 480, 40);
        calculation.setBounds(20, 40, 480, 20);
        clear.setBounds(20, 110, 480, 40);
        a.setBounds(20, 160, 70, 50);
        b.setBounds(100, 160, 70, 50);
        c.setBounds(180, 160, 70, 50);
        d.setBounds(260, 160, 70, 50);
        e.setBounds(340, 160, 70, 50);
        f.setBounds(420, 160, 70, 50);
        not.setBounds(20, 220, 70, 50);
        and.setBounds(100, 220, 70, 50);
        or.setBounds(180, 220, 70, 50);
        xor.setBounds(260, 220, 70, 50);
        leftShft.setBounds(340, 220, 70, 50);
        rightShft.setBounds(420, 220, 70, 50);
        b7.setBounds(20, 280, 70, 50);
        b8.setBounds(100, 280, 70, 50);
        b9.setBounds(180, 280, 70, 50);
        add.setBounds(260, 280, 100, 50);
        sub.setBounds(370, 280, 100, 50);
        b4.setBounds(20, 340, 70, 50);
        b5.setBounds(100, 340, 70, 50);
        b6.setBounds(180, 340, 70, 50);
        multi.setBounds(260, 340, 100, 50);
        div.setBounds(370, 340, 100, 50);
        b1.setBounds(20, 400, 70, 50);
        b2.setBounds(100, 400, 70, 50);
        b3.setBounds(180, 400, 70, 50);
        equals.setBounds(260, 400, 210, 50);
        b0.setBounds(20, 460, 230, 50);
        dot.setBounds(260, 460, 100, 50);

        result.setEditable(false);
        clear.setBackground(Color.RED);

        this.add(calculation);
        this.add(result);
        this.add(decimal);
        this.add(hexadecimal);
        this.add(binary);
        this.add(a);
        this.add(b);
        this.add(c);
        this.add(d);
        this.add(e);
        this.add(f);
        this.add(not);
        this.add(and);
        this.add(or);
        this.add(xor);
        this.add(leftShft);
        this.add(rightShft);
        this.add(clear);
        this.add(b0);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(b8);
        this.add(b9);
        this.add(add);
        this.add(sub);
        this.add(multi);
        this.add(div);
        this.add(equals);
        this.add(dot);
        this.setVisible(true);

        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);
        not.addActionListener(this);
        and.addActionListener(this);
        or.addActionListener(this);
        xor.addActionListener(this);
        leftShft.addActionListener(this);
        rightShft.addActionListener(this);
        clear.addActionListener(this);
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        multi.addActionListener(this);
        div.addActionListener(this);
        equals.addActionListener(this);
        dot.addActionListener(this);

        decimal.addActionListener(e -> setButtons(true, false, true, false));
        hexadecimal.addActionListener(e -> setButtons(true, true, true, true));
        binary.addActionListener(e -> setButtons(false, false, true, true));
        clear.addActionListener(e -> clear());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.matches("[0-9A-F]")) {
            if(isFirst == true) {
                operand1 = operand1+src;
                calculation.setText(operand1);
            }
            else {
                operand2 = operand2+src;
                calculation.setText(operand1 + " " + operator + " " + operand2);
            }
        }

        if(src.equals("+")||src.equals("-")||src.equals("*")||src.equals("/")||src.equals("AND")||src.equals("OR")||src.equals("XOR")||src.equals("<<")||src.equals(">>")) {
            operator = src;
            isFirst = false;
        }

        if(src.equals("NOT")) {
            try {
                int res=~Integer.parseInt(operand1, getBase());
                result.setText(String.valueOf(res).toUpperCase());
                calculation.setText("NOT "+operand1 + " = "+(String.valueOf(res).toUpperCase()).toUpperCase());
            }
            catch (NumberFormatException ex) {
                result.setText("Error");
            }
        }

        if(src.equals("=")) {
            try {
                int res = 0;

                switch(operator) {
                    case "+":
                        res = Integer.parseInt(operand1, getBase())+ Integer.parseInt(operand2, getBase());;
                        break;
                    case "-":
                        res = Integer.parseInt(operand1, getBase())-Integer.parseInt(operand2, getBase());;
                        break;
                    case "*":
                        res = Integer.parseInt(operand1, getBase())* Integer.parseInt(operand2, getBase());;
                        break;
                    case "/":
                        res = Integer.parseInt(operand1, getBase())/ Integer.parseInt(operand2, getBase());;
                        break;
                    case "AND":
                        res = Integer.parseInt(operand1, getBase())& Integer.parseInt(operand2, getBase());;
                        break;
                    case "OR":
                        res = Integer.parseInt(operand1, getBase())| Integer.parseInt(operand2, getBase());;
                        break;
                    case "XOR":
                        res = Integer.parseInt(operand1, getBase())^ Integer.parseInt(operand2, getBase());;
                        break;
                    case "<<":
                        res = Integer.parseInt(operand1, getBase())<< Integer.parseInt(operand2, getBase()&31);;
                        break;
                    case ">>":
                        res = Integer.parseInt(operand1, getBase())>> Integer.parseInt(operand2, getBase()& 31);;
                        break;
                }

                result.setText(String.valueOf(res));
                calculation.setText(operand1+" " +operator+ " "+ operand2+" = ");
                operand1 = String.valueOf(res);
            }
            catch (NumberFormatException ex) {
                result.setText("Error");
            }
        }
    }

    public int getBase() {
        if (decimal.isSelected()) {
            return 10;
        }
        else if (hexadecimal.isSelected()) {
            return 16;
        }
        else if (binary.isSelected()) {
            return 2;
        }
        return 10;
    }

    public void setButtons(boolean dec, boolean hex, boolean bin, boolean logic) {
        b0.setEnabled(true);
        b1.setEnabled(bin);
        b2.setEnabled(dec);
        b3.setEnabled(dec);
        b4.setEnabled(dec);
        b5.setEnabled(dec);
        b6.setEnabled(dec);
        b7.setEnabled(dec);
        b8.setEnabled(dec);
        b9.setEnabled(dec);
        and.setEnabled(logic);
        or.setEnabled(logic);
        xor.setEnabled(logic);
        a.setEnabled(hex);
        b.setEnabled(hex);
        c.setEnabled(hex);
        d.setEnabled(hex);
        e.setEnabled(hex);
        f.setEnabled(hex);
    }

    public void clear(){
        operand1 = "";
        operator = "";
        operand2 = "";
        isFirst = true;
        result.setText("");
        calculation.setText("");
    }
}
