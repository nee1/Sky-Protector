import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Special here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lady extends EnemyClass implements Subject
{
    int shotstaken=0;
    int ladykilled=0;
    int ballstaken=0;
    ArrayList<Observer> observers;
    public Lady(){
        observers = new ArrayList<Observer>();        
    }
    public void act() 
    
    {
        moveAround();
        eat();
        
        GreenfootImage img = getImage();
        img.scale(100,100);
        setImage(img);
        
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
            ballstaken++;
        }
        
        if (shotstaken>=30)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            Killed counter2 = spaceWorld.getKilled();
            attach(scoreCounter);
            attach(killCounter);
            notifyO();
            //counter.bumpCount(500);
            
            //counter2.bumpCount(1);
            ladykilled++;
            getWorld().removeObject(this);
        }
        
        if (ballstaken>=30)
        {
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            //getWorld().addObject(new Enemy(),(Greenfoot.getRandomNumber(1000)),(Greenfoot.getRandomNumber(600)));
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(-500);
            getWorld().removeObject(this);
        }
    }

    public void attach(Observer o){
        observers.add(o);
    }

    public void moveAround()
    {
        if (ladykilled<5)
        {
            move(2);
        }
        
        if (ladykilled>=5)
        {
            move(4);
        }
        
        if (Greenfoot.getRandomNumber(100)<3)
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
    
    public void eat()
    {
        Actor Enemy;
        Enemy = getOneObjectAtOffset(0,0,Enemy.class);
        if (Enemy !=null)
        {
            World Space;
            Space = getWorld();
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(-10);
            Space.removeObject(Enemy);
        }
        
        Actor Bee;
        Bee = getOneObjectAtOffset(0,0,Bee.class);
        if (Bee !=null)
        {
            World Space;
            Space = getWorld();
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();  
            counter.bumpCount(-20);
            Space.removeObject(Bee);
        }
        
        Actor Spider;
        Spider = getOneObjectAtOffset(0,0,Spider.class);
        if (Spider !=null)
        {
            World Space;
            Space = getWorld();
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(-30);
            Space.removeObject(Spider);
        }
        
        Actor Rock;
        Rock = getOneObjectAtOffset(0,0,Rock.class);
        if (Rock !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Rock);
        }
        
        Actor Rock2;
        Rock2 = getOneObjectAtOffset(0,0,Rock2.class);
        if (Rock2 !=null)
        {
            World Space;
            Space = getWorld();
            Space.removeObject(Rock2);
        }
        
        Actor Lady;
        Lady = getOneObjectAtOffset(0,0,Lady.class);
        if (Lady !=null)
        {
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(-500);
            World Space;
            Space = getWorld();
            Space.removeObject(Lady);
        }
        
        Actor Plane;
        Plane = getOneObjectAtOffset(0,0,Plane.class);
        if (Plane !=null)
        {
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(-1000);
            World Space;
            Space = getWorld();
            Space.removeObject(Plane);
        }
        
        Actor Baby;
        Baby = getOneObjectAtOffset(0,0,Baby.class);
        if (Baby !=null)
        {
            Space spaceWorld = (Space) getWorld();
            Score counter = spaceWorld.getScore();
            counter.bumpCount(-1000);
            World Space;
            Space = getWorld();
            Space.removeObject(Baby);
        }
    }
     public void notifyO(){
        for(Observer o : observers){
            if(o instanceof Score){
            o.ItotalCount(500);
            }
            else if(o instanceof Killed){
            o.ItotalCount(1);
            }
        }
    }
}   