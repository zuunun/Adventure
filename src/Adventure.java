public class Adventure {
    private Map gameMap;
    private Player gamePlayer;

    public Adventure() {
        gameMap = new Map();
        gamePlayer = new Player(gameMap.getRoom1());
    }

    public Map getGameMap() {
        return gameMap;
    }

    public Player getGamePlayer() {
        return gamePlayer;
    }
//    public boolean take(String itemWord){
//        return player.take(itemWord);
//
//    }
//
//    public boolean drop(String itemWord){
//        return player.drop(itemWord);
//
//    }
//
//    public String showInventory(){
//        return player.showInvetory();
//    }
//
//    public boolean moveAround(){
//        return gamePlayer.moveAround();
//    }

}

