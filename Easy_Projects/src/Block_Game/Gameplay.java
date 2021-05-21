package Block_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener 
{
	private boolean play = false;
	private int score = 0;
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int PlayerX = 310;
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
        private Map map;
        
        
	public Gameplay()
	{
                map = new Map(3,7);
 		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	public void paint(Graphics g)
	{
		// background
		g.setColor(Color.black);
		g.fillRect(1,1,692,592);
		
                // map
                map.draw((Graphics2D)g);
		// border
		g.setColor(Color.yellow);
		g.fillRect(0,0,3,592);
		g.fillRect(0,0,692,3);
		g.fillRect(691,0,3,592);
		
                
                
                //
                g.setColor(Color.white);
                g.setFont(new Font("serif",Font.BOLD,25));
                g.drawString(""+score, 590, 30);
		// paddle
		g.setColor(Color.green);
		g.fillRect(PlayerX,550,100,8);
		
		//ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX,ballposY,20,20);
		if(ballposY>570)
                {
                    play = false;
                    ballXdir = 0;
                    ballYdir = 0;
                    g.setColor(Color.red);
                    g.setFont(new Font("serif",Font.BOLD,30));
                    g.drawString("Game Over , Score :"+score, 230, 250);
                    
                   g.setFont(new Font("serif",Font.ITALIC,40));
                   g.drawString("Press Enter to Restart", 230, 350);
                }
                
                if(totalBricks<=0)
                {
                      play = false;
                    ballXdir = 0;
                    ballYdir = 0;
                    g.setColor(Color.red);
                    g.setFont(new Font("serif",Font.BOLD,30));
                    g.drawString(" You Won, Score :"+score, 230, 250);
                    
                   g.setFont(new Font("serif",Font.ITALIC,40));
                   g.drawString("Press Enter to Restart", 230, 350);
                    
                }
                g.dispose();
                
        }
	
	public void actionPerformed(ActionEvent ae)
        {
            timer.start();
            repaint();
            if(play)
            {
                if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(PlayerX,550,100,8)))
                {
                    ballYdir = - ballYdir;  
                }
                for(int i=0; i<map.map.length; i++)
                {
                    for(int j=0; j<map.map[0].length; j++)
                    {
                        if(map.map[i][j]>0)
                        {
                            int brickX = j*map.brickWidth+80;
                            int brickY = i*map.brickHeight+50;
                            int brickWidth = map.brickWidth;
                            int brickHeight = map.brickHeight;
                            Rectangle rect = new Rectangle(brickX,brickY,brickWidth, brickHeight);
                            Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
                            Rectangle brickRect = rect;
                            if(ballRect.intersects(brickRect))
                            {
                                map.setBrickValue(0,i,j);
                                totalBricks--;
                                score+=5;
                                System.out.println(score);
                                if(ballposX+19<=brickRect.x||ballposX+1>=brickRect.x+brickWidth)
                                {
                                    ballXdir =-ballXdir;
                                    
                                }
                                else
                                {
                                    ballYdir = -ballYdir;
                                }
                            }
                        }
                    }
                }
                ballposX += ballXdir;
                ballposY += ballYdir;
                if(ballposX<0)
                {
                    ballXdir = -ballXdir;
                }
                if(ballposY<0)
                {
                    ballYdir = -ballYdir;
                }
                if(ballposX>670)
                {
                    ballXdir = -ballXdir;
                }
                
            
            
            
            
            }
        }
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                if(PlayerX>=600)
                    PlayerX=600;
                else
                {
                    moveRight();
                }
           
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                if(PlayerX<10)
                {
                    PlayerX =10;
                }
                else
                {
                    moveLeft();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                if(!play)
                {
                    play = true;
                    ballposX = 120;
                    ballposY = 350;
                    ballXdir = -1;
                    ballYdir = -2;
                    PlayerX = 310;
                    score =0;
                    totalBricks = 21;
                    map = new Map(3,7);
                    repaint();
                    
                }
            }
        }       
        
            
            
	public void moveLeft()
	{
                 play = true;
		PlayerX-=20;
		//System.out.println("left method is called");

	}
	public void moveRight()
	{
		//System.out.println("right method is called");
		play = true;
		PlayerX+=20;
	}
	
	public void keyReleased(KeyEvent e){}

    
    
}
