import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Duck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Duck extends SmoothMover
{
    int ran = Greenfoot.getRandomNumber(3);
    double speedx = 3 + (Greenfoot.getRandomNumber(10) / 10);
    double speedy = 3 + (Greenfoot.getRandomNumber(10) / 10);
    GreenfootImage[] idleRight = new GreenfootImage[6];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    GreenfootImage tile = new GreenfootImage("images/duck_tile/tile001.png");
        SimpleTimer animationTimer = new SimpleTimer();

    /**
     * Act - do whatever the Duck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Duck()
    {
        setImage(tile);
        tile.scale(75,75);
        for(int i = 4; i< idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/duck_tile/tile00" + i + ".png");
            idleRight[i].scale(75,75);
        }
        for(int i = 0; i< idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/duck_tile/tile00" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(75,75);
        }
        animationTimer.mark();
        setImage(idleRight[0]);
       
    }

    public void act()
    {
        int ran = Greenfoot.getRandomNumber(1);
        int rightBorder = 600;
        
        double x = getExactX() - speedx;
        double y = getExactY() + speedy;
        setLocation(x,y);
        
       

       
        
        
        if (getY() < 40)
        {
           
            speedy = - speedy;
            
        }
        if(getY() > 300)
        {
            speedy = - speedy;
        }
        if (getX() + 40 >= rightBorder)
        {
            speedx = -speedx;
        }
        if(getX()-40 <= 0)
        {
            speedx= -speedx;
        }
      
    }
}
