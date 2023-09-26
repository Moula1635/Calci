import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calci implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton numberButtons[] = new JButton[10];

    JButton functionButtons[] = new JButton[9];

    JButton AddButton, SubButton, DivButton, MulButton;
    JButton DecimalButton, DelButton, EqualsButton, ClearButton, NegButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 =0, num3 =0, result =0;
    char operator;



    Calci(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(true);


        AddButton = new JButton("+");
        SubButton = new JButton("-");
        MulButton = new JButton("*");
        DivButton = new JButton("/");
        DecimalButton = new JButton(".");
        EqualsButton = new JButton("=");
        DelButton = new JButton("Delete");
        ClearButton = new JButton("Clear");
        NegButton = new JButton("-");

                
        functionButtons[0] = AddButton;
        functionButtons[1] = SubButton;
        functionButtons[2] = MulButton;
        functionButtons[3] = DivButton;
        functionButtons[4] = DecimalButton;
        functionButtons[5] = EqualsButton;
        functionButtons[6] = DelButton;
        functionButtons[7] = ClearButton;
        functionButtons[8] = NegButton;

        for(int i =0; i<9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i =0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        NegButton.setBounds(50,430,100,50);
        DelButton.setBounds(150, 430, 100,50);
        ClearButton.setBounds(2505,430,100,50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(AddButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(SubButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(MulButton);
        panel.add(DecimalButton);
        panel.add(numberButtons[0]);
        panel.add(EqualsButton);
        panel.add(DivButton);



        frame.add(NegButton);
        frame.add(panel);
        frame.add(DelButton);
        frame.add(ClearButton);


        frame.add(textfield);

        frame.setVisible(true);
    }
    public static void main(String arg[]){

        Calci calc = new Calci();

    }


    public void actionPerformed(ActionEvent e){

        for(int i =0; i<10; i++){

            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == DecimalButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == AddButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == SubButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");;

        }
        if(e.getSource() == MulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");;
            
        }
        if(e.getSource() == DivButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");;
            
        }
        if(e.getSource() == EqualsButton){
            num2 = Double.parseDouble(textfield.getText());
            switch(operator){
                case '+':
                result = num1 + num2;
                break;
                case '-':
                result = num1 - num2;
                break;
                case '*':
                result = num1 * num2;
                break;
                case '/':
                result = num1 / num2;
                break;

            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == ClearButton){
            textfield.setText("");

        }
        if(e.getSource() == DelButton){
            String string = textfield.getText();
            textfield.setText("");
            for(int i =0;i<string.length()-1; i++){
                textfield.setText(textfield.getText()+ string.charAt(i));
            }
 
        }
        if(e.getSource() == NegButton){
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));

        }
    }


}