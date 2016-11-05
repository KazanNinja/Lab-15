import java.util.Scanner;

public class Character {

    private String name;

    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private int minDamage;
    private int maxDamage;


    public Character(String newName) {
        Scanner scan = new Scanner(System.in);

        name = newName;
        health = 100;
        mana = 100;
        maxHealth = 100;
        maxMana = 100;

        minDamage = 12;
        maxDamage = 16;
    }

    public Character() {
        name = "CPU";

        health = 120;
        maxHealth = 120;
        maxMana = 0;
        mana = 0;
        minDamage = 15;
        maxDamage = 20;

    }



    public boolean isDead() {
        return health <= 0;
    }

    public void heal() {
        health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public void heal(int n) {
        if (n > 0) {
            if (health + n > maxHealth) {
                health =+ n;
            }
        }
    }








    public void takeDamage(int n) {

        health = health - n;
    }

    public void attack(Character enemy) {

        //Is that the range idk
        int random = (int) (minDamage + Math.random() * maxDamage);
        System.out.println("Random Int : " + random);

        enemy.takeDamage(random);
    }

    public void fireball(Character enemy) {
        if (mana >= 43) {
            mana = mana - 43;
            enemy.takeDamage(30);

            System.out.println("You did 30 damage!");

        }
        else {
            System.out.println("You are out of mana!");
        }
    }









    public void healSpell() {
        if (mana >= 18 && health+35 < health) {
            heal(35);

            System.out.println("You got healed by " + 35 + " points");
        }
    }


    public void printStats() {
        //For every 5 health print out a block
        System.out.print(health + " Health: ");
        for(int i = 0; i < health/5; i++) {
            System.out.print("▉");
        }

        System.out.println();

        //For every 5 mana print out a block
        System.out.print(mana + " Mana:   ");

        for(int i = 0; i < mana/5; i++) {
            System.out.print("▉");
        }
        System.out.println();
    }


    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", mana=" + mana +
                ", maxMana=" + maxMana +
                ", minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                '}';
    }
}
