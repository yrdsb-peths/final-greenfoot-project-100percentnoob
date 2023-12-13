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
    double speedx = 1;
    double speedy = 1;
    GreenfootImage tile = new GreenfootImage("images/duck_tile/tile001.png");
    /**
     * Act - do whatever the Duck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Duck()
    {
        setImage(tile);
        tile.scale(75,75);
    }
    
    public void act()
    {
        int ran = Greenfoot.getRandomNumber(2);
        int rightBorder = 600;
        double x = getExactX() + speedx;
        double y = getExactY() + speedy;
        setLocation(x,y);
        if(Greenfoot.getRandomNumber(200) == 1)
        {
            speedy = speedy + (ran/4); 
            speedx = speedx + (ran/4);
        }
        if(Greenfoot.getRandomNumber(200) == 1)
        {
            speedy = speedy - (ran/4);    
        }
        if(Greenfoot.getRandomNumber(200) == 1)
        {
            speedy = speedy + (ran/4);    
        }

        if(Greenfoot.getRandomNumber(200) == 1)
        {
            speedx = speedx + (ran/4);   
        }
        if(Greenfoot.getRandomNumber(200) == 1)
        {
            speedx = speedx - (ran/4);
            
        }
        if(Greenfoot.getRandomNumber(500) == 1)
        {
            speedy = -speedy; 
        }
        if(Greenfoot.getRandomNumber(500) == 1)
        {
            speedx = -speedx;
        }
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
