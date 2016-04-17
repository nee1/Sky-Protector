import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author XianBallz
 * @version (a version number or a date)
 */
public class Plane extends Spawner
{
    int move=0;
    int shotstaken=0;
    int planekilled=0;
    int shootdelay=0;
    int mindelay=6;
    int NUM_FRAGMENTS=40;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage img=getImage();
        img.scale(60,60);
        setImage(img);
        
        collide();
        
        moveAround();
        
        shootdelay++;
        
        shoot();
        
        Actor Bullet=getOneIntersectingObject(Bullet.class); 
        if (Bullet!=null)
        {
            getWorld().removeObject(Bullet);
            shotstaken++;
            Space spaceWorld = (Space) getWorld();
            PHealth counter = spaceWorld.getPHealth();
            counter.bumpCount(-1);
        }
        
        Actor Shot=getOneIntersectingObject(Shot.class);
        if (Shot!=null)
        {
            getWorld().removeObject(Shot);
            shotstaken++;
            Space spaceWorld = (Space) getWorld();
            PHealth counter = spaceWorld.getPHealth();
            counter.bumpCount(-1);
        }
       
        if (shotstaken>=50)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(2000);
            Killed counter2 = spaceWorld.getKilled();
            counter2.bumpCount(1);
            explode();
            planekilled++;
            getWorld().removeObject(this);
        }
    }
    
    public void shoot()
    {
        if (shootdelay>=mindelay)
        {
            int rot = getRotation()-10;
            int xOffset = (int)(40*Math.cos(Math.toRadians(rot)));
            int yOffset = (int)(40*Math.sin(Math.toRadians(rot)));
            Ball b = new Ball(getRotation());
            getWorld().addObject(b, getX()+xOffset, getY()+yOffset);
            shootdelay=0;
        }
    }
    
    public void moveAround()
    {
        if (planekilled<10)
        {
            move(4);
        }
        
        if (planekilled>=10)
        {
            move(8);
        }
        
        if (Greenfoot.getRandomNumber(5)==1)
        {
            if (Greenfoot.getRandomNumber(10)>5)
            {turn(10);}
            else
            {turn(-10);}
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
    
    public void collide()
    {
        Actor Enemy;
        Enemy = getOneObjectAtOffset(0,0,Enemy.class);
        if (Enemy !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Enemy);
        }
        
        Actor Lady;
        Lady = getOneObjectAtOffset(0,0,Lady.class);
        if (Lady !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Lady);
        }
        
        Actor Spider;
        Spider = getOneObjectAtOffset(0,0,Spider.class);
        if (Spider !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Spider);
        }
        
        Actor Rock;
        Rock = getOneObjectAtOffset(0,0,Rock.class);
        if (Rock !=null)
        {
            rockexplode();
            World Space;
            Space = getWorld();
            Space.removeObject(Rock);
        }
        
        Actor Bee;
        Bee = getOneObjectAtOffset(0,0,Bee.class);
        if (Bee !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Bee);
        }
        
        Actor Fly;
        Fly = getOneObjectAtOffset(0,0,Fly.class);
        if (Fly !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Fly);
        }
        
        Actor Baby;
        Baby = getOneObjectAtOffset(0,0,Baby.class);
        if (Baby !=null)
        {
            Space spaceworld = (Space) getWorld();
            Score counter2 = spaceworld.getScore();
            counter2.bumpCount(-1000);
            World Space;
            Space = getWorld();
            Space.removeObject(Baby);
        }
    }
    
    /**Death Animation*/
    public void explode()
    {
        placeDebris (getX(), getY(), NUM_FRAGMENTS);
    }
    
    private void placeDebris(int x, int y, int numFragments)
    {
        for (int i=0; i < numFragments; i++) 
        {
            getWorld().addObject ( new Debris(), x, y );
        }
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
