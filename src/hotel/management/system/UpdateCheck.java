
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;



public class UpdateCheck extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    UpdateCheck(){
        
        JLabel l1 = new JLabel("Check-In Details");
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(80,30,200,30);
        add(l1);
        
        JLabel l2 = new JLabel("Customer-ID");
        l2.setBounds(50,80,100,30);
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs =c.s.executeQuery("Select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        c1.setBounds(200,80,150,25);
        add(c1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(50,120,100,30);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Name");
        l4.setBounds(50,160,100,30);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("Check-In");
        l5.setBounds(50,200,100,30);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);
        
        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(50,240,100,30);
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);
        
        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(50,280,100,30);
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);  
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,340,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150,340,100,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(270,340,100,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        //Image i2 =i1.getImage().getScaledInstance(500,550,Image.SCALE_DEFAULT);
        //ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i1);
        l.setBounds(380,65,500,300);
        add(l);

        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,200,920,500);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String room = null;
                String deposit =null;
                int amountpaid;
                String price = null;
                conn c = new conn();
                String id = (String)c1.getSelectedItem();
                String str ="select * from customer where number = '"+id+"';";
                ResultSet rs =c.s.executeQuery(str);
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room = t1.getText();
                    deposit = t4.getText();
                }
                ResultSet rs2 =c.s.executeQuery("select * from room where room = '"+room+"';");
               // int left =
                while(rs2.next()){
                    price = rs2.getString("price");
                    amountpaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountpaid));
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == b2){
            
        }else if(ae.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }
    
    
}
