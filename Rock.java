import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends EnemyClass
{
    int shotstaken=0;
    int ballstaken=0;
    int count=0;
    int health=100;
    int NUM_FRAGMENTS=40;
    private boolean dead=false;
    int size = Greenfoot.getRandomNumber(50) + 40;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        GreenfootImage img = getImage();
        img.scale (size, size);
        
        moveAround();
        
        eat();
        
        if (!dead)
        {
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
        
        
            if (atSide())
            {getWorld().removeObject(this);}
        }
    }
    
    public void moveAround()
    {
        move(2);     
    }
    
    public void eat()
    {
        Actor Enemy;
        Enemy = getOneIntersectingObject(Enemy.class);
        if (Enemy !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Enemy);
        }
        
        Actor Bee;
        Bee = getOneIntersectingObject(Bee.class);
        if (Bee !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Bee);
        }
        
        Actor Spider;
        Spider = getOneIntersectingObject(Spider.class);
        if (Spider !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Spider);
        }
        
        Actor Fly;
        Fly = getOneIntersectingObject(Fly.class);
        if (Fly !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Fly);
        }
        
        Actor Rock2;
        Rock2 = getOneIntersectingObject(Rock2.class);
        if (Rock2 !=null)
        {
            dead=true;
            World Space;
            Space = getWorld();
            rockexplode();
            Space.removeObject(Rock2);
            Space.removeObject(this);
        }
    }
    
    public boolean atSide()
    {
        if (getX() == 0 || getX()==999)
        return true;
        
        if (getY()==0 || getY()==599)
        return true;
        
        else
        return false;
    }
    
    /**Rock Explode*/
    public void rockexplode()
    {
        placePebble (getX(), getY(), NUM_FRAGMENTS);
    }
    
    private void placePebble(int x, int y, int numFragments)
    {
        for (int i=0; i < numFragments; i++) 
        {
            getWorld().addObject ( new Pebble(), x, y );
        }
    }
}
