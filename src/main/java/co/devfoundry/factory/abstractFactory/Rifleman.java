package co.devfoundry.factory.abstractFactory;

import lombok.Data;

public class Rifleman extends InfantryUnit {

    Rifleman(int hp, int exp, int damage) {
        super(hp, exp, damage);
    }
}
