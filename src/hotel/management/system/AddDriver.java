
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddDriver extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;
    AddDriver(){
        JLabel title = new JLabel("Add Driver");
        title.setBounds(150,10,150,30);
        title.setFont(new Font("Tahoma",Font.BOLD,18));
        add(title);
        
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        name.setBounds(60, 70, 100, 30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1); 
        
        
        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,14));
        age.setBounds(60, 110, 100, 30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200,110,150,30);
        add(t2);
        
        JLabel gender  = new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,14));
        gender.setBounds(60, 150, 100, 30);
        add(gender);
        
        c1= new JComboBox(new String[] {"Male", "Female"});
        c1.setBounds(200,150,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        JLabel car  = new JLabel("Car");
        car.setFont(new Font("Tahoma",Font.PLAIN,14));
        car.setBounds(60, 190, 100, 30);
        add(car);
        
        t3 = new JTextField();
        t3.setBounds(200,190,150,30);
        add(t3);
        
        JLabel model = new JLabel("Model");
        model.setFont(new Font("Tahoma",Font.PLAIN,14));
        model.setBounds(60, 230, 100, 30);
        add(model);
        
        t4 = new JTextField();
        t4.setBounds(200,230,150,30);
        add(t4);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,14));
        available.setBounds(60, 270, 100, 30);
        add(available);
        
        c2= new JComboBox(new String[] {"Available", "Busy"});
        c2.setBounds(200,270,150,30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,14));
        location.setBounds(60, 310, 100, 30);
        add(location);
        
        t5 = new JTextField();
        t5.setBounds(200,310,150,30);
        add(t5);
        
        b1 = new JButton("Add Driver");
        b1.setBounds(60,370, 130, 30);
        b1.setBackground(Color.BLACK );
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(220,370,130,30);
        b2.setBackground(Color.BLACK );
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(370,80, 500, 300);
        add(l1);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,900,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            String name = t1.getText();
        String age = t2.getText();
        String gender=(String)c1.getSelectedItem();
        String car = t3.getText();
        String model= t4.getText();
        String status=(String)c2.getSelectedItem();
        String location = t5.getText();
        
        
            conn c = new conn();
            try{
                String str ="insert into driver values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+status+"','"+location+"');";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver Added");
                this.setVisible(false);
                
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new AddDriver();
    }
    
}
