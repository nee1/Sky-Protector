import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScreenPause extends ScreenState  
{
    
    public ScreenPause(ScreenStateManager ssm) {
        super(ssm);
    }
   
    @Override
    public void doInitGame(){
        System.out.println("DoInitGame of ScreenPauseState");
        ssm.setState("ScreenInitGame");
    }
    
     @Override
    public void doPlay(){
        System.out.println("DoPlay of ScreenPauseState");
        ssm.setState("ScreenPlay");
    }
    
    @Override
    public void makeWorld(){
    
    }
}
