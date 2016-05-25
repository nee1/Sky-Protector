import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends EnemyClass
{
    int shotstaken=0;
    int ballstaken=0;
    int count=0;
    int health=100;
    int beekilled=0;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if ( ! getWorld().getObjects(GameOverScreen.class).isEmpty() ) return;
        moveAround();
        
        GreenfootImage img = getImage();
        img.scale(20,20);
        setImage(img);
        
        Actor Bullet=getOneIntersectingObject(Bullet.class);
        if (Bullet!=null)
        {
            getWorld().removeObject(Bullet);
            shotstaken++;
        }
        
        Actor Shot=getOneIntersectingObject(Shot.class);
        if (Shot!=null)
        {
            getWorld().removeObject(Shot);
            shotstaken++;
        }
        
      /* Actor Ball=getOneIntersectingObject(Ball.class);
        if (Ball!=null)
        {
            getWorld().removeObject(Ball);
            shotstaken++;
        }*/
        
        if (shotstaken>=1)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.ItotalCount(20);
            Killed counter2 = spaceWorld.getKilled();
            counter2.ItotalCount(1);
            beekilled++;
            getWorld().removeObject(this);
        }
        
        if (ballstaken>=1)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
           // counter.ItotalCount(-20);
            getWorld().removeObject(this);
        }
    }
    
    public void moveAround()
    {
        if (beekilled<30)
        {
            move(15);
        }
        
        if (beekilled>=30)
        {
            move(25);
        }
        
        //if (Greenfoot.getRandomNumber(100)<5)
        //{
            //turn(Greenfoot.getRandomNumber(180));
        //}
        
        if (getX() <= 5 || getX() >= getWorld().getWidth() - 5)
        {
            turn(180);
        }
        
        if (getY() <= 5 || getY() >= getWorld().getHeight() - 5)
        {
            turn(180);
        }      
    }
}
