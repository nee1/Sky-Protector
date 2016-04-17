import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot extends Mover
{
     /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage img = getImage();
        img.scale(20,20);
        setImage(img);
        
        move(30.0);
        
        if (atSide())
        {getWorld().removeObject(this);}
        
    }
    
    public Shot(int rotation)
    {
        setRotation(rotation);
        GreenfootImage img = getImage();
        img.scale(20,20);
        setImage(img);
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
}
