import java.lang.*;
import java.util.*;

/**
 *
 * @author nigelbernard
 */
public class Fixer{
    public String remNonAlpha(String s){
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i< s.length();i++){
            //if element is not alphanumeric charc, delete
            if(!Character.isLetter(str.charAt(i))){
                str.deleteCharAt(i);
            }
        }
        return str.toString();
   }
    public String remComma(String s){// 1st
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i< s.length();i++){
            //if element is comma, delete
            if(str.charAt(i) == '.'){
                str.deleteCharAt(i);
                i--;
            }
        }
        return str.toString();
   }
    public String remQuotations(String s){//2nd
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i< s.length();i++){
            //if element is comma, delete
            if(str.charAt(i)== '"'){
                str.deleteCharAt(i);
                i--;
            }
        }
        return str.toString();
   }


    public String toLowerCase(String s){//4th
        s.toLowerCase();
        return s;
    }
    
    public String [] seperateColon(String s){//3rd
    	StringBuilder str = new StringBuilder(s);
        String array[] = new String[2];
        for(int i = 0; i< str.length();i++){
            //if element is comma, delete
            if(str.charAt(i)==':'){
                str.deleteCharAt(i);
                //found colon, fill array and return
                array[0] = str.substring(0, i -1);
                array[1] = str.substring(i, str.length());
               i = str.length();
            }
        }
         return array;
    }
}