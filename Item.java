import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Item extends Actor
{
    boolean destroy;
    
    public Item()
    {
        this.destroy = false;
    }
    
    public void die()
    {
        if(destroy)
        {
            getWorld().removeObject(this);
        }
    }
}
