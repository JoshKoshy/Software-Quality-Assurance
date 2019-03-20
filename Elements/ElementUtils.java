import java.util.HashMap;

/**
 *
 * @author nigelbernard & joshkoshy
 */
public class ElementUtils
{
    public boolean solve(String test, String answer, HashMap<String,String> table)
    {
    	//base case - empty string
    	if(test.length() == 0)
    		return true;
    	//test one letter
    	if(table.containsKey(test.charAt(0)))
    	{
    		if(solve(test.substring(1), answer, table))
    		{
    			answer += "- " + table.get(test.charAt(0));
    			return true;
    		}
    			
    		//tests two letters
    		else if (table.containsKey(test.substring(0,2)))
    		{
    			if(solve(test.substring(2), answer, table))
    			{
    				answer += "- " + table.get(test.substring(0,2));
    				return true;
    			}
    			else
    				return false;
    		}
    	}
    	else
    		return false;
    	return false;
    }
    public String remNonAlpha(String s){
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i< str.length();i++){
            //if element is not alphanumeric charc, delete
            if(!(Character.isLetter(str.charAt(i)))){
                str.deleteCharAt(i);
                i--;
            }
        }
        return str.toString();
   }
    public String remComma(String s){// 1st
        StringBuilder str = new StringBuilder(s);
        int counter = s.length();
        for(int i = 0; i< str.length();i++){
            //if element is comma, delete
            if(str.charAt(i) == ','){
                str.deleteCharAt(i);
                i--;
		    }
        }
        return str.toString();
   }
    public String remQuotations(String s){//2nd
        StringBuilder str = new StringBuilder(s);
        int counter = s.length();
        for(int i = 0; i< str.length();i++){
            //if element is quotation, delete
            if(str.charAt(i)== '"'){
                str.deleteCharAt(i);
                i--;
            }
        }
        return str.toString();
   }
    public String remEmpty(String s){//2nd
        StringBuilder str = new StringBuilder(s);
        int counter = s.length();
        for(int i = 0; i< str.length();i++){
            //if element is quotation, delete
            if(str.charAt(i)== ' '){
                str.deleteCharAt(i);
                i--;
            }
        }
        return str.toString();
   }


    public String toUpperCase(String s){//4th
        
        return s.toUpperCase();
    }
    
    public String [] seperateColon(String s){//3rd
        StringBuilder str = new StringBuilder(s);
        String array[] = new String[2];
        for(int i = 0; i< str.length();i++){
            //if element is comma, delete
            if(str.charAt(i)==':'){
                str.deleteCharAt(i);
                //found colon, fill array and return
                array[0] = str.substring(0, i );
                array[1] = str.substring(i, str.length());
               i = str.length();
            }
        }
         return array;
    }
}
