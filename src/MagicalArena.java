import java.util.Random;

class Player {
    private int health;
    private int strength;
    private int attack;
    private Random random;

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.random = new Random();
    }

    public int rollDie() {
        return random.nextInt(6) + 1; // returns a random number between 1 and 6
    }

    public int calculateDamage() {
        return attack * rollDie();
    }

    public int calculateDefense() {
        return strength * rollDie();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

public class MagicalArena {
    public static void playGame(Player player1, Player player2) {
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            // Player with lower health attacks first
            Player attacker = player1.getHealth() < player2.getHealth() ? player1 : player2;
            Player defender = attacker == player1 ? player2 : player1;

            // Attacker attacks
            int damageInflicted = attacker.calculateDamage();
            int defense = defender.calculateDefense();
            int damageTaken = Math.max(0, damageInflicted - defense);
            defender.setHealth(defender.getHealth() - damageTaken);
            System.out.println(attacker == player1 ? "Player 1" : "Player 2" +
                    " attacks and inflicts " + damageInflicted + " damage. " +
                    "Defender defends with a strength of " + defense +
                    " and takes " + damageTaken + " damage.");

            // Check if game ends
            if (defender.getHealth() <= 0) {
                System.out.println((attacker == player1 ? "Player 1" : "Player 2") + " wins!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);

        playGame(player1, player2);
    }
}

