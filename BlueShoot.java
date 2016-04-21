import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueShoot extends Actor implements ShootStrategy
{
   public Mover shootBullet(Rocket r){
           
           Shot s = new Shot(r.getRotation());
           return s;
        }    
}
