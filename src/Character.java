
public class Character {

    //Required Stuff
    private String name;

    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private int minDamage;
    private int maxDamage;

    //Other final values
    public final int fireballMana = 43;
    public final int fireballDamage = 30;

    public final int icespikeMana = 51;
    public final int icespikeDamage = 35;

    public final int lightningboltMana = 60;
    public final int lightningboltDamage = 45;

    //Extra Credit
    private int stamina;


    public Character(String newName) {

        name = newName;
        health = 100;
        mana = 100;
        maxHealth = 100;
        maxMana = 100;

        minDamage = 12;
        maxDamage = 16;

        //Extra Credit Stuff
        stamina = 100;
    }

    public Character() {
        name = "CPU";

        health = 120;
        maxHealth = 120;
        maxMana = 0;
        mana = 20;
        minDamage = 15;
        maxDamage = 20;

        //Extra Credit Stuff
        stamina = 100;
    }



    public boolean isDead() {
        if (health <= 0) {
            health = 0;
            return true;
        }
        return false;
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

    public int getStamina() {
        return stamina;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
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

        //System.out.println("Random Int : " + random);

        enemy.takeDamage(random);
    }

    public void fireball(Character enemy) {
        if (mana >= fireballMana) {
            mana = mana - fireballMana;
            enemy.takeDamage(fireballDamage);

            System.out.println("You shoot a fireball and do " + fireballDamage + " damage!");

        }
        else {
            System.out.println("You are out of mana!");
        }
    }

    public void icespike(Character enemy) {
        if (mana >= icespikeMana) {
            mana = mana - icespikeMana;
            enemy.takeDamage(icespikeDamage);

            System.out.println("You shoot an icespike and do " + icespikeDamage + " damage!");

        }
        else {
            System.out.println("You are out of mana!");
        }
    }

    public void lightningbolt(Character enemy) {
        if (mana >= lightningboltMana) {
            //Subtracts Mana points and gives enemy damage
            mana = mana - lightningboltMana;
            enemy.takeDamage(lightningboltDamage);

            System.out.println("You shoot an lightningbolt and do " + lightningboltDamage + " damage!");
        }
        else {
            System.out.println("You are out of mana!");
        }
    }

    public void punch(Character enemy) {
        enemy.takeDamage(30);
    }







    public void healSpell() {
        if (mana >= 18 && health+35 < health) {
            heal(35);

            System.out.println("You got healed by " + 35 + " points");
        }
    }


    public void printStats() {
        String statsSpacer = (getName() + " Stats ----------------------------------------------");

        System.out.println(statsSpacer);
        //For every 5 health print out a block
        System.out.print(health + " Health:  ");
        for(int i = 0; i < health/5; i++) {
            System.out.print("▉");
        }

        System.out.println();

        //For every 5 mana print out a block
        System.out.print(mana + " Mana:    ");

        for(int i = 0; i < mana/5; i++) {
            System.out.print("▉");
        }
        System.out.println();

        //For every 5 stamina print out a block
        System.out.print(stamina + " Stamina: ");

        for(int i = 0; i < stamina/5; i++) {
            System.out.print("▉");
        }
        System.out.println();


        //Prints - depending on how long the statsSpacer is
        for(int i = 0; i < statsSpacer.length(); i++) {
            System.out.print("-");
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
