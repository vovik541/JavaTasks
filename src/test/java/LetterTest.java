import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LetterTest {
    @Test
    public void TestCheckMessageStatus(){
        assertEquals(0,Letter.checkMessageStatus(70, 10000));
        assertEquals(2,Letter.checkMessageStatus(Letter.ASCII_MAX, Letter.ASCII_MIN));
        assertEquals(3,Letter.checkMessageStatus(Letter.ASCII_MIN, Letter.ASCII_MAX));
        assertEquals(4,Letter.checkMessageStatus(Letter.ASCII_MAX, Letter.ASCII_MAX));
        System.out.println("@TEST CheckMessageStatus");
    }

    @Test
    public void TestGenerateLetter(){
        int generatedLetter = Letter.generateLetter();
        assertTrue(Letter.ASCII_MIN <= generatedLetter && generatedLetter <= Letter.ASCII_MAX);
    }

    /*@AfterClass
    public static void afterClTest(){
        System.out.println("@AfterClass");
    }
    @Before //just tested how it works
    public void checkVariables(){
        assertTrue(Letter.ASCII_MIN != (int) ' ');
        System.out.println("@Before");

    }*/

}
