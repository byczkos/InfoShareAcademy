package pl.academy.infoshare.sample2.weapon;

public class Weapon {

    public static final Weapon NOT_DEFINED = new Weapon("No weapon", 0);

    private final String name;
    private final int attackPower;

    public Weapon(final String name, final int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String toString() {
        return "Weapon{" + "name='" + name + ", attackPower=" + attackPower + '}';
    }
}
