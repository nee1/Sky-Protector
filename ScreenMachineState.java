public interface ScreenMachineState  
{
    public void doPause();
    public void doInitGame();
    public void doGameOver();
    public void doGameOver(Space s);
    public void doPlay();
    public void makeWorld();
    public void makeworld(Space s);
}
