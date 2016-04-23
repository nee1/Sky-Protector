import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScreenPlay extends ScreenState
{
    ScreenStateManager screenPlaySSM; 
    
    public ScreenPlay(ScreenStateManager ssm) {
        super(ssm);
        screenPlaySSM = ssm;
    }
    
    @Override
    public void makeWorld(){
        System.out.println("for new space:");
        System.out.println("ssm object ScreenPlay: " + screenPlaySSM);
        Greenfoot.setWorld(new Space(screenPlaySSM));
    }
    
    @Override
    public void doPause(){
        System.out.println("DoPause of ScreenPlayState :: " + this.getClass().getName());
        ssm.setState("ScreenPause");
    }
    
    @Override
    public void doInitGame(){
        System.out.println("DoInitGame of ScreenPlayState :: " + this.getClass().getName());
        ssm.setState("ScreenInitGame");
    }
    
    @Override
    public void doGameOver(){
        System.out.println("DoGameOver of ScreenPlayState :: " + this.getClass().getName());
        ssm.setState("ScreenGameOver");
    }
    
    @Override
    public void doGameOver(SkyWorld skyworld){
        System.out.println("DoGameOver of ScreenPlayState :: " + this.getClass().getName());
        ssm.setState("ScreenGameOver");
    }
}
