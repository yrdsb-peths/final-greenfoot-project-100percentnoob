import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label ScoreLabel = new Label("score" , 40);
    Label bulletCount = new Label("Bullets",40);
    Label Compare = new Label ("hit / requriment",30);
    Label Start = new Label ("press space to start",40);
  
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage TitleScreen = getBackground();
        TitleScreen.scale(600,400);
        setBackground(TitleScreen);
        prepare();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }

    }
    
    private void prepare()
    {
        addObject(ScoreLabel,40, 20);
        
        addObject(bulletCount,50,375);
        
        addObject(Compare,510,375);
        
        addObject(Start,getWidth()/2,300);
    }
}
