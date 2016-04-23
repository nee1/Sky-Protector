import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScreenGameOver extends ScreenState
{
    public ScreenStateManager screenGameOverSSM;
    public ScreenGameOver(ScreenStateManager ssm) {
        super(ssm);
        screenGameOverSSM = ssm;
    }
    
    @Override
    public void doInitGame(){
        System.out.println("InitGame of ScreenGameOverState :: " + this.getClass().getName());
        ssm.setState("ScreenInitGame");
    }
    
    @Override
    public void makeworld(Space skyworld){
        
        //System.out.println("getWorld in ScreenGameOver : " + (Space)getWorld());
        GameOverScreen gameOverScreen = new GameOverScreen(screenGameOverSSM);
    }
}
