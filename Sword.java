import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sword extends Weapon
{
    int direction, arc;
    
    Sword(int direction, Player owner)
    {
        super(7, owner);
        this.direction = direction;
        this.arc = 0;
        setRotation(direction);
    }
    
    public void act() 
    {
        turn(speed - 1);
        move(speed);
        arc += speed - 1;
        if(arc > 90)
        {
            owner.you.canMove = true;
            getWorld().removeObject(this);
        }
    }    
}