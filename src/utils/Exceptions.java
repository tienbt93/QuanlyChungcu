/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author PTIT
 */
public class Exceptions extends Exception{
    
    public static int checkInt(String s){
        int n=Integer.parseInt(s);
        return n;
    }
}
