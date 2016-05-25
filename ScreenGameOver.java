import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScreenGameOver extends ScreenState
{
    public ScreenStateManager screenGameOverSSM;
    public ScreenGameOver(ScreenStateManager ssm) {
        super(ssm);
        screenGameOverSSM = ssm;
    }
    
    @Override
    public void doPlay(){
        System.out.println("PlayGame of ScreenGameOverState :: " + this.getClass().getName());
        ssm.setState("ScreenPlay");
    }
    
    @Override
    public void makeWorld(SkyWorld skyworld){
        
        //System.out.println("getWorld in ScreenGameOver : " + (Space)getWorld());
        GameOverScreen gameOverScreen = new GameOverScreen(screenGameOverSSM,skyworld);
        skyworld.addObject(gameOverScreen,skyworld.getWidth()/2,skyworld.getHeight()/2);
    }
}
