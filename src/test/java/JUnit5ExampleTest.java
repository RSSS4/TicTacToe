import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.CheckWinner;

class JUnit5ExampleTest {

    @Test
    void TestcheckOutOfField() {
        CheckWinner checkWinner = new CheckWinner(5,5);
        assertEquals(true, checkWinner.checkOutOfField(4,4));
        assertEquals(false, checkWinner.checkOutOfField(5,4));
    }

}

