/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobayer.database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import jobayer.forms.Home;
import jobayer.info.AttendanceProcessInfo;
import jobayer.info.UserInfo;

/**
 *
 * @author jobayer
 */
public class Database implements ActionListener{
    protected String USERNAME="jobayersozib";
    protected String PASSWORD="123456";
    protected String CONN_STR="jdbc:mysql://localhost/employee_management";
    protected Connection cn=null;
    protected PreparedStatement pstm;
    protected ResultSet rset;
    private String sql;
    private String userId;
    private String passWord;
    private String post;
    private String accessLevel;
    private boolean isUnique=true;
    private String[] data;
    private int y=3;
    private int holdArrayPointer=0;
    private JCheckBox[] jb=new JCheckBox[6];
    
    
    
   public Database() {
        try {
            
            this.cn=DriverManager.getConnection(this.CONN_STR,this.USERNAME,this.PASSWORD);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
   } 
    public Database(JLabel errLabel,JFrame jf,String uid,String pass,String post) {
    
        try {
            
            this.cn=DriverManager.getConnection(this.CONN_STR,this.USERNAME,this.PASSWORD);
            this.sql="select* from employee_login where uid=? and pass=? and post=?";
            this.pstm=this.cn.prepareStatement(this.sql);
            this.pstm.setString(1,uid);
            this.pstm.setString(2,pass);
            this.pstm.setString(3,post);
            this.rset=pstm.executeQuery();
            while(rset.next()){
                    this.userId=rset.getString("uid");
                    this.passWord=rset.getString("pass");
                    this.post=rset.getString("post");
                    this.accessLevel=rset.getString("access");
                }
            
           
           this.checkLogin(errLabel,jf,uid, pass, post);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    
    }
    
    public void checkLogin(JLabel jl,JFrame jf,String uid,String pass,String post){
       if(uid.equals(this.userId) && pass.equals(this.passWord) && post.equals(this.post)){
            new Home(this.accessLevel,this.post,this.userId,this.passWord);
            jf.hide();
            
       }else{
           jl.setVisible(true);
       
       }
        
    }
    
    
    public void addEmployee(String[] info){
        
        
        this.sql="INSERT INTO `employee_login`(`uid`, `pass`, `post`, `access`)"
                + " VALUES (?,?,?,?)";
        
        try {    
            this.pstm=this.cn.prepareStatement(this.sql);
            this.pstm.setString(1,info[1]);
            this.pstm.setString(2,info[2]);
            this.pstm.setString(3,info[3]);
            this.pstm.setString(4,info[9]);
            this.pstm.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            this.isUnique=false;
        }
        
        if(this.isUnique){
        
            this.sql="INSERT INTO `employee_details`"
                    + "(`id`, `name`, `phone`, `email`, `joining`, `sex`, `address`,`salary`, `daily_allowence`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            try {
                this.pstm=this.cn.prepareStatement(this.sql);
                this.pstm.setString(1,info[1]);
                this.pstm.setString(2,info[0]);
                this.pstm.setString(3,info[4]);
                this.pstm.setString(4,info[5]);
                this.pstm.setString(5,info[8]);
                this.pstm.setString(6,info[11]);
                this.pstm.setString(7,info[10]);
                this.pstm.setString(8,info[6]);
                this.pstm.setString(9,info[7]);
                this.pstm.executeUpdate();
                JOptionPane.showMessageDialog(null,"Employee added successfully","Success",JOptionPane.PLAIN_MESSAGE);
                
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

            }
   
        }    
        
    }
    
    public void fillAdminPanel(JTextField post,JTextField id,JTextArea addressField,JComboBox userType){
        userType.setSelectedItem(UserInfo.accessLevel);
        id.setText(UserInfo.userId);
        post.setText(UserInfo.post);
    }
    
    
    public void fillGeneralPanel(
            JTextField name,JTextField pass,JTextField phoneNo,
            JTextField email,JTextArea address,JTextField salary,JTextField allowence
    ){
        this.sql="SELECT * FROM `employee_details` WHERE id=?";
        try {
            this.pstm=this.cn.prepareStatement(this.sql);
            this.pstm.setString(1,UserInfo.userId);
            this.rset=this.pstm.executeQuery();
            pass.setText(UserInfo.password);
        
        while(this.rset.next()){
        
            
            name.setText(this.rset.getString("name"));
            phoneNo.setText(this.rset.getString("phone"));
            email.setText(this.rset.getString("email"));
            address.setText(this.rset.getString("address"));
            salary.setText(this.rset.getString("salary"));
            allowence.setText(this.rset.getString("daily_allowence"));
                    
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    
    }
    
    public void generalUpdate(JTextField pass,JTextField name,JTextField mobile,JTextField email,JTextArea address){
        this.sql="UPDATE `employee_login` SET `pass`=? WHERE uid=?";
        try {
            this.pstm=this.cn.prepareStatement(this.sql);
            this.pstm.setString(1,pass.getText());
            this.pstm.setString(2,UserInfo.userId);
            int check=this.pstm.executeUpdate();
            if(check==1){
                
                this.sql="UPDATE `employee_details` SET `name`=?,"
                        + "`phone`=?,`email`=?,`address`=?"
                        + " WHERE id=?";
                this.pstm=this.cn.prepareStatement(this.sql);
                this.pstm.setString(1,name.getText());
                this.pstm.setString(2,mobile.getText());
                this.pstm.setString(3,email.getText());
                this.pstm.setString(4,address.getText());
                this.pstm.setString(5,UserInfo.userId);
                this.pstm.executeUpdate();
                JOptionPane.showMessageDialog(null,"All information updated","Success",JOptionPane.PLAIN_MESSAGE);
            }else{
                
                JOptionPane.showMessageDialog(null,"Fail to update try again","Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    
    }
    
    public void adminUpdate(JTextField userId,JTextField salary,JTextField allowence,JTextField post,JComboBox access ){
    this.sql="UPDATE `employee_details` SET `salary`=?,`daily_allowence`=? WHERE id=?";
        try {
            this.pstm=this.cn.prepareStatement(this.sql);
            this.pstm.setString(1,salary.getText());
            this.pstm.setString(2,allowence.getText());
            this.pstm.setString(3,userId.getText());
            int i=this.pstm.executeUpdate();
            if(i==0){
                JOptionPane.showMessageDialog(null,"Fail to update data. check user id","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                this.sql="UPDATE `employee_login` SET `post`=?,`access`=? WHERE uid=?";
                this.pstm=this.cn.prepareStatement(this.sql);
                this.pstm.setString(1,post.getText());
                this.pstm.setString(2,(String)access.getSelectedItem());
                this.pstm.setString(3,userId.getText());
                int check=this.pstm.executeUpdate();
                if(check==1){
                    JOptionPane.showMessageDialog(null,"Updated","Success",JOptionPane.PLAIN_MESSAGE);
                }else{
                
                    JOptionPane.showMessageDialog(null,"Fail to update data","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
    
    
    public void removeEmployee(String id,JLabel msg){
    
    this.sql="DELETE FROM `employee_details` WHERE id=?";
        
            if(id.equals(UserInfo.userId)){
                msg.setText("You can't remove yourself !!!");
                msg.setVisible(true);
            }else{
                try{
                
                    this.pstm=this.cn.prepareStatement(this.sql);
                    this.pstm.setString(1,id);
                    this.pstm.executeUpdate();
                    this.sql="DELETE FROM `employee_attendance` WHERE id=?";
                    this.pstm=this.cn.prepareStatement(this.sql);
                    this.pstm.setString(1,id);
                    this.pstm.executeUpdate();
                    this.sql="DELETE FROM `employee_login` WHERE uid=?";
                    this.pstm=this.cn.prepareStatement(this.sql);
                    this.pstm.setString(1,id);
                    int confermation= this.pstm.executeUpdate();
                    if(confermation==1){
                       JOptionPane.showMessageDialog(null,"Employee with id: "+id+" Removed","Success",JOptionPane.PLAIN_MESSAGE);

                    }else{

                       msg.setText("fail to remove employee try again !!!");
                       msg.setVisible(true);

                     }
                
                }catch(Exception ex){
                
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.PLAIN_MESSAGE);

                
                }
                
            
            }
            
        
    
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < this.jb.length; i++) {
            if(jb[i]!=null){
                if(jb[i].isSelected()){
            
                System.out.println(e.getActionCommand()+" is Attend");
            }else{
                System.out.println(e.getActionCommand()+" is Absent");
            
            }
            
            }
            
        }
    }
    
}    
