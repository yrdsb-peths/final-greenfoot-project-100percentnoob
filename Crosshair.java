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
    int bulletCount = 4;
    Label bulletLabel;
    SimpleTimer duckFlyAway = new SimpleTimer();
    /**
     * Act - do whatever the Crosshair wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Crosshair()
    {
        setImage(crosshair);
        crosshair.scale(50,50);
        duckFlyAway.mark();
    }
    
   
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseClicked(null))
        {
            bulletCount --;
            bulletCount = world.getBullet();
            
            world.prepare();
            if (isTouching(Duck.class)&& (bulletCount > 0) && (Duck.hittAble == true))
            {
                removeTouching(Duck.class);
                world.createDuck();
                world.resetbullet();
                duckFlyAway.mark();
                if(bulletCount == 3)
                {
                    world.increaseScore3();
                }
                if(bulletCount == 2)
                {
                    world.increaseScore2();
                }
                if(bulletCount == 1)
                {
                    world.increaseScore1();
                }
            }
            
        }
        if(mouse != null)
        {
            setLocation(mouse.getX(),mouse.getY());
        }
        
        
        
    }
    
    public void timer()
    {
        duckFlyAway.mark();
    }
    
}
