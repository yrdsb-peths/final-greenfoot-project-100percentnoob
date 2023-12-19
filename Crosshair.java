import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crosshair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crosshair extends SmoothMover
{
    GreenfootImage crosshair = new GreenfootImage("crosshair.png");
    /**
     * Act - do whatever the Crosshair wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Crosshair()
    {
        setImage(crosshair);
        crosshair.scale(50,50);
    }
    
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
        {
            setLocation(mouse.getX(),mouse.getY());
        }
    }
}
