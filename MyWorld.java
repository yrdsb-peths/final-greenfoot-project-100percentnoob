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
        Duck duck = new Duck();
        int x = Greenfoot.getRandomNumber(500);
        addObject(duck,40 + x,300);
        Crosshair crosshair = new Crosshair();
        addObject(crosshair,getWidth()/2,getHeight()/2);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50, 50 );

        Label label = new Label(3, 75);
        addObject(label,54,354);
       
    }

    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);

    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
       bulletcount --;
       label.setValue(bulletcount);
    }
}
