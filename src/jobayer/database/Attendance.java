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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author jobayer
 */
public class Attendance implements ActionListener{

    protected static String USERNAME="jobayersozib";
    protected static String PASSWORD="123456";
    protected static String CONN_STR="jdbc:mysql://localhost/employee_management";
    protected static Connection connect;
    protected   static PreparedStatement pstm;
    protected  JPanel jp;
    protected  static ResultSet rset;
    protected  static String sql;
    public static int startingRow=0;
    private int track=0;
    //private int y=5;
    private   static int numOfRow=11;
    private   String[] arr={"","","","","","","","","","",""};
    private   JCheckBox[] cb=new JCheckBox[3];
    private  JLabel jl;
    private int check=0;
    public Attendance(){}
    
    public Attendance(JPanel jp,JCheckBox[] cb,JLabel jl){
    
        
        try {
            Attendance.connect=DriverManager.getConnection(Attendance.CONN_STR,Attendance.USERNAME,Attendance.PASSWORD);
            this.sql="SELECT * FROM `employee_login` WHERE 1 LIMIT ?,?";
            //this.jp=jp;
            this.cb=cb;
            this.jl=jl;
            Attendance.pstm=this.connect.prepareStatement(this.sql);
            Attendance.pstm.setInt(1,Attendance.startingRow);
            Attendance.pstm.setInt(2,Attendance.numOfRow);
            Attendance.rset=this.pstm.executeQuery();
            
            //System.out.println(this.rset.getFetchSize());
            this.init();
            this.check=0;
            while(rset.next()){
                this.check=1;
                this.arr[this.track]=rset.getString("uid");
                this.track+=1;
           
            }
            this.loadEmployeeId();
            this.startingRow+=this.numOfRow;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
    
   
    
}
   
 private void init(){
 
    for(int i=0;i<this.arr.length;i++){
       this.arr[i]="";

    }
 
 }
 private void dismissCheckBox(){
    
        for(int i=0;i<this.cb.length;i++){
            cb[i].setVisible(false);
            cb[i].removeActionListener(this);
        }
        this.jl.setText("No more Employee");
    
 }
    
    public void loadEmployeeId(){
        if(this.check==0){
            this.dismissCheckBox();
        }else{
            for (int i=0;i<this.arr.length;i++) {

                    if(this.arr[i].equals("")){
                        this.cb[i].setVisible(false);

                    }
                    else{

                        this.cb[i].setVisible(true);
                        this.cb[i].setSelected(false);
                        this.cb[i].setText(this.arr[i]);

                    }


            }
        }
    
    }
    
   
    
    public static void showDetails(String id,JLabel name,JLabel mobile,JLabel email){
    
    Attendance.sql="SELECT * FROM `employee_details` WHERE id=?";
    
        try {
            Attendance.pstm=Attendance.connect.prepareStatement(Attendance.sql);
            Attendance.pstm.setString(1, id);
            Attendance.rset=Attendance.pstm.executeQuery();
            while(Attendance.rset.next()){
            
                name.setText(Attendance.rset.getString("name"));
                mobile.setText(Attendance.rset.getString("phone"));
                email.setText(Attendance.rset.getString("email"));
            }
        } catch (SQLException ex) {
            
        }
   
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    
    



}
