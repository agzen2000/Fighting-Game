package player;

import java.awt.Graphics;

/**
 *
 * @author Akash
 */
public class Player {
    private static final int GRAVITY = 3;
    private static final int STAND = 0;
    private static final int LEFT_1 = 1;
    private static final int LEFT_2 = 2;
    private static final int LEFT_3 = 12;
    private static final int RIGHT_1 = 3;
    private static final int RIGHT_2 = 4;
    private static final int RIGHT_3 = 11;
    private static final int JUMP = 5;
    private static final int PUNCH_1 = 6;
    private static final int PUNCH_2 = 7;
    private static final int PUNCH_3 = 15;
    private static final int KICK_1 = 8;
    private static final int KICK_2 = 9;
    private static final int KICK_3 = 16;
    private static final int CROUCH_1 = 10;
    private static final int CROUCH_2 = 13;
    private static final int CROUCH_3 = 14;
    private int headX, headY, armX, armY, rElboX, rElboY, lElboX, lElboY,lFistX, lFistY, rFistX, rFistY, legX, legY, rKneX, rKneY, lKneX, lKneY, rFootX, rFootY, lFootX, lFootY;
    private int speedY;
    private int state;
    private int orienNum;
    
    public Player(int headX, int headY, boolean lookinRight) {
        if(lookinRight) {
            orienNum = 1;
        } else {
            orienNum = -1;
        }
        this.headX = headX;
        this.headY = headY;
        armX = headX;
        armY = headY + 20;
        rElboX = armX + (5 * orienNum);
        rElboY = armY + 15;
        lElboX = armX - (5 * orienNum);
        lElboY = rElboY - 5;
        lFistX = lElboX + (15 * orienNum);
        lFistY = armY + 5;
        rFistX = rElboX + (15 * orienNum);
        rFistY = armY + 10;
        legX = headX;
        legY = lElboY + 20;
        rKneX = legX + (15 * orienNum);
        rKneY = legY + 10;
        lKneX = legX + (5 * orienNum);
        lKneY = legY + 15;
        rFootX = rKneX - (5 * orienNum);
        rFootY = rKneY + 30;
        lFootX = legX - (10 * orienNum);
        lFootY = rFootY;
        speedY = 0;
        state = STAND;
    }
    
    public void jump() {
        if(state==STAND) {
            speedY = -15;
            state = JUMP;
        }
    }
    
    public void left() {
        if(state==STAND) {
            state = LEFT_1;
        }
    }
    
    public void right() {
        if(state==STAND) {
            state = RIGHT_1;
        }
    }
    
    public void crouch() {
        if(state==STAND) {
            state=CROUCH_1;
        }
    }
    
    public void stand() {
        if(state==CROUCH_2) {
            state=CROUCH_3;
        }
    }
    
    public void punch() {
        if(state==STAND) {
            state=PUNCH_1;
        }
    }
    
    public void reversePunch() {
        if(state==PUNCH_2) {
            state=PUNCH_3;
        }
    }
    
    public void kick() {
        if(state==STAND) {
            state=KICK_1;
        }
    }
    
    public void reverseKick() {
        if(state==KICK_2) {
            state=KICK_3;
        }
    }
    
    private void moveY(int num) {
        headY += num;
        armY += num;
        rElboY += num;
        lElboY += num;
        lFistY += num;
        rFistY += num;
        legY += num;
        rKneY += num;
        lKneY += num;
        rFootY += num;
        lFootY += num;
    }
    
    private void moveX(int num) {
        headX += num;
        armX += num;
        rElboX += num;
        lElboX += num;
        lFistX += num;
        rFistX += num;
        legX += num;
    }
    
    private void moveRight1() {
        int temp1 = lFootX;
        int temp2 = lFootY;
        int temp3 = lKneX;
        int temp4 = lKneY;
        moveY(-5);
        moveX(10 * orienNum);
        lFootX = legX;
        lFootY = 200;
        lKneX = legX;
        lKneY = 190;
        rFootX = temp1;
        rFootY = temp2;
        rKneX = temp3;
        rKneY = temp4 + 5;
    }
    
    private void moveRight2() {
        rKneX+=15 * orienNum;
        rKneY-=5;
        rFootX = rKneX;
        rFootY = 200;
    }
    
