import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author XianBallz
 * @version (a version number or a date)
 */
public class Enemy extends EnemyClass implements Subject 
{
    
    int shotstaken=0;
    int ballstaken=0;
    int enemykilled=0;
    ArrayList<Observer> observers;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
     public Enemy(){
        observers = new ArrayList<Observer>();        
    }
    
    
    
    public void act() 
    {
        if ( ! getWorld().getObjects(GameOverScreen.class).isEmpty() ) return;
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
        
      /*  Actor Ball=getOneIntersectingObject(Ball.class);
        if (Ball!=null)
        {
            getWorld().removeObject(Ball);
            shotstaken++;
        }*/
        
        if (ballstaken>=1)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            //counter.ItotalCount(-10);
            getWorld().removeObject(this);
        }
       
        if (shotstaken>=1)
        {
           //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //Space spaceWorld = (Space) getWorld();
            //Score counter = spaceWorld.getScore();
            //counter.ItotalCount(10);
            //Killed counter2 = spaceWorld.getKilled();
            //counter2.ItotalCount(1);
            Space spaceWorld = (Space) getWorld();
            Score scoreCounter = spaceWorld.getScore();
            Killed killCounter = spaceWorld.getKilled();
            attach(scoreCounter);
            attach(killCounter);
            notifyO();
            enemykilled++;
            getWorld().removeObject(this);
        }
    }
    
    public void moveAround()
    {
        if (enemykilled<25)
        {
            move(4);
        } else{
            move(6);
        }
        
        if (Greenfoot.getRandomNumber(100)<7)
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
    
    public void attach(Observer o){
        observers.add(o);
    }
    public void notifyO(){
        for(Observer o : observers){
            if(o instanceof Score){
            o.ItotalCount(10);
            }
            else if(o instanceof Killed){
            o.ItotalCount(1);
            }
    }
    }
}
