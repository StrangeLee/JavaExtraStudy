package swing_project_1;

public enum Player {
    X("X"), Y("Y");

    private String player;

    Player(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

}
