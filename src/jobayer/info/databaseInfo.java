/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobayer.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import jobayer.database.Attendance;

/**
 *
 * @author jobayer
 */
public class databaseInfo extends Attendance{
    //public static String USERNAME="jobayersozib";
    //public static String PASSWORD="123456";
    //public static String CONN_STR="jdbc:mysql://localhost/employee_management";
    //public static Connection connect;
    //public static PreparedStatement pstm;
    //public static ResultSet rset;
    //public static String sql;
    
    
    public static void attendanceCheck(JCheckBox[] jc,JTextArea fail,JTextArea success,JButton nextBtn){
        
        Attendance.sql="INSERT INTO `employee_attendance`(`key`,"
                + " `id`, `attendance_status`,"
                + "`attendance_given`) VALUES (?,?,?,?)";
        try {
            Attendance.pstm=Attendance.connect.prepareStatement(Attendance.sql);
            for(int i=0;i<jc.length;i++){
            if(jc[i].isSelected()&& jc[i].isVisible()){
                //System.out.println(jc[i].getText()+" Is present today");
                Attendance.pstm.setString(1,jc[i].getText()+"1");
                Attendance.pstm.setString(2,jc[i].getText());
                Attendance.pstm.setString(3,"Attend");
                Attendance.pstm.setString(4,UserInfo.userId);
                int status=Attendance.pstm.executeUpdate();
                if(status!=1){
                    fail.setText(fail.getText()+jc[i].getText()+" ,");
                
                }else{
                
                    success.setText(success.getText()+jc[i].getText()+" ,");
                }
                
            }else if(jc[i].isVisible()){

                Attendance.pstm.setString(1,jc[i].getText()+"1");
                Attendance.pstm.setString(2,jc[i].getText());
                Attendance.pstm.setString(3,"Absent");
                Attendance.pstm.setString(4,UserInfo.userId);
                int status=Attendance.pstm.executeUpdate();
                if(status!=1){
                    fail.setText(fail.getText()+jc[i].getText()+" ,");
                
                }else{
                
                    success.setText(success.getText()+jc[i].getText()+" ,");
                }
                
            }
            
        
        }
            
        
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    
    }
}
