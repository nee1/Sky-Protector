import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Fish here.
 *
 * @XianBallz
 * @version (a version number or a date)
 */
public class Rocket extends Mover implements SubjectHL
{
    int move=0;
    int shootdelay=0;
    int mindelay=4;
    int health=3;
    int end=0;
    private boolean dead=false;
    public boolean FriendDead=false;
    private static final int NUM_FRAGMENTS = 40;
    private ShootStrategy shoot;
    
    public Rocket(){
        shoot = new RedShoot();
    }
    
    
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
            {turn(-6);}

            if (Greenfoot.isKeyDown("right"))
            {turn(6);}

            if (Greenfoot.isKeyDown("down"))
            {move(-6);}
            
            if (Greenfoot.isKeyDown("space"))
            {
                changeStrategy(new RedShoot());
                shoot();
            }
            
            if (Greenfoot.isKeyDown("b"))
            {
                changeStrategy(new BlueShoot());
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
            Space spaceWorld = (Space) getWorld();
            Score r = spaceWorld.getScore();
            //if(r.totalCount>500){
            //    changeStrategy(new BlueShoot());
            //}
            
            getWorld().addObject(shoot.shootBullet(this), getX()+xOffset, getY()+yOffset);
            shootdelay=0;
        }
    }

    /**Hit Something*/
    public void collide()
    {
        Space spaceWorld = (Space) getWorld();
        RHealth counter2 = spaceWorld.getRHealth();
        attach(counter2);
        Actor Enemy;
        Enemy = getOneObjectAtOffset(0,0,Enemy.class);
        if (Enemy !=null)
        {
            health--;
            //Space spaceWorld = (Space) getWorld();
            //RHealth counter2 = spaceWorld.getRHealth();
            //counter2.bumpCount(-1);
            notifyO(-1,counter2);
            World Space;
            Space = getWorld();
            Space.removeObject(Enemy);
        }

        Actor Lady;
        Lady = getOneObjectAtOffset(0,0,Lady.class);
        if (Lady !=null)
        {
            health--;
            //Space spaceWorld = (Space) getWorld();
            //RHealth counter2 = spaceWorld.getRHealth();
            //counter2.bumpCount(-1);
            notifyO(-1,counter2);
        }

        /*Actor Spider;
        Spider = getOneObjectAtOffset(0,0,Spider.class);
        if (Spider !=null)
        {
            health--;
            //Space spaceWorld = (Space) getWorld();
            //RHealth counter2 = spaceWorld.getRHealth();
            //counter2.bumpCount(-1);
            notifyO(-1,counter2);
            World Space;
            Space = getWorld();
            Space.removeObject(Spider);
        }*/

        Actor Rock;
        Rock = getOneObjectAtOffset(0,0,Rock.class);
        if (Rock !=null)
        {
            health--;
            rockexplode();
            //Space spaceWorld = (Space) getWorld();
            //RHealth counter2 = spaceWorld.getRHealth();
            //counter2.bumpCount(-1);
            notifyO(-1,counter2);
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
            //Space spaceWorld = (Space) getWorld();
            //RHealth counter2 = spaceWorld.getRHealth();
            //counter2.bumpCount(-1);
            notifyO(-1,counter2);
            World Space;
            Space = getWorld();
            Space.removeObject(Rock2);
        }

        Actor Bee;
        Bee = getOneObjectAtOffset(0,0,Bee.class);
        if (Bee !=null)
        {
            health--;
            //Space spaceWorld = (Space) getWorld();
            //RHealth counter = spaceWorld.getRHealth();
            //counter.bumpCount(-1);
            notifyO(-1,counter2);
            World Space;
            Space = getWorld();
            Space.removeObject(Bee);
        }

        Actor Fly;
        Fly = getOneObjectAtOffset(0,0,Fly.class);
        if (Fly !=null)
        {
            health--;
            //Space spaceWorld = (Space) getWorld();
            //RHealth counter = spaceWorld.getRHealth();
            //counter.bumpCount(-1);
            notifyO(-1,counter2);
            World Space;
            Space = getWorld();
            Space.removeObject(Fly);
        }

       /* Actor Ball;
        Ball = getOneIntersectingObject(Ball.class);
        if (Ball !=null)
        {
            health--;
            //Space spaceWorld = (Space) getWorld();
            //RHealth counter = spaceWorld.getRHealth();
            //counter.bumpCount(-1);
            notifyO(-1,counter2);
            World Space;
            Space = getWorld();
            Space.removeObject(Ball);
        }*/

        Actor Heart;
        Heart = getOneIntersectingObject(Heart.class);
        if (Heart !=null)
        {
            health++;
           // Space spaceWorld = (Space) getWorld();
            //RHealth counter = spaceWorld.getRHealth();
            //counter.bumpCount(1);
            notifyO(1,counter2);
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
                SLives counter = spaceWorld.getSLives();
                counter.bumpCount(1);
                World Space;
                Space = getWorld();
                Space.removeObject(Life);
                Space.addObject(new Ship(), 600, 300);
                FriendDead=false;
            }
            if (FriendDead=false)*/
            {
                Space spaceWorld4 = (Space) getWorld();
                Lives counter = spaceWorld4.getLives();
                //counter.bumpCount(1);
                notifyL(1,counter);
                World Space;
                Space = getWorld();
                Space.removeObject(Life);
            }
        }

        /*Actor Baby;
        Baby = getOneObjectAtOffset(0,0,Baby.class);
        if (Baby !=null)
        {
            Space spaceworld1 = (Space) getWorld();
            Score counter3 = spaceworld1.getScore();
            counter3.ItotalCount(1000);
            World Space;
            Space = getWorld();
            Space.removeObject(Baby);
        }*/
    }

    /**Die*/
    public void die()
    {
        //Space spaceWorld = (Space) getWorld();
        //Lives counter = spaceWorld.getLives();
        //attach(counter);
        if (health<=0)
        {
            
            Space spaceWorld = (Space) getWorld();
            Lives counter = spaceWorld.getLives();
            //counter.bumpCount(-1);
            notifyL(-1,counter);
            //notifyO(-1,"live");
            explode();
            dead=true;
            if (counter.totalCount>=1)
            {
                getWorld().addObject(new Rocket(),400,300);
            }
            //World space = (Space)getWorld();
            //System.out.println("in Rocket class : printing spae World : " + spaceWorld);
            //Space = getWorld();
            if(counter.totalCount==0){
                ScreenStateManager temp = spaceWorld.getScreenStateManager();
                //System.out.println("temp Object : " + temp);
                //System.out.println("" + temp.showState());
                //temp.setState("ScreenGameOver");
                Space spaceworld = (Space)getWorld();
                RHealth rh = spaceworld.getRHealth();
                notifyO(-3,rh);
                temp.doGameOver(spaceWorld);
                
            }
            spaceWorld.removeObject(this);
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
    
    public void attach(ObserverHL o){
        
    }
    
    public void notifyO(int amount,ObserverHL o){
         o.update(amount);
        }
    
    public void notifyL(int amount, ObserverHL o){
        o.update(amount);
    }
    
    public void changeStrategy(ShootStrategy s){
        shoot = s;
    }

    /**Is 2nd Player Dead?*/
    /**public void friendCheck()
    {
            Space spaceWorld = (Space) getWorld();
            SLives counter = spaceWorld.getSLives();
            if (counter.totalCount<=0)
            {FriendDead=true;}
    }*/
}
