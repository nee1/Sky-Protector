/**
 * Write a description of class PlayGameCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayGameCommand implements BtCommand
{
    Receiver playGameReceiver;
    
    public void setReceiver(Receiver newReceiver)
    {
        this.playGameReceiver = newReceiver;
    }
    
    public void executeCommand()
    {
        playGameReceiver.performAction();
    }
}

