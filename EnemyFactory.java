/**
 * Write a description of class EnemyFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyFactory  
{
   
    public EnemyFactory()
    {
    }

    public EnemyClass makeEnemyFactory(int enemyType)  
    {
        EnemyClass enemyClass = null;
        
         if(enemyType == 0)
        {
            enemyClass = new Enemy();
            
        }
        
        else if(enemyType == 1)
        {
            enemyClass = new Rock2();
        }
        
        else if(enemyType == 2)
        {
           enemyClass = new Rock();  
        }
        
        else if(enemyType == 3)
        {
           enemyClass = new Bee();  
        }
        
        else if(enemyType == 4)
        {
           enemyClass = new Fly();  
        }
        
        else if(enemyType == 5)
        {
           enemyClass = new Spider();  
        }
        
        else if(enemyType == 6)
        {
           enemyClass = new Lady();  
        }
        
   
        else if(enemyType == 7)
        {
           enemyClass = new Baby();  
        }
        
        
        return enemyClass;
        
    }
}
