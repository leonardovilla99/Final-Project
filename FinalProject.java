import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class FinalProject extends JFrame{

    // Objects
    private JPanel login, car, payment;
    private JButton nextL, nextC, nextP;
    private JLabel labelL, labelC, labelP;

    public FinalProject(){
        // Panel
        loginPanel();
        carPanel();
        paymentPanel();

        // Frame
        add(login);
        this.setSize(800,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Car");
    }

    public void loginPanel(){
        nextL = new JButton("Next");    //Button
        nextL.addActionListener(new NextPage());
        
        labelL = new JLabel("Login");   //Label

        login = new JPanel();                //Panel        
        login.add(labelL);
        login.add(nextL);
    }

    public void carPanel(){
        nextC = new JButton("Next");    //Button
        nextC.addActionListener(new NextPage());

        labelC = new JLabel("Car");     //Label

        car = new JPanel();                  //Panel
        car.add(labelC);
        car.add(nextC);
    }

    public void paymentPanel(){
        nextP = new JButton("Next");    //Button
        nextP.addActionListener(new NextPage());

        labelP = new JLabel("Payment"); //Label

        payment = new JPanel();              //Panel
        payment.add(labelP);
        payment.add(nextP);
    }

    private class NextPage implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == nextL){
                login.setVisible(false);
                add(car);
            }else if(e.getSource() == nextC){
                car.setVisible(false);
                add(payment);
            }else if(e.getSource() == nextP){
                // Total
                JOptionPane.showMessageDialog(null, "Your total is: ");
            }
        }

    }

    public static void main(String[] args) { 
        new FinalProject();
    }
}
