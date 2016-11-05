import java.util.Scanner;

public class Fight {

    public static final int healSpellMana = 35;
    public static final int fireballMana = 43;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Asks player for their name
        System.out.println("What's your name? ");
        String playerName = sc.nextLine();

        //Creates new Character objects with the new Name and the comp
        Character player = new Character(playerName);
        Character computer = new Character();

        //Checks whether the player and the computer are dead
        while (!player.isDead() && !computer.isDead()) {

            //Prints player's options they have and their stats
            player.printStats();
            printOptions();

            System.out.println("What is your next move? ");

            //Input for the move 1-5
            int playerChoice = sc.nextInt();

            //Player outcomes of their choice
            if (playerChoice == 1) {

                //Attack
                player.attack(computer);
            }
            else if (playerChoice == 2) {
                //Fireball
                if (player.getMana() >= fireballMana) {
                    player.fireball(computer);
                }
            }
            else if (playerChoice == 3) {

                //HealSpell
                if (player.getMana() >= healSpellMana) {
                    player.healSpell();
                }

            }


            //Checks if the player or the computer lost and prints the winner
            if (player.getHealth() <= 0) {
                System.out.println("You Lost!");
            }
            else if (computer.getHealth() <= 0) {
                System.out.println("You Won!");
            }

            //Clears the console
            System.out.println("\033[H\033[2J");

        }




    }

    public static void printOptions() {
        System.out.println();
        System.out.println("[1] Attack \n[2] Fireball \n[3] Cast a Heal Spell");
        System.out.println();
    }
}

