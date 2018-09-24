package ui;

import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Akash
 */
public class GameWindow extends JFrame{
    private GameScreen game;
    
    public GameWindow() {
        super("Fight!");
        setSize(400,250);
        setLocation(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        game = new GameScreen();
        addKeyListener(game);
        add(game);
    }
    
    public void startGame() {
        game.startGame();
    }
    
    public static void main(String args[]) {
        GameWindow window = new GameWindow();
        window.setVisible(true);
        window.startGame();
    }
    
}
