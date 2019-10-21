package HelloAgainBouncer;

import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;
import de.ur.mi.bouncer.world.fields.FieldColor;

public class HelloAgainBouncer extends BouncerApp {

    public static void main(String[] args) {
        BouncerLauncher.launch("HelloAgainBouncer");
    }

    /**
     * Aufgabe: Lassen Sie Bouncer bis auf das erste rote Feld laufen!
     */

    @Override
    public void bounce() {
        loadMap("HelloAgainBouncer");
        moveForward();
    }

    /**
     * Bouncer bewegt sich solange vorwärts in die aktuelle Blickrichtung, bis er auf ein "rotes" Feld stößt.
     *
     * Pre-Condition: Bouncer steht auf einem beliebigen Feld der Karte.
     * Post-Condition: Bouncer steht auf dem ersten auffindbaren roten Feld oder vor dem ersten blockierten Feld.
     */
    public void moveForward() {
        while(bouncer.canMoveForward()) {
            bouncer.move();
            if(bouncer.isOnFieldWithColor(FieldColor.RED)) {
                /**
                 * Mit dem break-Befehl kann eine Schleife an beliebiger Stelle - unabhängig von etwaigen
                 * Schleifenbedingungen - abgebrochen werden.
                 */
                break;
            }
        }
    }
}
