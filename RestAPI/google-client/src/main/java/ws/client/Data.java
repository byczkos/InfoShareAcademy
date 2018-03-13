package ws.client;

import java.util.ArrayList;
import java.util.List;

public class Data {
    List<Translation> translations;

    // Aby parsowac jsona nalezy stworzyc klasy odpowiadajace obiektom z formatu json. Wazne jest by stworzyc obiekt nadrzedny
    // ktorego nie ma w pliku json. Nawiasy [] oznaczaja rozpoczacie sie listy i pamietac nalezy, by w obiektach odwzorowac to
    // rowniez w postaci listy w Javie.

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }
}
