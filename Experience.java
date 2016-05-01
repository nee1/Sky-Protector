import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the players experience throughout the game.
 * 
 * @author 
 */
public class Experience extends Actor
{
    private enum leveled{SAME, LEVELED};
    
    private static GreenfootImage xpFrame = new GreenfootImage("xpFrame.png"); 
    private static GreenfootImage xpBar = new GreenfootImage("xpBar.png");
    private GreenfootImage temp;

    private int xpCap = 100;
    private int currentXp = 0;

    private int frameWidth;
    
    private leveled state;

    /**
     * Default constructor
     */
    public Experience()
    {
        temp = new GreenfootImage("xpFrame.png");
        setImage(temp);

        frameWidth = xpFrame.getWidth();
        
        state = leveled.SAME;
    }

    /**
     * Checks to see if the players has leveled up or not.
     * 
     * @return True if a level up occured and false otherwise
     */
    public boolean levelUp()
    {
        if(state == leveled.LEVELED)
        {
            state = leveled.SAME;
            return true;
        }
        return false;
    }

    /**
     * Increases the players experience by a specified amount
     * 
     * @param exp The experience amount to be recieved
     */
    public void recieveExp(int exp)
    {  
        if(currentXp + exp >= xpCap)
        {
            currentXp = (currentXp + exp) - xpCap;
            xpCap += exp;
            state = leveled.LEVELED;
        }
        else    
            currentXp += exp;

        drawBar(exp);
    }
    
    /**
     * Set's the players experience to a specified amount
     * 
     * @param amount The amount to set the experience to
     */
    public void setExp(int amount)
    {
        if(amount <= xpCap)
            currentXp = amount;
            
        drawBar(1);
    }
    
    /**
     * Returns the current experience 
     * 
     * @return The current experience
     */
    public int exp()
    {
        return currentXp;
    }

    private void drawBar(int amount)
    {
        temp.clear();
        temp.drawImage(xpBar, (frameWidth / (xpCap/amount)) * (currentXp/amount) - frameWidth, 0);
        temp.drawImage(xpFrame, 0, 0);
    }
}
