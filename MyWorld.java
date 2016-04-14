import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootSound muzik = new GreenfootSound("score.mp3");
    
    Healthbar healthbar = new Healthbar();
    HealthBarRocket healthbarrocket = new HealthBarRocket();
    
    Counter counter = new Counter();
    public Counter getCounter()
    {
        return counter;
    }
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300, 800, 1); 
         GreenfootImage img = new GreenfootImage(1300, 800);
        img.fill();
        setBackground(img);
        addStars(500); 
        Alien alien = new Alien(counter);
        addObject(alien, 504, 61);
        alien.setLocation(1237,49);
        addObject(counter, 100, 40);
        counter.setLocation(656, 43);
        //Adding Rocket to the UI
        Rocket rocket = new Rocket();
        addObject(rocket, 78, 395);
        rocket.setLocation(67, 376);
        //muzik.playLoop();
        
        //Adding HealthBars of Rocket and Enemy Ship
        addObject(healthbar,55,22);
        addObject(healthbarrocket,1244,22);
    }

    public void addStars(int howMany)
    {
        for(int s=0; s<howMany; s++)
        {
            int x = Greenfoot.getRandomNumber( getWidth());
            int y = Greenfoot.getRandomNumber( getHeight());
            addObject(new Star(), x, y);
        }
    }
    
    public void act() {
        muzik.playLoop();
    }



}




