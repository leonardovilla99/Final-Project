package finalproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class FinalProject extends JFrame{

    // Objects
    private JPanel login, car, payment, modelPanel, packagePanel, winButton, tradeIn, paymentType;
    private JButton nextL, nextC, nextP, backC, backP;
    private JRadioButton rbCar1, rbCar2, rbCar3, rbCar4, financing, credit, cash;
    private JCheckBox cbMetal, cbTags, cbPackB, tradeInCk;
    private ButtonGroup bgCars, paymentMethod;
    private JLabel labelCarPrice;
    private JTextField name, address, phonenumber, carPrice;
    

    public FinalProject(){
        // Panel
        loginPanel();
        carPanel();
        paymentPanel();

        add(login);
        this.setSize(800,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Car");
    }

    public void loginPanel(){
        nextL = new JButton("Next");    //Button
        nextL.addActionListener(new NextPage());
        
        JLabel fname=new JLabel("Name: ");
        name=new JTextField();
        JLabel Address=new JLabel("Address: ");
        address=new JTextField();
        JLabel PhoneNumber=new JLabel("Phone Number: ");
        phonenumber=new JTextField();
        JLabel emptySpace = new JLabel("");

        login = new JPanel();                //Panel 
        login.setLayout(new GridLayout(4,2));
        login.setBorder(new TitledBorder("Profile"));
        login.add(fname);
        login.add(name);
        login.add(Address);
        login.add(address);
        login.add(PhoneNumber);
        login.add(phonenumber);
        login.add(emptySpace);
        login.add(nextL);
    }

    public void carPanel(){

        nextC = new JButton("Next");    //Button
        nextC.addActionListener(new NextPage());
        backC = new JButton("Back");
        backC.addActionListener(new NextPage());

        rbCar1 = new JRadioButton("S40");
        rbCar1.setSelected(true);
        rbCar1.addActionListener(new PackageB());
        rbCar2 = new JRadioButton("S60");
        rbCar2.addActionListener(new PackageB());
        rbCar3 = new JRadioButton("S70");
        rbCar3.addActionListener(new PackageB());
        rbCar4 = new JRadioButton("S80");
        rbCar4.addActionListener(new PackageB());

        bgCars = new ButtonGroup();
        bgCars.add(rbCar1);
        bgCars.add(rbCar2);
        bgCars.add(rbCar3);
        bgCars.add(rbCar4);

        modelPanel = new JPanel();
        modelPanel.setLayout(new GridLayout(2,2));
        modelPanel.setBorder(new TitledBorder("Models"));
        modelPanel.add(rbCar1);
        modelPanel.add(rbCar2);
        modelPanel.add(rbCar3);
        modelPanel.add(rbCar4);

        cbMetal = new JCheckBox("Metallic Finish");
        cbTags = new JCheckBox("Titles & Tags");
        cbPackB = new JCheckBox("Package B\n(S70 and S80 only)");
        cbPackB.setVisible(false);

        packagePanel = new JPanel();
        packagePanel.setLayout(new GridLayout(2,2));
        packagePanel.setBorder(new TitledBorder("Packages"));
        packagePanel.add(cbMetal);
        packagePanel.add(cbTags);
        packagePanel.add(cbPackB);

        winButton = new JPanel();
        winButton.setLayout(new GridLayout(1,2));
        winButton.add(backC);
        winButton.add(nextC);

        car = new JPanel();                  //Panel
        car.setLayout(new GridLayout(3,1));
        car.add(modelPanel);
        car.add(packagePanel);
        car.add(winButton);
    }

    public void paymentPanel(){
        // Trade in
        tradeInCk = new JCheckBox("Trade-In option");
        tradeInCk.addActionListener(new TradeIn());
        labelCarPrice = new JLabel("Input your car price (trade-in value 50%):");
        carPrice = new JTextField();

        tradeIn = new JPanel();
        tradeIn.setLayout(new GridLayout(1,3));
        tradeIn.setBorder(new TitledBorder("Trade-In"));
        tradeIn.add(tradeInCk);
        tradeIn.add(labelCarPrice);
        tradeIn.add(carPrice);
        labelCarPrice.setVisible(false);
        carPrice.setVisible(false);

        financing = new JRadioButton("Financing (7% for financing)");
        credit = new JRadioButton("Credit");
        credit.setSelected(true);
        cash = new JRadioButton("Cash (deduct 750$)");
        paymentMethod = new ButtonGroup();
        paymentMethod.add(financing);
        paymentMethod.add(credit);
        paymentMethod.add(cash);

        paymentType = new JPanel();
        paymentType.setLayout(new GridLayout(2,2));
        paymentType.setBorder(new TitledBorder("Payment method"));
        paymentType.add(financing);
        paymentType.add(credit);
        paymentType.add(cash);

        nextP = new JButton("Next");    //Button
        nextP.addActionListener(new carPayment());
        backP = new JButton("Back");
        backP.addActionListener(new NextPage());

        winButton = new JPanel();
        winButton.setLayout(new GridLayout(1,2));
        winButton.add(backP);
        winButton.add(nextP);

        payment = new JPanel();              //Panel
        payment.setLayout(new GridLayout(3,1));
        payment.add(tradeIn);
        payment.add(paymentType);
        payment.add(winButton);
    }

    private class NextPage implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            // Window management
            if(e.getSource() == nextL){
                login.setVisible(false);
                if(car.isValid()){
                    car.setVisible(true);
                }else{
                    add(car);
                }
            }else if(e.getSource() == nextC){
                car.setVisible(false);
                if(payment.isValid()){
                    payment.setVisible(true);
                }else{
                    add(payment);
                }
            }else if(e.getSource() == backC){
                car.setVisible(false);
                login.setVisible(true);
            }else if(e.getSource() == backP){
                payment.setVisible(false);
                car.setVisible(true);
            }
        }

    }

    private class PackageB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            if(rbCar3.isSelected() || rbCar4.isSelected()){
                cbPackB.setVisible(true);
            }else{
                cbPackB.setVisible(false);
            }
        }

    }

    private class TradeIn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            if(tradeInCk.isSelected()){
                labelCarPrice.setVisible(true);
                carPrice.setVisible(true);
            }else{
                labelCarPrice.setVisible(false);
                carPrice.setVisible(false);
            }
        }

    }

    // This is for totaling the price for the options chosen in the car page
    private class carPayment implements ActionListener {
        String nameSt, addressSt, phoneSt;
        double subTotal, s40=27700, s60=32500, s70=36000, s80=44000,
        packB=3250, metalPaint=650, titleTags=325,
        ownCarPrice;

        @Override
        public void actionPerformed(ActionEvent e) {
            try {  
                nameSt = name.getText();
                addressSt = address.getText();
                phoneSt = phonenumber.getText();

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
                if(tradeInCk.isSelected()){
                    ownCarPrice = Double.parseDouble(carPrice.getText());
                    subTotal = subTotal - (ownCarPrice * 0.5);
                }
                if(financing.isSelected())
                    subTotal = subTotal * 1.07;
                else if(cash.isSelected())
                    subTotal = subTotal - 750;

                // Check if price is under 0
                if(subTotal <= 0)
                    JOptionPane.showMessageDialog(null, nameSt + " you have no additional payment to submit");
                else
                    JOptionPane.showMessageDialog(null, nameSt + " your total is: $" + subTotal);

            } catch(NumberFormatException error){  
                // Handle error
                JOptionPane.showMessageDialog(null, "Please input a valid number"); 
            } 
            
        }
    }

    public static void main(String[] args) { 
        new FinalProject();
    }
}