import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
public class Mover extends Actor
{
    private static final double WALKING_SPEED = 5.0;
    
    /**
     * Turn 90 degrees to the right (clockwise).
     */
    public void turn()
    {
        turn(90);
    }
    
    /**
     * Turn 'angle' degrees towards the right (clockwise).
     */
    public void turn(int angle)
    {
        setRotation(getRotation() + angle);
    }
    
    /**
     * Move a bit forward in the current direction.
     */
    public void move()
    {
        move(WALKING_SPEED);
    }
    
    /**
     * Move a specified distance forward in the current direction.
     */
    public void move(double distance)
    {
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * distance);
        int y = (int) Math.round(getY() + Math.sin(angle) * distance);
        
        setLocation(x, y);
    }

    /**
     * Test if we are close to one of the edges of the world. Return true is we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20)
            return true;

        else
            return false;
    }
    
    public boolean atWorldEdge2()
    {
        if(getY()<20)
            return true;
        else
            return false;        
    }
    
    public boolean atWorldEdge3()
    {
        if(getX() >840)
            return true;
        else
            return false;
    }
    
    public boolean atWorldEdge4()
    {
        if(getY() > 540)
            return true;
        else
            return false;
    }
}