package co.devfoundry.factory.factoryMethod;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Unit {

    private int hp;
    private int exp;
    private int damage;
}
