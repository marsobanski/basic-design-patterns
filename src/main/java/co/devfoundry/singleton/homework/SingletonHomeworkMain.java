package co.devfoundry.singleton.homework;

public class SingletonHomeworkMain {

    public static void main(String[] args) {
        GameEngine gameEngine = GameEngine.getInstance();
        gameEngine.play();
    }
}
