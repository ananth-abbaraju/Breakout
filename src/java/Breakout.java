import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
 
public class Breakout extends JPanel {
 
    private int width, height;
    private int speed;
    private Ball ball; 
    private Paddle paddle;
    private int score;
    private String scoreString;
    public boolean gameLost = false;

    private ArrayList<Brick> bricks;

    public void paintWon(Graphics g){
     
        super.paint(g);
        g.setFont(new java.awt.Font("Arial", 2, 38));
        g.setColor(Color.MAGENTA);
        g.drawString("YOU WON!", 105, 260);
        speed = 0;
        ball.setYA(0);
        ball.setXA(0);
     
    }
 
    public void paintLost(Graphics g){
     
        super.paint(g);
        g.setFont(new java.awt.Font("Arial", 2, 38));
        g.setColor(Color.MAGENTA);
        g.drawString("YOU LOST!", 105, 260);
        ball.setYA(0);
        ball.setXA(0);
     
    }
 
    public Breakout(int w, int h) {

        width = w;
        height = h;
        speed = 3;
        score = 0;

        setSize(width, height);
        setLocation(200, 50); 
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
 
        ball = new Ball(10, 60, this); 
        paddle = new Paddle(260, 465, this);

        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
 
            public void keyPressed(KeyEvent e) {
                paddle.keyPressed(e);
            }
 
            public void keyReleased(KeyEvent e) {
                paddle.keyReleased(e);
            }
        });
 
        setFocusable(true);
        createGrid();
    }

 
    @Override
    public void paint(Graphics g) {
     
        super.paint(g);
        paddle.paint(g);
        ball.paint(g); 

        for (int x = bricks.size() - 1; x >= 0; x--) {
         
            bricks.get(x).paint(g);
         
            if (gameLost == true){
                paintLost(g); 
            }

            if (bricks.get(x).collision()) {
             
                if (speed < 9) {
                    speed += 1; 
                }
             
                ball.setYA(speed);
                paddle.setSpeed(speed+1);
                bricks.remove(x);
                score += 10;
                System.out.println("SCORE: " + score);
             
                if (bricks.size() == 0) {
                    System.out.println("You Won!");
                    paintWon(g);
                }
             
            }
           
        }
       
    }

    public void move() {
        paddle.movePaddle();
     
        if (ball != null) {
            ball.moveBall();
        }
    }

    public ArrayList<Brick> createGrid() {
        bricks = new ArrayList<Brick>();
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 10; col++) {
                bricks.add(new Brick((col * 40) + 3, (row * 25) + 3, this));
            }
        }

        return bricks;
    }
 
    // getters
    public int getSpeed() {
        return speed;
    }
    public Ball getBall() {
        return ball;
    }
    public Paddle getPaddle() {
        return paddle;
    }
    public int getScore() {
        return score;
    }
    public String getScoreString() {
        return scoreString;
    }
    public int getBricks() {
        return bricks.size();
    }
}
 

