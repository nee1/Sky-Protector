/**
 * Vector - This class was written as a utility class for Greenfoot scenarios.
 * 
 * This class represents a 2-dimensional vector. 
 * 
 * The vector can be used to deal with movement information (speed and
 * direction) of actors. An actor can store a vector, and then other vectors 
 * can be added to modify the current velocity and direction.
 * 
 * @author Poul Henriksen
 * @author Michael Kolling
 * 
 * @version 1.1 (July 2007)
 */
public class Vector
{
    double dx = 0;
    double dy = 0;
    int direction = 0;
    double length;
    
    public Vector()
    {
    }

    public Vector(int direction, double length)
    {
        this.length = length;
        this.direction = direction;
        updateCartesian();
    }

    //     public Vector(Location start, Location end)
    //     {
    //         dx = end.getX() - start.getX();
    //         dy = end.getY() - start.getY();
    //         updatePolar();
    //     }

    /**
     * Set the direction of this vector.
     */
    public void setDirection(int direction) {
        this.direction = direction;
        updateCartesian();
    }
   
    /**
     * Add other vector to this vector.
     */
    public void add(Vector other) {
        dx += other.dx;
        dy += other.dy;
        updatePolar();
    }
    
    public void reduceLength(double d) {
        length = length - d;
        updateCartesian();
    }
  }
