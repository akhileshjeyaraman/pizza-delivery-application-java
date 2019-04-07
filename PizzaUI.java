package com.company.AJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;

public class PizzaUI extends JFrame {

    private JButton CalcPrice,AnotherOrder,NewCust,Exit;

    private JLabel PizzaSizeLabel,Toppings;
    private JRadioButton S,M,L;
    private JCheckBox Paneer,Mushroom,ExtraCheese,Jalapenos,Olives;
    private ButtonGroup group;

    private JLabel textLabel,imageLabel1,imageLabel2;
    ImageIcon imageIcon1;
    ImageIcon imageIcon2;

    private JComboBox<Integer> NoOfPizzas;

    private JTextField CustName;
    private JLabel CustomerName;
    private JTextField CustNo;
    private JLabel CustNum;

    private JTextArea ta;
    private JScrollPane scrollPane;

    private JPanel pNorth, pSouth, pCenter, pSideText;

    private JPanel pSidePanel,pTopSide,pBotSide,pMidSide;

    private double grandTotal;

    private String name;
    private long phoneNum;
    private double price;
    private int toppingsCount,pizzaCount;
    private String toppingsList;
    private String pizzaSize;

    public PizzaUI()
    {
        toppingsList="Regular";
        grandTotal=0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container window=getContentPane();
        window.setLayout(new BorderLayout(10,10));

        NoOfPizzas = new JComboBox<>();
        NoOfPizzas.addItem(0);
        NoOfPizzas.addItem(1);
        NoOfPizzas.addItem(2);
        NoOfPizzas.addItem(3);
        NoOfPizzas.addItem(4);
        NoOfPizzas.addItem(5);
        NoOfPizzas.setSelectedIndex(1);

        ta=new JTextArea("",20,20);
        ta.setEditable(false);
        scrollPane=new JScrollPane(ta);

        pNorth=new JPanel();
        pNorth.setLayout(new GridLayout(1,3));

        pCenter=new JPanel();
        pCenter.setLayout(new GridLayout(1,2));

        pTopSide=new JPanel();
        pTopSide.setLayout(new GridLayout(2,4));
        pTopSide.setBorder(BorderFactory.createMatteBorder(
                0, 0, 5, 0, Color.GRAY));
        pMidSide=new JPanel();
        pMidSide.setLayout(new GridLayout(6,1));

        pBotSide=new JPanel();
        pBotSide.setLayout(new GridLayout(1,4));
        pBotSide.setBorder(BorderFactory.createMatteBorder(
                5, 0, 0, 0, Color.GRAY));

        pSouth=new JPanel();
        pSouth.setLayout(new GridLayout(1,4));

        S=new JRadioButton("S");
        M=new JRadioButton("M");
        L=new JRadioButton("L");

        /*Grouping the buttons for simplicity of operations*/
        group=new ButtonGroup();
        group.add(S);
        group.add(M);
        group.add(L);

        textLabel =new JLabel();
        imageLabel1 = new JLabel();
        imageLabel2 = new JLabel();

        imageIcon1 = new ImageIcon("vidyalankar.png");
        imageIcon2 = new ImageIcon("pizza2.png");

        Image image1 = imageIcon1.getImage();
        Image NewImage1 = image1.getScaledInstance(300,200,Image.SCALE_SMOOTH);
        imageIcon1 = new ImageIcon(NewImage1);

        Image image2 = imageIcon2.getImage();
        Image NewImage2 = image2.getScaledInstance(180,180,Image.SCALE_SMOOTH);
        imageIcon2 = new ImageIcon(NewImage2);


        CustomerName = new JLabel();
        CustomerName.setText("Customer Name: ");
        CustName = new JTextField("",2);
        CustNum = new JLabel();
        CustNum.setText("Phone Number: ");
        CustNo = new JTextField("",2);

        imageLabel1.setIcon(imageIcon1);
        imageLabel1.setOpaque(true);
        imageLabel1.setBackground(Color.GRAY);

        imageLabel2.setIcon(imageIcon2);
        imageLabel2.setOpaque(true);
        imageLabel2.setBackground(Color.GRAY);

        /*A Label to contain the Welcome Text*/
        textLabel.setText("PIZZALANKAR");
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Showcard Gothic",0,38));
        textLabel.setOpaque(true);
        textLabel.setBackground(Color.GRAY);


        /*Add the Welcome Text to the North Panel*/
        pNorth.add(imageLabel1);
        pNorth.add(textLabel);
        pNorth.add(imageLabel2);

        pSideText=new JPanel();
        pSideText.setLayout(new GridLayout(1,1));
        pSideText.add(scrollPane);

        Toppings=new JLabel("Toppings (Rs 20 each): ");
        Paneer=new JCheckBox("Paneer");
        Mushroom=new JCheckBox("Mushroom");
        ExtraCheese=new JCheckBox("Extra Cheese");
        Jalapenos=new JCheckBox("Jalapenos");
        Olives=new JCheckBox("Olives");

        PizzaSizeLabel=new JLabel("Pizza Size: ");

        pTopSide.add(CustomerName);
        pTopSide.add(CustName);
        pTopSide.add(CustNum);
        pTopSide.add(CustNo);
        pTopSide.add(PizzaSizeLabel);
        pTopSide.add(S);
        pTopSide.add(M);
        pTopSide.add(L);

        pMidSide.add(Toppings);
        pMidSide.add(Paneer);
        pMidSide.add(Mushroom);
        pMidSide.add(ExtraCheese);
        pMidSide.add(Jalapenos);
        pMidSide.add(Olives);

        pBotSide.add(new JLabel("Number of Pizzas: "));
        pBotSide.add(NoOfPizzas);

        pSidePanel=new JPanel();
        pSidePanel.setLayout(new BorderLayout(10,10));
        pSidePanel.add("North",pTopSide);
        pSidePanel.add("Center",pMidSide);
        pSidePanel.add("South",pBotSide);

        CalcPrice = new JButton("Calculate Price");
        AnotherOrder=new JButton("Another Order");
        NewCust=new JButton("New Customer");
        Exit=new JButton("Exit");

        pSouth.add(CalcPrice);
        pSouth.add(AnotherOrder);
        pSouth.add(NewCust);
        pSouth.add(Exit);

        ClickAction handler=new ClickAction();
        CalcPrice.addActionListener(handler);
        NewCust.addActionListener(handler);
        AnotherOrder.addActionListener(handler);
        Exit.addActionListener(handler);
        pCenter.add(pSidePanel);
        pCenter.add(pSideText);

        window.add("North",pNorth);
        window.add("Center",pCenter);
        window.add("South",pSouth);

    }


