import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Duck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Duck extends SmoothMover
{
    double speed = 0;
    double speedx = 0;
    double speedy = 0;
    GreenfootImage[] idleRight = new GreenfootImage[3];
    GreenfootImage[] idleLeft = new GreenfootImage[3];
    SimpleTimer DuckSpawn = new SimpleTimer();
    SimpleTimer animationTimer = new SimpleTimer();
    String facing = "left";
    SimpleTimer duckTimer = new SimpleTimer();
    SimpleTimer Hit = new SimpleTimer();
    public static boolean hittAble = true;
    public boolean isFlyingAway = false;

    public Duck(int speed)
    {
        this.speed = speed;

        speedx = speed + (Greenfoot.getRandomNumber(10) / 10);
        speedy = speed + (Greenfoot.getRandomNumber(10) / 10);

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
        Hit.mark();
        hittAble = true;
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
    // This sets it so that when the duck runs away you can not hit it
    public void hitOrNot()
    {
        if(Hit.millisElapsed() > 5000)
        {
            hittAble = false;
        }
    }

    public void act()
    {
        int ran = Greenfoot.getRandomNumber(1);
        MyWorld world = (MyWorld) getWorld();

        // x,y represent where duck will go next
        double x = getExactX() - speedx;
        double y = getExactY() + speedy;
        setLocation(x,y);

        animateDuck();
        if (duckTimer.millisElapsed() > 5000){
            isFlyingAway = true;
        }
        
        if(isFlyingAway){
            flyAway(x,y);
        } else {
            checkWalls();
        }

        hitOrNot();
    }
    // This is for when the duck runs away it will always run to the top right
    // Disappears after reaching the top
    public void flyAway(double x,double y)
    {
        MyWorld world = (MyWorld) getWorld();

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
            world.resetbullet();

        }
    }

    public void FlyAway(double x,double y)
    {
        MyWorld world = (MyWorld) getWorld();
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
            world.resetbullet();

        }
    }

    // It checks for the walls and also sets the duck to go where it would be
    // facing 
    private void checkWalls()
    {
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
