import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author XianBallz
 * @version (a version number or a date)
 */
public class Enemy extends Spawner
{
    
    int shotstaken=0;
    int ballstaken=0;
    int enemykilled=0;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveAround();
        
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
        
        Actor Ball=getOneIntersectingObject(Ball.class);
        if (Ball!=null)
        {
            getWorld().removeObject(Ball);
            shotstaken++;
        }
        
        if (ballstaken>=1)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(-10);
            getWorld().removeObject(this);
        }
       
        if (shotstaken>=1)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(10);
            Killed counter2 = spaceWorld.getKilled();
            counter2.bumpCount(1);
            enemykilled++;
            getWorld().removeObject(this);
        }
    }
    
    public void moveAround()
    {
        if (enemykilled<50)
        {
            move(4);
        }
        
        if (enemykilled>=50)
        {
            move(8);
        }
        
        if (Greenfoot.getRandomNumber(100)<5)
        {
            turn(Greenfoot.getRandomNumber(180));
        }
        
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
