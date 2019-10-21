package HelloAgainBouncer;

import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class HelloAgainBouncer extends BouncerApp {

    public static void main(String[] args) {
        BouncerLauncher.launch("HelloAgainBouncer");
    }

    /**
     * Aufgabe: Lassen Sie Bouncer bis auf das rote Feld laufen!
     */

    @Override
    public void bounce() {
        loadMap("HelloAgainBouncer");
    }
}
