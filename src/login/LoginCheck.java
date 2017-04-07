package login;
import java.util.regex.*;
/**
 * A program that uses regex to check the validity of an
 *      email address and password. Uses unit testing.
 * Source for email address syntax standards: 
 *      https://en.wikipedia.org/wiki/Email_address#Syntax
 * 
 * @author      Gareth Bosch
 * @assignment  Test Cases
 * @course      Software Engineering
 * @date        11/16/2016
 */

public class LoginCheck {
    
    // Returns true if input email string is a valid format,
    //   otherwise returns false.
    public static boolean emailCheck(String email){
                             // entire address can be no more than 254 char long,
                             //   format x@x.x must be no less than 5 char
        if(email == null || email.length() > 254 || email.length() < 5) 
            return false;
        Pattern p =          // local-part: no more than 64 char
            Pattern.compile("\\A([A-Za-z0-9\\.!#\\$%&'\\*\\+\\-/=" 
                          + "\\?\\^_`\\{\\|\\}~]{1,64})@" 
                             // domain: each dot-separated DNS label 
                             //   no more than 63 char
                          + "([A-Za-z0-9-]{1,63}\\.){1,}[A-Za-z0-9-]{1,63}\\z");
        Matcher m = p.matcher(email);
        boolean result1 = m.find();
        if(result1 == false)  // illegal character or format found
            return result1;
                            // separate pattern to check for illegal
        Pattern q =         //    hyphen and dot placement
            Pattern.compile("@((\\.)|-|"
                    + "([A-Za-z0-9-]{1,}-\\.[A-Za-z0-9-]{1,}))"
                    + "|(\\.\\z)|(\\A\\.)|(\\.\\.)|(\\.-)|(-\\z)");
        Matcher n = q.matcher(email);  
        boolean result2 = n.find();
        if(result2 == true)  // illegal hyphen or dot placement found
            return false; 
        return result1;
    }
    
    // Returns true if input password string is a valid format,
    //    otherwise returns false.
    public static boolean passwordCheck(String pass){
        if(pass == null || pass.length() < 8) // at least 8 char
            return false;
        Pattern p = Pattern.compile("[0-9]"); // at least 1 numeral
        Matcher m = p.matcher(pass);
        boolean result1 = m.find();
        
        Pattern q = Pattern.compile("[A-Z]"); // at least 1 capital letter
        Matcher n = q.matcher(pass);
        boolean result2 = n.find();
        
        Pattern r = Pattern.compile("[!@#\\$%\\^]"); // at least 1 special
        Matcher o = r.matcher(pass);
        boolean result3 = o.find();
        
        if(!result1 || !result2 || !result3)
            return false;
        else
            return true;
    }
}
