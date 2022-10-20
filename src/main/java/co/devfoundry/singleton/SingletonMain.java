package co.devfoundry.singleton;

public class SingletonMain {

    public static void main(String[] args) {

        GameEngine gameEngine1 = GameEngine.getInstance();
        GameEngine gameEngine2 = GameEngine.getInstance();

        //true, bo to ta sama instancja
        System.out.println(gameEngine1 == gameEngine2);
    }
}
