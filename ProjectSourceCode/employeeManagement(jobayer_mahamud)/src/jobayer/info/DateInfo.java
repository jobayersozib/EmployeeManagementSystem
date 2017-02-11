/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobayer.info;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author jobayer
 */
public class DateInfo {
    private static Locale local=Locale.ENGLISH;
    private static DateFormat dateFormat;
    private static String day;
    private static String month;
    private static String year;
    private static String date;
    private static String fullDate;
    
    
    public static void SetDate(String date,int month,int day){
        DateInfo.setMonth(month);
        DateInfo.setDay(day);
        DateInfo.fullDate=date;
    }
    private static void setMonth(int monthNum){
        
        switch(monthNum){
        
            case 0:
                DateInfo.month="January";
                break;
            case 1:
                DateInfo.month="February";
                break;
            
            case 2:
                DateInfo.month="March";
                break;
                
            case 3:
                DateInfo.month="April";
                break;
            
            case 4:
                DateInfo.month="May";
                break;
            
            case 5:
                DateInfo.month="June";
                break;
                
            case 6:
                DateInfo.month="July";
                break;
                
                
            case 7:
                DateInfo.month="August";
                break; 
                
            case 8:
                DateInfo.month="September";
                break;  
                
            case 9:
                DateInfo.month="October";
                break;    
                
            case 10:
                DateInfo.month="November";
                break;
            
            case 11:
                DateInfo.month="December";
                break;
                
            default:
                DateInfo.month="Error";
                break;
        }
        
    }
    
    
    public static String getMonth(){
    
        return DateInfo.month;
    
    }
    

    private static void setDay(int dayNum){
    
        switch(dayNum){
        
            case 7:
                DateInfo.day="Saturday";
                break;
            case 1:
                DateInfo.day="Sunday";
                break;
            
            case 2:
                DateInfo.day="Monday";
                break;
                
            case 3:
                DateInfo.day="Tuesday";
                break;
            
            case 4:
                DateInfo.day="Wednesday";
                break;
            
            case 5:
                DateInfo.day="Thursday";
                break;
                
            case 6:
                DateInfo.day="Friday";
                break;
                
            default:
                DateInfo.day="Error";
                break;
        }
    
    
    }
    
    public static String getDay(){
        return DateInfo.day;
    }
    
    public static String getDate(){
    
        return DateInfo.fullDate;
    
    }
    
    
}
