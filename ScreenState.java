public class ScreenState implements ScreenMachineState
{
    ScreenStateManager ssm;
    public ScreenState(ScreenStateManager ssmTemp){
        ssm = ssmTemp;
    }

    public void doPause(){
        System.out.println("DoPause of ScreenState :: " + this.getClass().getName());
    }
    
    public void doInitGame(){
        System.out.println("DoNewGame of ScreenState :: " + this.getClass().getName());
    }
    
    public void doGameOver(){
        System.out.println("DoGameOver of ScreenState :: " + this.getClass().getName());
    }
    
    public void doGameOver(Space spaceWorld){
        System.out.println("DoGameOver of ScreenState :: " + this.getClass().getName());
    }
    
    public void doPlay(){
        System.out.println("DoPlay of ScreenState :: " + this.getClass().getName());
    }
    
    public void makeWorld(){
    }
    
    public void makeworld(Space s){
    }
}
