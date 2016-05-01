import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A weapon that shoots a ball of fire that explodes on contac
 * 
 * @author Bretton Murphy 
 */
public class FireBall  extends Weapon
{
    private static GreenfootImage[] images;
    
    private double[] angles = {.6, 2.5, -.5, 2, -1, .4, 4, -.3, 1.3, .1, -1.3, 3, -.8, -2, .3, -.1};
    private int index = 0;

    private static int damage = 1;
    private static int speed = 5;
    private static int fireRate = 50;
    
    private int delay = 2;
    private int timer;
    
    private boolean flames;
    
    /**
     * Create a fireball weapon with the specified location, and direction.
     * 
     * @param x The x location within the world
     * @param y The y location within the world
     * @param direction The direction the weapon will travel
     * @param ship The ship reference that fired this weapon
     */
    public FireBall(int x, int y, double direction, Ship ship, boolean shootsFlames)
    {
        super(speed, damage, x, y, direction, 5);
        super.images = this.images;
        setImage("Weapons/fireBall0.png");
        
        flames = shootsFlames;
        timer = delay;
        
        state = State.MOVE;
        
        sound = new GreenfootSound("FireBallTravel.wav");
        
        sound.playLoop();
        
        shipRef = ship;
    }
    
    /**
     * Act - do whatever the FireBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!theWorld.isPaused())
        {
            if(!sound.isPlaying())
                sound.playLoop();
                
            switch(state)
            {
                case MOVE:
                    moveWeapon();
                    animate();
                    checkCollisions();
                    
                    if(flames)
                    {
                        if(timer <= 0)
                        {
                            theWorld.addObject(new FlameBullet(getX(), getY(), angles[index], shipRef), getX(), getY());
                            index = (index + 1) % angles.length;
                            timer = delay;
                        }
                        else
                            timer--;
                    }
                    
                    break;
                    
                case CONTACT:
                    theWorld.addObject(new FireBlast(), getX(), getY());
                    sound.stop();
                    removeSelf();
                    break;
                    
                case BOUNDS:
                    sound.stop();
                    removeSelf();
                    break;
                    
                default:
                    System.err.println("Fireball state " + state + " not recognized");
            }
        }
        else
        {
            if(sound.isPlaying())
                sound.pause();
        }
    } 
    
    /**
     * Loads the animation images for this weapon
     */
    public static void loadAssets()
    {
        FireBlast.loadAssets();
        
        images = new GreenfootImage[5];
        
        for(int i = 0; i < images.length; i++)
            images[i] = new GreenfootImage("Weapons/fireBall" + i + ".png");
    }
    
    /**
     * Unloads this weapons assets
     */
    public static void unLoadAssets()
    {
        //FireBlast.unLoadAssets();
        images = null;
    }
    
    /**
     * Get's the weapons damage
     * 
     * @return The damage this weapon inflicts
     */
    public static int damage()
    {
        return damage;
    }
    
    /**
     * Get's the weapons speed
     * 
     * @return The speed that this weapon travels at
     */
    public static int speed()
    {
        return speed;
    }
    
    /**
     * Get's how fast the weapon is fired
     * 
     * @return The speed that this weapon is fired at
     */
    public static int fireRate()
    {
        return fireRate;
    }
}
