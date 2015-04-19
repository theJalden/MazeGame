import tester.*;

class ExamplesMazeGame {
    MazeGame myGame = new MazeGame();
    
    
    
    
    void testGame(Tester t) {
        myGame.bigBang(MazeGame.W_WIDTH, MazeGame.W_HEIGHT + 100, .1);
    }
}