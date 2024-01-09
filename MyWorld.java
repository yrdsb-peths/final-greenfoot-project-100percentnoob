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
    public int bulletcount = 3;
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

        label = new Label(bulletcount, 75);
        addObject(label,54,354);


    }

    public void createDuck()
    {
        duckSpawnDelayTimer.mark();
        duckIsSpawning = true;
    }
    
    private void spawnDuck(){
        Duck duck = new Duck();
        int x = Greenfoot.getRandomNumber(500);
        addObject(duck, 40 + x,300);
    }

    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);

    }

    public void resetbullet()
    {
        bulletcount = 3;
        label.setValue(bulletcount);
    }


    public void prepare()
    {
        bulletcount --;
        label.setValue(bulletcount);
    }

    public void act() {
        if(duckIsSpawning){
            if(duckSpawnDelayTimer.millisElapsed() >= 1000){
                duckIsSpawning = false;
                duckSpawnDelayTimer.mark();
                spawnDuck();
            }
        }
    }
}
