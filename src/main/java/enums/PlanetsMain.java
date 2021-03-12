package enums;

import enums.Planets;

public class PlanetsMain {
    public static void main(String[] args) {
        for (Planets planet : Planets.values()) {
            System.out.println("Your mass on planet " + planet + " is: " + planet.calculateMass(150));
        }
     }
}
