import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SkyWorld extends World
{

    public ScreenStateManager ssm1;
    
    public SkyWorld(){
        super(1000, 600, 1); 
        ssm1 = new ScreenStateManager();
    }
    
    public SkyWorld(int worldWidth, int worldHeight, int cellSize, boolean bounded)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(worldWidth,worldHeight,cellSize,bounded);
        //ssm = new ScreenStateManager();
    }
    
    public SkyWorld(int worldWidth, int worldHeight, int cellSize)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(worldWidth,worldHeight,cellSize);
        //ssm = new ScreenStateManager();
    }

    //public ScreenStateManager getScreenStateManager(){
    //    return ssm1;
    //}
}