    private class ClickAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            /*Calculate Price Button*/
            if(event.getSource()==CalcPrice)
            {
                getRadioButton();
                getCheckedBoxes();
                try
                {
                    /*Integer.valueOf throws an Exception if an Integer is not entered which is necessary for Number of pizzas*/
                    pizzaCount= NoOfPizzas.getSelectedIndex();

                    /*If its not a positive integer above 0 also lets throw the same Exception */
                    if(pizzaCount<1)
                        throw new Exception();

                    else if(pizzaCount>0)
                    {
                        name = CustName.getText();
                        try
                        {
                            phoneNum = Long.valueOf(CustNo.getText());
                        }catch (NumberFormatException e) {

                            JPanel warning=new JPanel();
                            JOptionPane.showMessageDialog
                                    (warning,
                                            "Please Enter a valid Phone Number!!!",
                                            "Invalid Phone Number!!",
                                            JOptionPane.ERROR_MESSAGE
                                    );

                        }
                        ta.append("\nCustomer Name: ");
                        ta.append(name+"\n");
                        ta.append("\nPhone Number: ");
                        ta.append(phoneNum+"\n");
                        ta.append("\nPizza Size: ");
                        ta.append(pizzaSize+"(Rs"+price+")"+"\n");
                        ta.append("\nNumber Of Pizzas: ");
                        ta.append(pizzaCount+"\n");
                        ta.append("\nNumber of Toppings: ");
                        ta.append(toppingsCount+"\n");
                        ta.append("\nToppings: ");
                        ta.append(toppingsList+"\n");
                        /*Calculate price without GST*/
                        ta.append("\nPrice of each Pizza without Tax: ");
                        if(toppingsCount>1)
                        {
                            price += (20*toppingsCount);

                        }
                        ta.append(price+"\n");
                        ta.append("\nGST (5%): ");
                        ta.append((((0.05*price*pizzaCount))+"\n"));
                        ta.append("\nTotal: ");

                        /*Calculate Price with 5% GST*/
                        price=(((0.05*price*pizzaCount)+price*pizzaCount));
                        ta.append(price+"\n\n");

                        /*Add Current Pizza Price to the GrandTotal*/
                        grandTotal+=price;
                        ta.append("\nGrand Total: Rs");
                        ta.append(grandTotal+"\n\n");
                        String getData = ta.getText();
                        FileWriter fileWriter = new FileWriter("Customers.txt",true);
                        fileWriter.write(getData);
                        fileWriter.close();
                    }
                }
                catch(Exception e)
                {
                    JPanel warning=new JPanel();
                    JOptionPane.showMessageDialog
                            (warning,
                                    "Please Choose a Positive Integer more than 0 in the Number of Pizzas Field!!!",
                                    "Invalid number of pizzas!!",
                                    JOptionPane.ERROR_MESSAGE
                            );
                }
            }

