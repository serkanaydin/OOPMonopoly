import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    @Test
    void toss() {
        Die die = new Die();
        assertEquals(0,die.getFV());
        die.toss();
        assertFalse(die.getFV()<1 ||die.getFV()>6  );
        Die die2 = new Die();
        assertEquals(0,die2.getFV());
        die2.toss();
        assertFalse(die2.getFV()<1 ||die2.getFV()>6  );
    }
}