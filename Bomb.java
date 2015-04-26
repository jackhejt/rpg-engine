import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bomb extends Weapon
{
    int wick;
    
    static final int EXPLOSIONFRAMES = 14;
    
    GreenfootImage bomb, bombFlash;
    
    Bomb(Player owner)
    {
        super(0, owner);
        this.wick = 200;
        this.bomb = new GreenfootImage("bomb.png");
        this.bombFlash = new GreenfootImage("bombflash.png");
    }
    
    public void act()
    {
        if(!destroy)
        {
            wick--;
            animate();
        }
        else
        {
            die();
        }
    }
    
    public void animate()
    {
        if(wick < 50 && wick % 5 == 0)
        {
            setImage(bombFlash);
        }
        else if(wick % 22 == 0)
        {
            setImage(bombFlash);
        }
        else if(wick < 1)
        {
            destroy = true;
            wick = 0;
        }
        else
        {
            setImage(bomb);
        }
    }
    
    public void die()
    {
        getWorld().setPaintOrder(Bomb.class, Player.class);
        setImage(new GreenfootImage("explosion/"+ wick + ".gif"));
        wick++;
        if(wick > Bomb.EXPLOSIONFRAMES)
        {
            getWorld().setPaintOrder(Player.class);
            getWorld().removeObject(this);
        }
    }
}
