import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Mover
{
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int move=0;
    int shootdelay=0;
    int mindelay=4;
    int health=3;
    private boolean dead=false;
    public boolean FriendDead=false;
    private static final int NUM_FRAGMENTS = 40;
    
    
    public void act() 
    {
        GreenfootImage img=getImage();
        img.scale(60,30);
        setImage(img);
        
        collide();
        
        die();
        
        shootdelay++;
        
        movement();
    }    
    
    public void movement()
    {
        if (!dead)
        {
            move(1);
        
            if (Greenfoot.isKeyDown("up"))
            {move(6);}
        
            if (Greenfoot.isKeyDown("left"))
            {turn(-7);}
        
            if (Greenfoot.isKeyDown("right"))
            {turn(7);}
        
            if (!Greenfoot.isKeyDown("space"))
            {
                shoot();
            }
        }
    }
    
    public void shoot()
    {
        if (shootdelay>=mindelay)
        {
            int rot = getRotation()-10;
            int xOffset = (int)(40*Math.cos(Math.toRadians(rot)));
            int yOffset = (int)(40*Math.sin(Math.toRadians(rot)));
            Shot b = new Shot(getRotation());
            
            getWorld().addObject(b, getX()+xOffset, getY()+yOffset);
            shootdelay=0;
        }
    }
    
    public void collide()
    {
        Actor Enemy;
        Enemy = getOneObjectAtOffset(0,0,Enemy.class);
        if (Enemy !=null)
        {
            health--;
            Space spaceWorld = (Space) getWorld();
            SHealth counter2 = spaceWorld.getSHealth();
            counter2.bumpCount(-1);
            World Space;
            Space = getWorld();
            Space.removeObject(Enemy);
        }
        
        Actor Lady;
        Lady = getOneObjectAtOffset(0,0,Lady.class);
        if (Lady !=null)
        {
            health--;
            Space spaceWorld = (Space) getWorld();
            SHealth counter2 = spaceWorld.getSHealth();
            counter2.bumpCount(-1);
        }
        
        Actor Spider;
        Spider = getOneObjectAtOffset(0,0,Spider.class);
        if (Spider !=null)
        {
            health--;
            Space spaceWorld = (Space) getWorld();
            SHealth counter2 = spaceWorld.getSHealth();
            counter2.bumpCount(-1);
            World Space;
            Space = getWorld();
            Space.removeObject(Spider);
        }
        
        Actor Rock;
        Rock = getOneObjectAtOffset(0,0,Rock.class);
        if (Rock !=null)
        {
            health--;
            rockexplode();
            Space spaceWorld = (Space) getWorld();
            SHealth counter2 = spaceWorld.getSHealth();
            counter2.bumpCount(-1);
            World Space;
            Space = getWorld();
            Space.removeObject(Rock);
        }
        
        Actor Rock2;
        Rock2 = getOneObjectAtOffset(0,0,Rock2.class);
        if (Rock2 !=null)
        {
            health--;
            rockexplode();
            Space spaceWorld = (Space) getWorld();
            SHealth counter2 = spaceWorld.getSHealth();
            counter2.bumpCount(-1);
            World Space;
            Space = getWorld();
            Space.removeObject(Rock2);
        }
        
        
        Actor Bee;
        Bee = getOneObjectAtOffset(0,0,Bee.class);
        if (Bee !=null)
        {
            health--;
            Space spaceWorld = (Space) getWorld();
            SHealth counter2 = spaceWorld.getSHealth();
            counter2.bumpCount(-1);
            World Space;
            Space = getWorld();
            Space.removeObject(Bee);
        }
        
        Actor Ball;
        Ball = getOneIntersectingObject(Ball.class);
        if (Ball !=null)
        {
            health--;
            Space spaceWorld = (Space) getWorld();
            SHealth counter = spaceWorld.getSHealth();
            counter.bumpCount(-1);
            World Space;
            Space = getWorld();
            Space.removeObject(Ball);
        }
        
        Actor Heart;
        Heart = getOneIntersectingObject(Heart.class);
        if (Heart !=null)
        {
            health++;
            Space spaceWorld = (Space) getWorld();
            SHealth counter = spaceWorld.getSHealth();
            counter.bumpCount(1);
            World Space;
            Space = getWorld();
            Space.removeObject(Heart);
        }
        
        Actor Life;
        Life = getOneIntersectingObject(Life.class);
        if (Life !=null)
        {
            /**friendCheck();
            
            if (FriendDead=true)
            {
                Space spaceWorld = (Space) getWorld();
                Lives counter = spaceWorld.getLives();
                counter.bumpCount(1);
                World Space;
                Space = getWorld();
                Space.removeObject(Life);
                Space.addObject(new Rocket(), 400, 300);
                FriendDead=false;
            }
            if (FriendDead=false)*/
            {
                Space spaceWorld = (Space) getWorld();
                SLives counter = spaceWorld.getSLives();
                counter.bumpCount(1);
                World Space;
                Space = getWorld();
                Space.removeObject(Life);
            }
        }
        
        Actor Baby;
        Baby = getOneObjectAtOffset(0,0,Baby.class);
        if (Baby !=null)
        {
            Space spaceworld = (Space) getWorld();
            Score counter2 = spaceworld.getScore();
            counter2.bumpCount(1000);
            World Space;
            Space = getWorld();
            Space.removeObject(Baby);
        }
    }
    
    public void die()
    {
        if (health<=0)
        {
            Space spaceWorld = (Space) getWorld();
            SLives counter = spaceWorld.getSLives();
            counter.bumpCount(-1);
            explode();
            dead=true;
            if (counter.totalCount>=1)
            {
                getWorld().addObject(new Ship(),400,300);
            }
            World Space;
            Space = getWorld();
            Space.removeObject(this);
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
    
    /**Is 1st Player Dead?*/
    /**public void friendCheck()
    {
            Space spaceWorld = (Space) getWorld();
            Lives counter = spaceWorld.getLives();
            if (counter.totalCount<=0)
            {FriendDead=true;}
    }*/
}
