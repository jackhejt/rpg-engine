import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Weapon
{
    int direction;
    
    Bullet()
    {
        super(null);
        this.speed = 10;
        this.direction = 0;
    }
    
    Bullet(int speed, int direction, Player owner)
    {
        super(owner);
        this.speed = speed;
        this.direction = direction;
    }
    
    public void act() 
    {
        setRotation(direction);
        move(speed);
        collide();
        die();
    } 
    
    public void collide()
    {
        if(getX() < 1 && direction == 180)
        {
            destroy = true;
        }
        else if(getY() < 1 && direction == -90)
        {
            destroy = true;
        }
        else if(getY() > Area.AREAHEIGHT - 2 && direction == 90)
        {
            destroy = true;
        }
        else if(getX() > Area.AREAWIDTH - 2 && direction == 0)
        {
            destroy = true;
        }
    }
}