            /*Exit Button*/
            if(event.getSource()==Exit)
            {
                System.exit(0);
            }

            /*Another Order Button*/
            if(event.getSource()==AnotherOrder)
            {
                /*Clear the selections for a fresh order*/
                group.clearSelection();
                Paneer.setSelected(false);
                Mushroom.setSelected(false);
                ExtraCheese.setSelected(false);
                Jalapenos.setSelected(false);
                Olives.setSelected(false);
                NoOfPizzas.setSelectedIndex(1);
            }

            /*New Customer Button*/
            if(event.getSource()==NewCust)
            {
                /*Clear the selections and Grand Total and Text Area*/
                ta.setText("");
                grandTotal=0;
                group.clearSelection();
                Paneer.setSelected(false);
                Mushroom.setSelected(false);
                ExtraCheese.setSelected(false);
                Jalapenos.setSelected(false);
                Olives.setSelected(false);
                NoOfPizzas.setSelectedIndex(1);
                CustName.setText("");
                CustNo.setText("");
            }
        }
    }

    private void getRadioButton()
    {

        price = 0.0;
        if(S.isSelected())
        {
            pizzaSize="Small";
            price = 120.0;
        }
        else if(M.isSelected())
        {
            pizzaSize="Medium";
            price = 250.0;
        }
        else if(L.isSelected())
        {
            pizzaSize="Large";
            price = 350.0;
        }
        else
        {
            JPanel warning=new JPanel();
            JOptionPane.showMessageDialog
                    (warning,
                            "Please Choose a Size!!!\nFrom the given sizes above!!!",
                            "Choose a Size!!!",
                            JOptionPane.ERROR_MESSAGE
                    );
        }
    }

    private void getCheckedBoxes()
    {
        toppingsCount=0;
        toppingsList="Regular";

        if(price==0.0)
        {
            JPanel warning=new JPanel();
            JOptionPane.showMessageDialog
                    (warning,
                            "Please Choose something!!!\nFrom the given options!!!",
                            "Choose something!!!",
                            JOptionPane.ERROR_MESSAGE
                    );
        }
        else
        {
            if(Paneer.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", Paneer";
            }
            if(Jalapenos.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", Jalapenos";
            }
            if(Mushroom.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", Mushroom";
            }
            if(ExtraCheese.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", Extra Cheese";
            }
            if(Olives.isSelected())
            {
                toppingsCount++;
                toppingsList=toppingsList+", Olives";
            }
        }
    }
}

