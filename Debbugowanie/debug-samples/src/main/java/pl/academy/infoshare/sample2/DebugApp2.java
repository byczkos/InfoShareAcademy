package pl.academy.infoshare.sample2;

import pl.academy.infoshare.sample2.character.Character;
import pl.academy.infoshare.sample2.character.GoodCharacter;

public class DebugApp2 {

    public static void main(final String[] args) {

        final Character johnSnow = new GoodCharacter("Jon Snow", 50);
        final NightWatch nightWatch = new NightWatch();

        boolean isKilled = nightWatch.attack(johnSnow);
        System.out.println(johnSnow.getName() + " is " + (isKilled ? "dead" : "safe"));

    }
}