    private void moveRight3() {
        rKneX += 5 * orienNum;
        moveY(5);
        lFootX = legX - (10 * orienNum);
        lKneX = legX + (5 * orienNum);
        rKneY -= 5;
        lKneY = legY + 15;
        rFootY = 200;
        lFootY = 200;
    }
    
    private void moveLeft3() {
        moveY(5);
        moveX(-10 * orienNum);
        lFootX = legX - (10 * orienNum);
        lFootY = 200;
        lKneX = legX + (5 * orienNum);
        lKneY = legY + 15;
        rKneX = legX + (15 * orienNum);
        rKneY = legY + 10;
        rFootX = rKneX - (5 * orienNum);
        rFootY = rKneY + 30;
    }
    
    private void moveLeft2() {
        rKneX-=15 * orienNum;
        rKneY+=5;
        rFootX-=25 * orienNum;
    }
    
    private void moveLeft1() {
        rKneX = legX+(10 * orienNum);
        moveY(-5);
        lFootX = legX;
        lKneX = legX;
        rKneY += 10;
        lKneY = 190;
        rFootY = 200;
        lFootY = 200;
    }
    
    private void moveDown(){
        moveX(-5 * orienNum);
        moveY(25);
        rKneY -= 25;
        lKneY -= 25;
        rFootY -= 25;
        lFootY = rFootY;        
    }
    
    private void backUp() {
        moveX(5 * orienNum);
        moveY(-25);
        rKneY += 25;
        lKneY += 25;
        rFootY += 25;
        lFootY = rFootY;
    }
    
    private void punchOut() {
        rElboX = armX + (15 * orienNum);
        rElboY = armY - 5;
        rFistX = rElboX + (25 * orienNum);
        rFistY = armY - 15;
    }
    
    private void punchIn() {
        rElboX = armX + (5 * orienNum);
        rElboY = armY + 15;
        rFistX = rElboX + (15 * orienNum);
        rFistY = armY + 10;
    }
    
    private void kickOut() {
        rKneX = legX + (15 * orienNum);
        rKneY = legY - 5;
        rFootX = rKneX + (20 * orienNum);
        rFootY = rKneY - 5;
    }
    
    private void kickIn() {
        rKneX = legX + (15 * orienNum);
        rKneY = legY + 10;
        rFootX = rKneX - (5 * orienNum);
        rFootY = rKneY + 30;
    }
    
    public void draw(Graphics g) {
        switch(state) {
            case JUMP:
                if(200 - lFootY >= speedY) {
                    moveY(speedY);
                    speedY += GRAVITY;
                } else {
                    moveY(200 - lFootY);
                    speedY = 0;
                    state = STAND;
                }
                break;
            case RIGHT_1:
                moveRight1();
                state = RIGHT_2;
                break;
            case RIGHT_2:
                moveRight2();
                state = RIGHT_3;
                break;
            case RIGHT_3:
                moveRight3();
                state = STAND;
                break;
            case LEFT_1:
                moveLeft1();
                state = LEFT_2;
                break;
            case LEFT_2:
                moveLeft2();
                state = LEFT_3;
                break;
            case LEFT_3:
                moveLeft3();
                state = STAND;
                break;
            case CROUCH_1:
                moveDown();
                state = CROUCH_2;
                break;
            case CROUCH_3:
                backUp();
                state = STAND;
                break;
            case PUNCH_1:
                punchOut();
                state = PUNCH_2;
                break;
            case PUNCH_3:
                punchIn();
                state = STAND;
                break; 
            case KICK_1:
                kickOut();
                state = KICK_2;
                break;    
            case KICK_3:
                kickIn();
                state = STAND;
                break;     
        }
        g.drawOval(headX-10, headY-10, 20, 20);
        g.drawLine(headX, headY+10, armX, armY);
        g.drawLine(armX, armY, legX, legY);
        g.drawLine(armX, armY, lElboX, lElboY);
        g.drawLine(lElboX, lElboY, lFistX, lFistY);
        g.drawLine(armX, armY, rElboX, rElboY);
        g.drawLine(rElboX, rElboY, rFistX, rFistY);
        g.drawLine(legX, legY, rKneX, rKneY);
        g.drawLine(rKneX, rKneY, rFootX, rFootY);
        g.drawLine(legX, legY, lKneX, lKneY);
        g.drawLine(lKneX, lKneY, lFootX, lFootY);
    }
}
