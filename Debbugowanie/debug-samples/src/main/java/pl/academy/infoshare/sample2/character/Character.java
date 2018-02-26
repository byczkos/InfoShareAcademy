package pl.academy.infoshare.sample2.character;

import java.util.Optional;

import pl.academy.infoshare.sample2.weapon.Weapon;

public abstract class Character {

    private static final int NO_ENERGY = 0;

    private final String name;
    private int energy;

    private Optional<Weapon> weapon;

    Character(final String name, final int energy) {
        this.name = name;
        this.energy = energy;

        weapon = Optional.empty();
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public boolean isDead() {
        return energy <= NO_ENERGY;
    }

    public void takeWeapon(final Weapon weapon) {
        this.weapon = Optional.ofNullable(weapon);
    }

    public boolean hasWeapon() {
        return weapon.isPresent();
    }

    public void attack(final Character target) {
        System.out.println(this.getName() + " attacks " + target.getName() + " with " + this.getWeapon().getName());
        target.hurt(getWeapon().getAttackPower());
    }

    private Weapon getWeapon() {
        return weapon.isPresent() ? weapon.get() : Weapon.NOT_DEFINED;
    }

    private void hurt(final int damage) {
        energy -= damage;
    }

    @Override
    public String toString() {
        return "Character{" +
            "name='" + name + '\'' +
            ", energy=" + energy +
            '}';
    }
}
