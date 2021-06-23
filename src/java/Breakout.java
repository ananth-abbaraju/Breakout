import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
 
public class Breakout extends JPanel {
    // instance variable
    private int width, height;
    private int speed;
    private Ball ball; // gives access to ball anywhere in the class
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

    // constructor takes in two parameters for the size of the JPanel
    // uses the methods from the JPanel class to create a visible
    // panel for the other objects of the game to appear on
 
    public Breakout(int w, int h) {

        width = w;
        height = h;
    
        speed = 3;

        score = 0;

        setSize(width, height);
        setLocation(200, 50); // x = 200, y = 50
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
 
        ball = new Ball(10, 60, this); // makes an instance of the class
        paddle = new Paddle(260, 465, this);

        // listen for the key pressing
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
 
        // MUST HAVE TO MAKE SURE BREAKOUT IS FOCUSED
        setFocusable(true);
        createGrid();
    }
 
    /**
     * Displays graphics on the JPanel
     *
     * @param g is the declaration of the Graphics class, where all the methods
     *          needed to get graphics onto the JPanel
     */
 
    @Override
    public void paint(Graphics g) {
        // need to invoke paint in order to see the JPanel
        super.paint(g);
        paddle.paint(g);
        ball.paint(g); // draws the ball on the panel

        for (int x = bricks.size() - 1; x >= 0; x--) {
            bricks.get(x).paint(g);

            if (gameLost == true){
                paintLost(g); // if ball goes below paddle, then gameLost is set to true in Ball.java, gameLost is declared on line 17 in Breakout.java(this class) 
            }

            if (bricks.get(x).collision()) {
                if (speed < 9) {
                    speed += 1; // speeds up ball & paddle everytime a brick is hit until speed=8
                }
                // speed = 1;
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
    /**
     * This method will get movement in the game
     */
    public void move() {
        paddle.movePaddle();
        if (ball != null) {
            ball.moveBall();
        }
    }

    /* -------------------- The Brick Grid -------------------- */
    public ArrayList<Brick> createGrid() {
        bricks = new ArrayList<Brick>();
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 10; col++) {
                bricks.add(new Brick((col * 40) + 3, (row * 25) + 3, this));
            }
        }


        return bricks;
    }
 
    /* ------------------- Getters and Setters -------------------- */
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
 

