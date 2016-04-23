public class ScreenStateManager  
{
    ScreenMachineState currentState;
    ScreenMachineState playState;
    ScreenMachineState pauseState;
    ScreenMachineState gameOverState;
    ScreenMachineState initGameState;
    SkyWorld skywrld;
    
    public ScreenStateManager() {
        playState = new ScreenPlay(this);
        gameOverState = new ScreenGameOver(this);
        pauseState = new ScreenPause(this);
        initGameState = new ScreenInitGame(this);
        currentState = initGameState;
        currentState.makeWorld();
    }  
    
    public void doPause(){
        System.out.println("DoPause of ScreenStateManager :: " + this.getClass().getName());
        currentState.doPause();
    }
    
    public void doInitGame(){
        System.out.println("DoNewGame of ScreenStateManager :: " + this.getClass().getName());
        currentState.doInitGame();        
    }
    
    public void doGameOver(){
        System.out.println("DoGameOver of ScreenStateManager :: " + this.getClass().getName());
        currentState.doGameOver();
    }
    
    public void doGameOver(SkyWorld sworld){
        System.out.println("DoGameOver of ScreenStateManager :: " + this.getClass().getName());
        skywrld = sworld;
        currentState.doGameOver();
    }
    
    public void doPlay(){
        System.out.println("DoPlay of ScreenStateManager :: " + this.getClass().getName());
        currentState.doPlay();
    }
    
    public void setState(String nextState) {
        
        switch(nextState){
           case "ScreenPause": 
           currentState = pauseState;
           break;
           case "ScreenPlay": 
           currentState = playState;
           break;
           case "ScreenGameOver": 
           currentState = gameOverState;
           break;
           case "ScreenInitGame": 
           currentState = initGameState;
           break;
           default:
           break;
        }
        System.out.println("screen state manager makeworld");
        if(nextState == "ScreenGameOver"){
            currentState.makeWorld(skywrld);
        }
        else{
            currentState.makeWorld();
        }
        
    }
    
    public String showState(){
        return currentState.getClass().getName();
    }
}
