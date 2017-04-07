package login;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author      Gareth Bosch
 * @assignment  Test Cases
 * @course      Software Engineering
 * @date        11/16/2016
 */

public class LoginCheckTest {
    
    /**
     * Test of emailCheck method, of class LoginCheck.
     */
    @Test
    public void testEmailCheck() {
        System.out.println("* LoginCheckTest: testEmailCheck()");
        assertTrue(LoginCheck.emailCheck("1@1.1"));
        assertTrue(LoginCheck.emailCheck("dsf8349873#$*%&^!jhdfJD-HK-F@anchorage.alaska.com"));
        assertTrue(LoginCheck.emailCheck("&'.^5A@A.F.E.W-SDF.1.2.3.43-65.COMPANY"));
        assertTrue(LoginCheck.emailCheck("!#$&%@a.x"));
        assertTrue(LoginCheck.emailCheck("'.|-@AjNyCrOJ.847-jfhFDhdD.8"));
        
        String s = null;
        assertFalse(LoginCheck.emailCheck(s));
        assertFalse(LoginCheck.emailCheck(""));
        assertFalse(LoginCheck.emailCheck("g.co"));
        assertFalse(LoginCheck.emailCheck("emailcheckercantelliftherearemoretha"
                + "n64charactersinthelocal-part!@OverLoad.net"));  // >64 char
        assertFalse(LoginCheck.emailCheck("khfda893^$&@-alaska.edu"));
        assertFalse(LoginCheck.emailCheck("dknclisu@gci.-oru.biz"));
        assertFalse(LoginCheck.emailCheck(".hello@my.world"));
        assertFalse(LoginCheck.emailCheck("web@.f.s"));
        assertFalse(LoginCheck.emailCheck("inter..net@laser.s"));
        assertFalse(LoginCheck.emailCheck("webster@books..f.s"));
        assertFalse(LoginCheck.emailCheck("normal@net-org."));
        assertFalse(LoginCheck.emailCheck("alpha@com.x-"));
        assertFalse(LoginCheck.emailCheck("tel os@zone.is"));
    }

    /**
     * Test of passwordCheck method, of class LoginCheck.
     */
    @Test
    public void testPasswordCheck() {
        System.out.println("* LoginCheckTest: testPasswordCheck()");
        assertTrue(LoginCheck.passwordCheck("Eijfdk#6"));       // !@#\\$%\\^
        assertTrue(LoginCheck.passwordCheck("#45$%d4f54$#@AADjs!$%^d4D"));
        assertTrue(LoginCheck.passwordCheck("JJJ%%%222"));
        assertTrue(LoginCheck.passwordCheck("P4$$WORD"));
        assertTrue(LoginCheck.passwordCheck("FFFFFFFFFFFFFFFFFFFf!1"));
        assertTrue(LoginCheck.passwordCheck("###################eE1"));
        
        String s = null;
        assertFalse(LoginCheck.passwordCheck(s));
        assertFalse(LoginCheck.passwordCheck(""));
        assertFalse(LoginCheck.passwordCheck("Ax9!"));
        assertFalse(LoginCheck.passwordCheck("fa^!#ilu764re"));
        assertFalse(LoginCheck.passwordCheck("Gareth45"));
        assertFalse(LoginCheck.passwordCheck("&Gareth980"));
    }
    
}
