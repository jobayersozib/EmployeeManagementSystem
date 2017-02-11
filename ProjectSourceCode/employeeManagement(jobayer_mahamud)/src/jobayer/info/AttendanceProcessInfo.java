/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobayer.info;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import jobayer.database.Attendance;

/**
 *
 * @author jobayer
 */
public class AttendanceProcessInfo extends Attendance{
    public static int trackError=0;
    private static JCheckBox[] attendanceIdBox;
    
    public static void submitAttendance(JCheckBox[] jc,JTextArea fail,JTextArea success,JButton nextBtn){
        AttendanceProcessInfo.attendanceIdBox=jc;
        Attendance.sql="INSERT INTO `employee_attendance`(`key`, `id`, `attendance_status`, `date`,"
                + " `month`, `day`, `attendance_given`) VALUE(?,?,?,?,?,?,?)";
        try {
            Attendance.pstm=Attendance.connect.prepareStatement(Attendance.sql);
            for(int i=0;i<jc.length;i++){
                if(jc[i].isSelected()&& jc[i].isVisible()){
                    //System.out.println(jc[i].getText()+" Is present today");
                    
                    Attendance.pstm.setString(1,jc[i].getText()+"_"+DateInfo.getDate());
                    Attendance.pstm.setString(2,jc[i].getText());
                    Attendance.pstm.setString(3,"Present");
                    Attendance.pstm.setString(4,DateInfo.getDate());
                    Attendance.pstm.setString(5,DateInfo.getMonth());
                    Attendance.pstm.setString(6,DateInfo.getDay());
                    Attendance.pstm.setString(7,UserInfo.userId);
                    int status=Attendance.pstm.executeUpdate();
                    if(status!=1){
                        //fail.setText(fail.getText()+jc[i].getText()+" ,");

                    }else{

                        success.setText(success.getText()+jc[i].getText()+" ,");
                    }
                    

                }else if(jc[i].isVisible()){

                    Attendance.pstm.setString(1,jc[i].getText()+"_"+DateInfo.getDate());
                    Attendance.pstm.setString(2,jc[i].getText());
                    Attendance.pstm.setString(3,"Absent");
                    Attendance.pstm.setString(4,DateInfo.getDate());
                    Attendance.pstm.setString(5,DateInfo.getMonth());
                    Attendance.pstm.setString(6,DateInfo.getDay());
                    Attendance.pstm.setString(7,UserInfo.userId);
                    int status=Attendance.pstm.executeUpdate();
                    if(status!=1){
                        //fail.setText(fail.getText()+jc[i].getText()+" ,");

                    }else{

                        success.setText(success.getText()+jc[i].getText()+" ,");
                    }

                }
            AttendanceProcessInfo.trackError++;
                
        }
            
        
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        finally{
            fail.setText(null);
            for(int i=AttendanceProcessInfo.trackError;i<AttendanceProcessInfo.attendanceIdBox.length;i++){
                if(AttendanceProcessInfo.attendanceIdBox[i].isVisible()){
                    
                    fail.setText(fail.getText()+AttendanceProcessInfo.attendanceIdBox[i].getText()+", ");
                }
            
            }
            //System.out.println("length of "+AttendanceProcessInfo.attendanceIdBox.length);
            
        
        }
        
    
    }
    
    
}
