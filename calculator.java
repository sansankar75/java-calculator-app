import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener{

    //components and its all object name we dont create in this place
    JFrame frame;
    JTextField textField;
    JButton[] number_of_Buttons=new JButton[10];
    JButton[] function_Buttons=new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    //font we use
    Font myFont=new Font("Ink free",Font.BOLD,30);

    // variable to store
    double num1=0,num2=0,result=0;
    char operator;

    public calculator() {
        frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Delete");
        clrButton=new JButton("Clear");
        negButton=new JButton("(-)");

        function_Buttons[0]=addButton;
        function_Buttons[1]=subButton;
        function_Buttons[2]=mulButton;
        function_Buttons[3]=divButton;
        function_Buttons[4]=decButton;
        function_Buttons[5]=equButton;
        function_Buttons[6]=delButton;
        function_Buttons[7]=clrButton;
        function_Buttons[8]=negButton;

        for (int i = 0; i < 9; i++) {
            function_Buttons[i].addActionListener(this);
            function_Buttons[i].setFont(myFont);
            function_Buttons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++) {
            number_of_Buttons[i]=new JButton(String.valueOf(i));
            number_of_Buttons[i].addActionListener(this);
            number_of_Buttons[i].setFont(myFont);
            number_of_Buttons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel=new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GREEN);

        panel.add(number_of_Buttons[1]);
        panel.add(number_of_Buttons[2]);
        panel.add(number_of_Buttons[3]);
        panel.add(addButton);
        panel.add(number_of_Buttons[4]);
        panel.add(number_of_Buttons[5]);
        panel.add(number_of_Buttons[6]);
        panel.add(subButton);
        panel.add(number_of_Buttons[7]);
        panel.add(number_of_Buttons[8]);
        panel.add(number_of_Buttons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(number_of_Buttons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        calculator calc=new calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if(e.getSource()==number_of_Buttons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==decButton) {
            textField.setText(textField.getText().concat(String.valueOf(".")));
        }

        if(e.getSource()==addButton) {
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }

        if(e.getSource()==subButton) {
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }

        if(e.getSource()==mulButton) {
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }

        if(e.getSource()==divButton) {
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }

        if(e.getSource()==equButton) {
            num2=Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }

        if(e.getSource()==clrButton) {
            textField.setText("");
        }

        if(e.getSource()==delButton) {
            String string=textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        if(e.getSource()==negButton) {
            double temp=Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}