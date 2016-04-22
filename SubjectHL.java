/**
 * Write a description of class SubjectHL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface SubjectHL  
{
    public void attach(ObserverHL o);
    public void notifyO(int amount,ObserverHL o);
}
