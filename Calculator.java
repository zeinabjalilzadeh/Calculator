import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons= new JButton[10];
    JButton[] functionButtons= new JButton[9];
    JButton addButton,subButton,divButton,mulButton;
    JButton decButton,equButton,delButton, clrButton;
    JButton negButton;
    JPanel panel;
    Font myfont = new Font("forte",Font.BOLD,30);

    double num1=0;
    double num2=0;
    double result=0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
//textfield here
        textField = new JTextField();
        textField.setBackground(Color.decode("#E1B9D1"));
        textField.setBounds(50,25,300,50 );
        textField.setFont(myfont);
        textField.setEditable(false);
//function buttons here
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("clr");
        decButton = new JButton(".");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2]= mulButton;
        functionButtons[3]= divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6]= delButton;
        functionButtons[7]= clrButton;
        functionButtons[8] = negButton;
        for (int i = 0; i<functionButtons.length;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setBackground(Color.decode("#B33972"));
            functionButtons[i].setFocusable(false);
        }

//number buttons get their value here
         for (int i = 0; i<10;i++){
            numberButtons[i]= new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setBackground(Color.decode("#B45283"));
            numberButtons[i].setFocusable(false);
        }
        
        delButton.setBounds(50,430,100,50);
        clrButton.setBounds(250,430,100,50);
        negButton.setBounds(150,430,100,50);
// in panel we have number buttons and +,-,/,*,. functional buttons
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.decode("#CF91B6"));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        

    //panel and the rest of functionl buttons are added here
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#CF91B6"));

    }

    public static void main(String[] args){

        Calculator calc = new Calculator();
//actual logic of operations are gathered in actionPerformed part:
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //numbere buttons
        for (int i =0;i<10;i++){
            if (e.getSource()== numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        //. button
        if (e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));

        }

        //add button
        if (e.getSource()==addButton){ 
            num1=Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        //subtractiob button
        if (e.getSource()==subButton){ 
            num1=Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        //multiplication button
        if (e.getSource()==mulButton){ 
            num1=Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        //divide button
        if (e.getSource()==divButton){ 
            num1=Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        //clear button
        if (e.getSource()==clrButton){ 
            textField.setText("");
        }

        //delete button
        if (e.getSource()==delButton){ 
            String string = textField.getText();
            textField.setText("");
            for (int i =0; i<string.length()-1;i++){
                textField.setText(textField.getText()+ string.charAt(i));
            }
        }
        //negative button
        if (e.getSource()== negButton){ 
            Double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }

        //equal button
        if (e.getSource()== equButton){
            num2= Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result= num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result= num1/num2;
                    break;
            
                default:
                    break;
            }
            textField.setText(String.valueOf(result));
        }
        
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}