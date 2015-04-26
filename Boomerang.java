import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Boomerang extends Bullet
{
    int range, spin, currentRotation;
    boolean back;
    
    public Boomerang(int direction, Player owner)
    {
       super(8, direction, owner);
       range = 400;
       back = false;
       spin = 15;
       currentRotation = direction;
    }
    
    public void act() 
    {
        if(back)
        {
            turnTowards(owner.getX(), owner.getY());
        }
        else
        {
            setRotation(direction);
        }
        move(speed);
        range -= speed;
        currentRotation += spin;
        setRotation(currentRotation);
        if(currentRotation > 360)
        {
            currentRotation -= 360;
        }
        if(range <= 0)
        {
            back = true;
        }
        collide();
        die();
    } 
    
    public void collide()
    {
        Player hit = (Player) getOneIntersectingObject(Player.class);
        if(hit == owner && back)
        {
            owner.you.boomerang = true;
            destroy = true;
        }

        if(getX() < 1 && direction == 180)
        {
            back = true;
        }
        else if(getY() < 1 && direction == -90)
        {
            back = true;
        }
        else if(getY() > Area.AREAHEIGHT - 2 && direction == 90)
        {
            back = true;
        }
        else if(getX() > Area.AREAWIDTH - 2 && direction == 0)
        {
            back = true;
        }
    } 
}
