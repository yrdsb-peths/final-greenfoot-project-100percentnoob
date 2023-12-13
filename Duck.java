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
        double x = getExactX() + speedx;
       double y = getExactY() + speedy;
       setLocation(x,y);
        if(Greenfoot.getRandomNumber(2) == 1)
        {
        speedy = speedy + ran; 
        speedx = speedx + ran;
        }
        if (getY() < 40)
        {
           
            speedy = - speedy;
            
        }
        if(getY() > 300)
        {
            speedy = - speedy;
        }
      
    }
}
