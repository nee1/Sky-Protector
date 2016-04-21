import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueShoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedShoot extends Actor implements ShootStrategy
{
       public Mover shootBullet(Rocket r){
           
           Bullet b = new Bullet(r.getRotation());
           return b;
        }
}
