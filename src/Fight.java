import java.util.Scanner;

public class Fight {

    public static final int healSpellMana = 35;
    public static final int fireballMana = 43;
    public static final int icespikeMana = 51;
    public static final int lightningboltMana = 60;

    public static final int pigHeal = 30;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("What's your name? ");
        String playerName = sc.nextLine();

        System.out.println("Press Enter To Continue Through The Dialogue:\n");

        //STORY START sc.nextLine(); is used to pause the text
        System.out.print("You are travelling along the road on your quest to become the world's best Magic the Gathering Player");
        sc.nextLine();
        System.out.print("Uh-Oh, something is blocking your way. ");
        sc.nextLine();
        System.out.print("Its a pig!");
        sc.nextLine();
        System.out.print("You are starving, you could use the meat, but are you willing to fight this poor and defenseless pig?\n");
        System.out.println("[1] Yes \n[2] No");

        int fightOrNot = sc.nextInt();

        if (fightOrNot == 2) {
            System.out.println("You decide not to fight the pig and continue on your quest to become the world's best Magic the Gathering Player");
            sc.nextLine();
            System.out.println("THE END!");
            System.exit(0);
        }
        if (fightOrNot == 1) {
            System.out.print("You decide to fight the pig");

            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);

            System.out.println("\n");

        }
        //STORY ENDS

        //Creates new Character objects with the new Name and the comp
        Character player = new Character(playerName);
        Character computer = new Character();



        //Checks whether the player and the computer are dead
        while (!player.isDead() && !computer.isDead()) {

            System.out.println();

            //Prints player's options they have and their stats
            player.printStats();
            computer.printStats();
            printOptions();

            //Asks player for choice
            System.out.print("What is your move? ");

            //Input for the move 1-5
            int playerChoice = sc.nextInt();


            //Player outcomes of their choice

            //MELEE ---------------------------------------------------------------------------------------------------
            if (playerChoice == 1) {

                printMeleeOptions();
                playerChoice = sc.nextInt();

                //Pet
                if (playerChoice == 1) {
                    System.out.print("\nYou pet the pig...\n");

                    if (computer.getHealth() + pigHeal <= computer.getHealth()) {
                        System.out.println("The pig was healed by " + pigHeal + " points!");
                    }
                    else {
                        System.out.print("Nothing really happens...");
                        sc.nextLine();
                        sc.nextLine();
                    }
                }

                //Punch it
                else if (playerChoice == 2) {
                    System.out.print("\nYou punch the " + computer.getName() + " and do 20 damage");
                    player.punch(computer);
                    sc.nextLine();
                    sc.nextLine();
                    System.out.print("You feel terrible on the inside...");
                    sc.nextLine();
                }

                //Sword
                else if (playerChoice == 3) {
                    System.out.println("\nYou swing your Nerf sword at the pig, and do a bit of damage");
                    player.attack(computer);
                }
            }
            //MELEE ---------------------------------------------------------------------------------------------------

            //SPELLS --------------------------------------------------------------------------------------------------
            else if (playerChoice == 2 && (player.getMana() >= fireballMana || player.getMana() >= icespikeMana || player.getMana() >= lightningboltMana)) {
                printSpellOptions();
                playerChoice = sc.nextInt();

                //While loop to check if they have the mana to cast the spell - GOD DAMN THAT IS TOO LONG
                while (player.getMana() <= fireballMana && playerChoice == 1
                        || player.getMana() <= icespikeMana && playerChoice == 2
                        || player.getMana() <= fireballMana && playerChoice == 3
                        || player.getMana() <= healSpellMana && playerChoice == 4) {

                    System.out.println("You are out of mana! Choose a different option");
                    playerChoice = sc.nextInt();
                }

                //Fireball
                if (playerChoice == 1 && player.getMana() >= fireballMana) {
                    player.fireball(computer);
                }
                //Icespike
                else if (playerChoice == 2 && player.getMana() >= icespikeMana) {
                    player.icespike(computer);
                }
                //Lightning Bolt
                else if (playerChoice == 3 && player.getMana() >= lightningboltMana) {
                    player.lightningbolt(computer);
                }
                //heal Spell
                if (playerChoice == 4 && player.getMana() >= healSpellMana && player.getHealth() - 35 < player.getHealth()) {
                    player.healSpell();
                }
            }
            else if (playerChoice == 3) {
                System.out.print("\nYou runaway from the " + computer.getName() + " screaming");
                sc.nextLine();
                sc.nextLine();
                System.exit(0);

            } else {
                System.out.println("You Can't Do That!");
            }
            //SPELLS --------------------------------------------------------------------------------------------------

            //Checks if the player or the computer lost and prints the winner
            if (player.getHealth() <= 0) {
                System.out.println("You Lost! HAHA!!!");
                System.exit(0);
            }
            else if (computer.getHealth() <= 0) {
                System.out.println("The " + computer.getName() + " has been defeated!");
                System.exit(0);
            }

            //PIGS TURN
            int pigChoice = (int) ( 1 + Math.random() * 3);
            System.out.println("PIG CHOICE :" + pigChoice);

            if (pigChoice == 1) {
                System.out.println("\nThe " + computer.getName() + " attacked you!");
                computer.attack(player);
            }
            else if (pigChoice == 2) {
                System.out.println("\nThe" + computer.getName() + " tackled you!");
                computer.punch(player);

            } else if (pigChoice == 3) {
                System.out.println("The " + computer.getName() + " threw some mud at you!");
                player.takeDamage(10);
            }

            System.out.println();

            //Checks if the player or the computer lost and prints the winner
            if (player.getHealth() <= 0) {
                System.out.println("You Lost! HAHA!!!");
                System.exit(0);
            }
            else if (computer.getHealth() <= 0) {
                System.out.println("The " + computer.getName() + " has been defeated!");
                System.exit(0);
            }




            //Clears the console
            System.out.println("\f");

        }
    }

    public static void printOptions() {
        System.out.println();
        System.out.println("[1] Melee Attack\n[2] Spells \n[3] Run");
        System.out.println();
    }

    public static void printSpellOptions() {
        System.out.println("SPELLS: ");
        System.out.println("[1] Fireball - " + fireballMana + " Mana\n[2] Icespike - " + icespikeMana + " Mana\n[3] Lightningbolt - " + lightningboltMana + " Mana\n[4] Heal Spell - " + healSpellMana + " Mana");
        System.out.println();
    }

    public static void printMeleeOptions() {
        System.out.println("MELEE ATTACKS: ");
        System.out.println("[1] Pet it \n[2] Punch It \n[3] Attack With Sword");
        System.out.println();

    }

}

