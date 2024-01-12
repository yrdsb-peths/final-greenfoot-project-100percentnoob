import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    Label scoreLabel;
    int score = 0;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
         GreenfootImage ENDING = getBackground();
        ENDING.scale(600,400);
        setBackground(ENDING);
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50, 50 );
        this.score = score;
        scoreLabel.setValue(score);
    }
}
