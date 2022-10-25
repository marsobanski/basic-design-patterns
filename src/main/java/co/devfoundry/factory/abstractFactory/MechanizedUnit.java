package co.devfoundry.factory.abstractFactory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class MechanizedUnit {

    private int hp;
    private int exp;
    private int damage;
}
