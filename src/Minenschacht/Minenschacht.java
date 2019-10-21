package Minenschacht;

import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class Minenschacht extends BouncerApp {

    public static void main(String[] args) {
        BouncerLauncher.launch("Minenschacht");
    }

    /**
     * Aufgabe: Lassen Sie Bouncer alle roten "Kisten" aus den Minenschächten holen. Es kann beliebig viele, beliebig lange
     * Schächte geben. Zwischen den Schächte liegt mindestens ein Feld. In jedem Schacht ist genau eine Kiste, die stets am
     * Ende des Schacht liegt. Der letzte Schacht ist min. 1 Feld vom rechten Kartenrand entfernt.
     */


    @Override
    public void bounce() {
        loadMap("Minenschacht");
    }
}
