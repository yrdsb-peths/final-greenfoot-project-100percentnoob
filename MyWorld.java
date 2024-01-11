import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Label scoreLabel;
    public int score =0;
    public int bulletCount = 3;
    public int speed = 3; 
    int duckCount = 0;
    int requriment = 10;
    int numOfDuck = 0;
    Label label;
    SimpleTimer duckSpawnDelayTimer = new SimpleTimer();
    boolean duckIsSpawning = false;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage backgroundImage = getBackground();
        backgroundImage.scale(600,400);
        setBackground(backgroundImage);
        createDuck();

        Crosshair crosshair = new Crosshair();
        addObject(crosshair,getWidth()/2,getHeight()/2);

        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50, 50 );

        label = new Label(bulletCount, 75);
        addObject(label,54,354);


    }
    
     public int getBullet()
    {
        return bulletCount;
    }
    
    public double getSpeed()
    {
        return speed;
    }
    
    public void createDuck()
    {
        duckSpawnDelayTimer.mark();
        duckIsSpawning = true;
    }
    
    private void spawnDuck(){
        Duck duck = new Duck(speed);
        int x = Greenfoot.getRandomNumber(500);
        addObject(duck, 50 + x,300);
        duckCount++;
        if (duckCount % 10 == 0)
        {
            speed ++;
            requriment --;
        }
    }

    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        numOfDuck++;
    }

    public void resetbullet()
    {
        bulletCount = 3;
        label.setValue(bulletCount);
    }


    public void prepare()
    {
        bulletCount --;
        label.setValue(bulletCount);
    }

    public void act() {
        if(duckIsSpawning){
            if(duckSpawnDelayTimer.millisElapsed() >= 1500){
                duckIsSpawning = false;
                duckSpawnDelayTimer.mark();
                spawnDuck();
            }
        }
        //if(numOfDuck < requriment)
        //{
            //GameOver world = new GameOver();
           // Greenfoot.setWorld(world);
       // }
    }
}
