/**
 * Write a description of class HelpCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpCommand implements BtCommand
{
    Receiver helpReceiver;
    
    public void setReceiver(Receiver newReceiver)
    {
        this.helpReceiver = newReceiver;
    }
    
    public void executeCommand()
    {
        helpReceiver.performAction();
    }
}
