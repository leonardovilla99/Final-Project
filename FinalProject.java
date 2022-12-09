package finalproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class FinalProject extends JFrame{

    // Objects
    private JPanel login, car, payment;
    private JButton nextL, nextC, nextP;
    private JLabel labelL, labelC, labelP;
    private JRadioButton rbCar1, rbCar2, rbCar3, rbCar4;
    private JCheckBox cbMetal, cbTags, cbPackB;
    private ButtonGroup bgCars;
    

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
        
        JLabel fname=new JLabel("Name: ");
        JTextField name=new JTextField("    ");
        JLabel Address=new JLabel("Address: ");
        JTextField address=new JTextField("    ");
        JLabel PhoneNumber=new JLabel("Phone Number: ");
        JTextField phonenumber=new JTextField("    ");
        
         
        
        labelL = new JLabel("Login");   //Label

        login = new JPanel();                //Panel        
        login.add(labelL);
        login.add(nextL);
        login.add(fname);
        login.add(name);
        login.add(Address);
        login.add(address);
        login.add(PhoneNumber);
        login.add(phonenumber);
    }

    public void carPanel(){
        nextC = new JButton("Next");    //Button
        nextC.addActionListener(new NextPage());

        rbCar1 = new JRadioButton("S40");
        rbCar2 = new JRadioButton("S60");
        rbCar3 = new JRadioButton("S70");
        rbCar4 = new JRadioButton("S80");

        cbMetal = new JCheckBox("Metallic Finish");
        cbTags = new JCheckBox("Titles & Tags");
        cbPackB = new JCheckBox("Package B\n(S70 and S80 only)");

        bgCars = new ButtonGroup();
        bgCars.add(rbCar1);
        bgCars.add(rbCar2);
        bgCars.add(rbCar3);
        bgCars.add(rbCar4);

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

    // This is for totaling the price for the options chosen in the car page
    private class carPayment implements ActionListener {
        double subTotal, s40=27700.00, s60=32500.00, s70=36000.00, s80=44000.00,
        packB=3250.00, metalPaint=650.00, titleTags=325.00;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(rbCar1.isSelected())
                subTotal = s40;
            else if(rbCar2.isSelected())
                subTotal = s60;
            else if(rbCar3.isSelected())
                subTotal = s70;
            else if(rbCar4.isSelected())
                subTotal = s80;
            if(cbPackB.isSelected())
                subTotal += packB;
            if(cbMetal.isSelected())
                subTotal += metalPaint;
            if(cbTags.isSelected())
                subTotal += titleTags;
            subTotal+=(subTotal*0.06);
        }
        
    }

    public static void main(String[] args) { 
        new FinalProject();
    }
}