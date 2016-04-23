public interface ScreenMachineState  
{
    public void doPause();
    public void doInitGame();
    public void doGameOver();
    public void doGameOver(SkyWorld s);
    public void doPlay();
    public void makeWorld();
    public void makeWorld(SkyWorld s);
}
