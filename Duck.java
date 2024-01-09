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
    GreenfootImage[] idleRight = new GreenfootImage[3];
    GreenfootImage[] idleLeft = new GreenfootImage[3];
    SimpleTimer DuckSpawn = new SimpleTimer();
    SimpleTimer animationTimer = new SimpleTimer();
    String facing = "left";
    SimpleTimer duckTimer = new SimpleTimer();
    double speed = 0;
    /**
     * Act - do whatever the Duck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Duck()
    {

        for(int i = 0; i< idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/ducks/tile00" + i + ".png");
            idleRight[i].scale(75,75);
        }
        for(int i = 0; i< idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/ducks/tile00" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(75,75);
        }
        animationTimer.mark();
        setImage(idleRight[0]);
        duckTimer.mark();

    }
    int imageIndex = 0;

    public void animateDuck()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else 
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }

    
    
    public void act()
    {
        int ran = Greenfoot.getRandomNumber(1);
        MyWorld world = (MyWorld) getWorld();
        speed = world.getSpeed();
        speedx = speedx + speed;
        speedy = speedy + speed;
        double x = getExactX() - speedx;
        double y = getExactY() + speedy;
        setLocation(x,y);
        animateDuck();

        if(duckTimer.millisElapsed() > 5000)
        {
            if(speedx > 0)
            {
                speedx = -speedx;
                x = getExactX() + speedx;
            }
            if ( speedy > 0 )
            {   speedy = - speedy;
                y = getExactY() - speedy;
            }
            facing = "right";
            setLocation(x,y);
            animateDuck();
            if (getY() < 40)
            {
                world.createDuck();
                world.removeObject(this);
              

            }

        }
        else
        {
            checkWalls();

        }
    }
    

    private void checkWalls(){
        int rightBorder = 600;
        if (getY() < 40)
        {
            speedy = - speedy;
            if (speedx < 0 && speedy < 0)
            {
                facing = "right";
            }

        }
        if(getY() > 300)
        {
            speedy = - speedy;
            facing = "left";
            if (speedx < 0 && speedy < 0)
            {
                facing = "right";
            }
        }
        if (getX() + 40 >= rightBorder)
        {
            speedx = -speedx;
            facing = "left";

        }
        if(getX()-40 <= 0)
        {
            speedx= -speedx;
            facing = "right";
        }
    }
}
