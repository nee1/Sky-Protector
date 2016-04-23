import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScreenInitGame extends ScreenState
{
   ScreenStateManager sss1;
   public ScreenInitGame(ScreenStateManager ssm){
       super(ssm);
       sss1 = ssm;
    }
    
    @Override
    public void doPlay(){
        System.out.println("DoPlay of ScreenInitState :: " + this.getClass().getName());
        ssm.setState("ScreenPlay");
    }
    
    @Override
    public void makeWorld(){
        System.out.println("in ScreenInitGame makeWorld");
        Greenfoot.setWorld(new InitialScreen(sss1));
    }
}
