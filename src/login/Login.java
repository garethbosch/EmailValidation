package login;
import java.util.*;
import static login.LoginCheck.emailCheck;
import static login.LoginCheck.passwordCheck;
/**
 * @author      Gareth Bosch
 * @assignment  Test Cases
 * @course      Software Engineering
 * @date        11/16/2016
 */

public class Login{
    
    public static void main(String[] args){
        
        Scanner keys = new Scanner(System.in);
        
        System.out.println("Please enter your userID (email address)");
        String email = keys.nextLine();
        System.out.println("Please enter your password");
        String pass = keys.nextLine();

        if(emailCheck(email))
            System.out.println("Valid email");
        else if(!emailCheck(email))
            System.out.println("Invalid email");
        if(passwordCheck(pass))
            System.out.println("Valid password");
        else if(!passwordCheck(pass))
            System.out.println("Invalid password");
    }
}
