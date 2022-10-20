package co.devfoundry.singleton;

public enum GameEngineEnum {

    INSTANCE("Marian");

    private int hp;
    private String characterName;

    GameEngineEnum(String characterName) {
        this.characterName = characterName;
    }

    public void run() {
        // waiting for player input
        // changing game state
        // rendering graphic objects
    }
}
