package Sonnenaufgang;

import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;
import de.ur.mi.bouncer.world.fields.FieldColor;

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
        drawInclinedLineRight();
        drawInclinedLineLeft();
        drawStraightLine();
        drawStraightLine();
        bouncer.turnLeft();
        drawStraightLine();
        bouncer.paintField(FieldColor.RED);
    }

    /**
     * Bouncer zeichnet, beginnend auf dem Feld vor ihm, eine vier Felder lange rote Linie und kehrt zur Ausgangssituation
     * zurück.
     * <p>
     * Pre-Condition: Bouncer steht auf einem beliebigen Feld der Karte und kann sich mindestens vier Felder weit in die
     * aktuelle Blickrichtung bewegen.
     * Post-Condition: Bouncer hat die vier Felder vor seiner Ausgangsposition rot eingfärbt, steht wieder auf der Startposition
     * und blickt in die entgegengesetzte Richtung seiner ursprünglichen Blickrichtung.
     */
    public void drawStraightLine() {
        for (int i = 0; i < 4; i++) {
            bouncer.move();
            bouncer.paintField(FieldColor.RED);
        }
        turnAround();
        while (bouncer.isOnFieldWithColor(FieldColor.RED)) {
            bouncer.move();
        }
    }

    /**
     * Bouncer zeichnet eine schräge, drei Felder lange nach oben verlaufende Linie rechts von seiner aktuellen Position.
     */
    public void drawInclinedLineRight() {
        for (int i = 0; i < 3; i++) {
            bouncer.move();
            bouncer.turnLeft();
            bouncer.move();
            bouncer.paintField(FieldColor.RED);
            turnRight();
        }
        turnAround();
        for (int i = 0; i < 3; i++) {
            bouncer.move();
            bouncer.turnLeft();
            bouncer.move();
            turnRight();
        }
    }

    /**
     * Bouncer zeichnet eine schräge, drei Felder lange nach oben verlaufende Linie links von seiner aktuellen Position.
     */
    public void drawInclinedLineLeft() {
        for (int i = 0; i < 3; i++) {
            bouncer.move();
            turnRight();
            bouncer.move();
            bouncer.paintField(FieldColor.RED);
            bouncer.turnLeft();
        }
        turnAround();
        for (int i = 0; i < 3; i++) {
            bouncer.move();
            turnRight();
            bouncer.move();
            bouncer.turnLeft();
        }
    }

    /**
     * Bouncer dreht sich auf seiner aktuellen Position um 180°
     * <p>
     * Pre-Condition: Bouncer steht auf einem beliebiegen Feld der Karte und blickt in eine beliebige Richtung.
     * Post-Condition: Bouncer steht auf dem ursprüngichen Feld und blickt in die entgegengesetzte Richtung.
     */
    public void turnAround() {
        bouncer.turnLeft();
        bouncer.turnLeft();
    }

    /**
     * Bouncer dreht sich um 90 Grad nach rechts
     * <p>
     * Pre-Condition: -
     * Post-Condition: Bouncers Blickrichtung hat sich um 90 Grad nach Rechts verschoben
     */
    private void turnRight() {
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.turnLeft();
    }
}
