import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spider extends EnemyClass implements Subject
{
    int shotstaken=0;
    int count=0;
    int health=100;
    int spiderkilled=0;
    int ballstaken=0;
    ArrayList<Observer> observers;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Spider(){
        observers = new ArrayList<Observer>();        
    }
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
        
        if (shotstaken>=1)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            Killed counter2 = spaceWorld.getKilled();
            attach(counter);
            attach(counter2);
            notifyO();
            // counter.bumpCount(30);
            // Killed counter2 = spaceWorld.getKilled();
            // counter2.bumpCount(1);
            spiderkilled++;
            getWorld().removeObject(this);
        }
        
        if (ballstaken>=1)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(-30);
            getWorld().removeObject(this);
        }
    }
    
    public void moveAround()
    {
        if (spiderkilled<20)
        {
            move(6);
        }
        
        if (spiderkilled>=20)
        {
            move(12);
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
    public void attach(Observer o){
        observers.add(o);
    }
    public void notifyO(){
        for(Observer o : observers){
            if(o instanceof Score){
            o.ItotalCount(30);
            }
            else if(o instanceof Killed){
            o.ItotalCount(1);
            }
        }
    }
}
