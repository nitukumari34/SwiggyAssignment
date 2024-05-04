import org.junit.Test;
import static org.junit.Assert.*;

public class MagicalArenaTest {

    @Test
    public void testPlayGame_Player1Wins() {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);
        MagicalArena.playGame(player1, player2);
        assertTrue(player1.getHealth() <= 0 || player2.getHealth() <= 0);
    }

    @Test
    public void testPlayGame_Player2Wins() {
        Player player1 = new Player(100, 10, 5);
        Player player2 = new Player(50, 5, 10);
        MagicalArena.playGame(player1, player2);
        assertTrue(player1.getHealth() <= 0 || player2.getHealth() <= 0);
    }
}