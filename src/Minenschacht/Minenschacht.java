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
        /**
         * Als Abbruchbedinung für den übergeordneten Algorithmus wird das Erreichen eines Hindernis bzw. einer Wand
         * definiert.
         */
        while (bouncer.canMoveForward()) {
            searchMineShafts();
        }
    }

    /**
     * Bouncer sucht nach einem Minenschacht direkt über seiner aktuellen Position.
     *
     * Pre-Condition: Bouncer steht an einer beliebigen Stelle im Minenschacht und blickt nach WESTEN.
     * Post-Condition: Bouncer steht auf dem ersten Feld hinter seiner Startposition, schaut nach WESTEN und hat,
     * falls er einen Schacht gefunden hat, die Kiste aus diesem entfernt.
     */
    public void searchMineShafts() {
        if (bouncer.canMoveLeft()) {
            clearMineShaft();
        }
        bouncer.move();

    }

    /**
     * Bouncer läuft bis zum Ende des Schachts vor ihm, entfernt die Kiste und kehrt zur Ausgangsposition zurück.
     *
     * Pre-Condition: Bouncer steht am Eingang eines Schachts und blickt nach WESTEN.
     * Post-Condition: Bouncer steht auf der Ausgangsposition, blickt nach WESTEN und hat die Kiste aus dem Schacht über
     * ihm entfernt.
     */
    public void clearMineShaft() {
        bouncer.turnLeft();
        moveToNextObstacle();
        bouncer.clearFieldColor();
        turnAround();
        moveToNextObstacle();
        bouncer.turnLeft();
    }

    /**
     * Bouncer bewegt sich solange vorwärts in die aktuelle Blickrichtung, bis er auf ein Hindernis stößt.
     *
     * Pre-Condition: Bouncer steht auf einem beliebigen Feld der Karte.
     * Post-Condition: Bouncer steht vor dem ersten blockierten Feld.
     */
    public void moveToNextObstacle() {
        while(bouncer.canMoveForward()) {
            bouncer.move();
        }
    }

    /**
     * Bouncer dreht sich auf seiner aktuellen Position um 180°
     *
     * Pre-Condition: Bouncer steht auf einem beliebiegen Feld der Karte und blickt in eine beliebige Richtung.
     * Post-Condition: Bouncer steht auf dem ursprüngichen Feld und blickt in die entgegengesetzte Richtung.
     */
    public void turnAround() {
        bouncer.turnLeft();
        bouncer.turnLeft();
    }
}
