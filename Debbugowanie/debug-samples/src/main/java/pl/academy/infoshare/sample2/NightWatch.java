package pl.academy.infoshare.sample2;

import java.util.HashSet;
import java.util.Set;

import pl.academy.infoshare.sample2.character.BadCharacter;
import pl.academy.infoshare.sample2.character.Character;
import pl.academy.infoshare.sample2.weapon.Weapon;

class NightWatch {

    private final Set<Character> members;

    NightWatch() {
        members = new HashSet<>();
        final Character sirAlliser = new BadCharacter("Ser Alliser", 150);
        final Character othellYarwick = new BadCharacter("Othell Yarwick", 100);
        final Character olly = new BadCharacter("Olly", 50);

        sirAlliser.takeWeapon(new Weapon("Sword", 60));
        olly.takeWeapon(new Weapon("Dagger", 20));

        members.add(sirAlliser);
        members.add(othellYarwick);
        members.add(olly);
    }

    boolean attack(final Character character) {
        members.forEach(member -> {
            try {
                stab(member, character);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });
        return character.isDead();
    }

    private void stab(final Character attacker, final Character target) throws NoWeaponDuringAttack {
        if (attacker.hasWeapon()) {
            attacker.attack(target);
        } else {
            throw new NoWeaponDuringAttack(attacker.getName() + " does not have weapon. Can not fight!");
        }
    }

    @Override
    public String toString() {
        return "NightWatch{" + "members size =" + members.size() + '}';
    }

    private class NoWeaponDuringAttack extends IllegalStateException {
        NoWeaponDuringAttack(final String msg) {
            super(msg);
        }
    }
}
