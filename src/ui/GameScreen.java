package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import player.Player;

/**
 *
 * @author Akash
 */
public class GameScreen extends JPanel implements Runnable, KeyListener{
    private Thread t;
    private Player p1, p2;
    
    public GameScreen() {
        p1 = new Player(130,110, true);
        p2 = new Player(270, 110, false);
    }
    public void startGame() {
        t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        while(true) {
            repaint();       
            try {
                Thread.sleep(70);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
	g.fillRect(0, 0, 400, 250);
        g.setColor(Color.BLACK);
        p1.draw(g);
        p2.draw(g);
        g.drawLine(0, 200, 400, 200);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {     }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(Character.toLowerCase(e.getKeyChar())) {
            case'w':
                p1.jump();
                break;
            case 'a':
                p1.left();
                break;
            case 'd':
                p1.right();
                break;
            case 's': 
                p1.crouch();
                break;
            case 'e':
                p1.punch();
                break;
            case 'f':
                p1.kick();
                break;    
            default:
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        p2.jump();
                        break;
                    case KeyEvent.VK_LEFT:
                        p2.right();
                        break;
                    case KeyEvent.VK_RIGHT:
                        p2.left();
                        break;
                    case KeyEvent.VK_DOWN:
                        p2.crouch();
                        break;   
                    case KeyEvent.VK_CONTROL:
                        p2.kick();
                        break;
                    case KeyEvent.VK_SHIFT:
                        p2.punch();
                        break;        
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(Character.toLowerCase(e.getKeyChar())) {
            case's':
                p1.stand();
                break;
            case 'e':
                p1.reversePunch();
                break;
            case 'f':
                p1.reverseKick();
                break;    
            default:
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        p2.stand();
                        break;   
                    case KeyEvent.VK_CONTROL:
                        p2.reverseKick();
                        break;
                    case KeyEvent.VK_SHIFT:
                        p2.reversePunch();
                        break;        
                }
        }
    }
        
}