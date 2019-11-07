import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TwentyOneTest {
    @Test
    public void TestConvertDecision(){
        assertEquals(1,TwentyOne.convertDecision('+'));
        assertEquals(2,TwentyOne.convertDecision('-'));
        assertEquals(3,TwentyOne.convertDecision('='));
        assertEquals(3,TwentyOne.convertDecision(' '));
    }
    @Test
    public void TestGetCardIndex(){
        int index = TwentyOne.getCardIndex(30);
        assertTrue(index < 36 && index >= 0);
        index = TwentyOne.getCardIndex(2);
        assertTrue(index < 2 && index >= 0);
    }
    @Test()
    public void TestGetDeck(){
        ArrayList<TwentyOne.Card> Deck = TwentyOne.getDeck();
        if(Deck.size() != TwentyOne.CARDS_NUMBER){
            fail("DECK HAS NOT THE SIZE THAT IT MUST HAVE");
        }
    }
    @Ignore
    public void TestGetCard(){
    }
    @Ignore
    public void TestGetComputerAccount(){

    }
}
