package Sonnenaufgang;

import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class Sonnenaufgang extends BouncerApp {

    public static void main(String[] args) {
        BouncerLauncher.launch("Sonnenaufgang");
    }

    /**
     * Aufgabe: Zeichnen Sie, ausgehend von Bouncers Startposition einen Sonneaufgang. Nutzen Sie dazu die Möglichkeit, Felder r
     * farbig zu markieren.
     */


    @Override
    public void bounce() {
        loadMap("Sonnenaufgang");
    }
}
