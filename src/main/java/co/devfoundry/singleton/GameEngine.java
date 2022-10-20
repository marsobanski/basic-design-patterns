package co.devfoundry.singleton;

import java.io.Serializable;

public class GameEngine
// serializacja - jeśli singleton musi być serializowany
        implements Serializable
{

    // uuid do serializacji
    private static final long serialVersionUUID = 22222123;

    private int playerHp = 100;
    private String playerName = "Marian";

    // wielowątkowość - tworzymy instancję przy polu, wtedy instancja jest tworzona przy ładowaniu klasu do class loadera,
        //  wtedy blok synchorniczny ani sprawdzanie (instance == null?) niepotrzebne
    private static GameEngine instance = new GameEngine();

    private GameEngine() {

    }

    public static GameEngine getInstance() {
        if (instance == null) {

            // wielowątkowość - blok synchorniczny z drugim sprawdzeniem, w nim tworzenie instancji
            synchronized (GameEngine.class) {
                if (instance == null) {
                    instance = new GameEngine();
                }
            }
            // koniec bloku synchronicznego
        }
        return instance;
    }

    // serializacja - wywoła się za każdym razem, kiedy obiekt klasy będzie odserializowany
    protected Object readResolve() {
        return getInstance();
    }

    public void run() {
        // waiting for player input
        // changing game state
        // rendering graphic objects
    }
}
