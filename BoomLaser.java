import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A laser weapon that leaves a mass of explosions in it's wake.
 * 
 * @author Bretton Murphy
 */
public class BoomLaser  extends Weapon
{
    private static GreenfootImage[] images;
    
    private int[] explosionPose = new int[8];
    private int intervals = 100;
    private int currentInt = 0;
    private int index = 0;
    
    private int delay = 2;
    private int timer;
    
    private static int damage = 1;
    private static int speed = 50;
    private static int fireRate = 50;
    
    /**
     * Create a boom laser weapon with the specified location, and direction.
     * 
     * @param x The x location within the world.
     * @param y The y location within the world.
     * @param direction The direction the weapon will travel
     * @param ship The ship reference that fire this weapon
     */
    public BoomLaser(int x, int y, double direction, Ship ship)
    {
        super(speed, damage, x, y, direction);
        super.images = this.images;
        setImage("Weapons/boomLaser.png");
        Greenfoot.playSound("Sounds/boomLaser.wav");
        
        currentInt = intervals;
        timer = delay;
        
        state = State.MOVE;
        
        shipRef = ship;
    }
    
    /**
     * Act - do whatever the Circle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!theWorld.isPaused())
        {
            switch(state)
            {      
                case MOVE:
                    moveWeapon();
                    currentInt -= speed;
                    
                    if(currentInt <= 0)
                    {
                        if(index < explosionPose.length)
                        {
                            if(getX() < theWorld.getWidth())
                                explosionPose[index] = getX();
                            index++;
                            currentInt = intervals;
                        }
                    }
                    
                    if(xPose >= getWorld().getWidth() + getImage().getWidth())
                    {
                        index = 0;
                        state = State.BOUNDS;
                    }
                    break;
                    
                case BOUNDS:
                    if(timer <= 0)
                    {
                        if(index < explosionPose.length && explosionPose[index] > 0)
                        {
                            theWorld.addObject(new LaserExplosion(), explosionPose[index], getY());
                            index++;
                        }
                        else
                            removeSelf();
                        timer = delay;
                    }
                    else
                        timer--;
                    break;
                    
                default:
                    System.err.println("BoomLaser has state " + state + " which is incorrect!!");
            }
        }
    }    
    
    /**
     * Loads the animation images for this weapon
     */
    public static void loadAssets()
    {
        LaserExplosion.loadAssets();
    }
    
    /**
     * Unloads this weapons assets
     */
    public static void unLoadAssets()
    {
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
