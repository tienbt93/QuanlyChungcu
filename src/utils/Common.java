/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author PTIT
 */
public class Common {
    public static String formatDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YY");
        return simpleDateFormat.format(date);
    }
    public static Date parserDate(String date) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YY");
        java.util.Date dateCon=simpleDateFormat.parse(date);
        Long longTime=dateCon.getTime();
        Date date1=new Date(longTime);
        return date1 ;
    }
    public static String formatMoney(double money){
        DecimalFormat formatter = new DecimalFormat("###,###,###,###");
        return formatter.format(money)+" VNĐ";
    }
}
