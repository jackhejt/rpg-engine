import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Town1 extends Area
{
    public Town1()
    {
        super(350, 350);
    }
    
    public Town1(PlayerData you)
    {
        super(350, 350, you);
    }
    
    public Town1(int x, int y)
    {
        super(x, y);
    }
    
    public Town1(int x, int y, PlayerData you)
    {
        super(x, y, you);
    }
    
    public void Setup()
    {
        addObject(new Penguin(), 100, 100);
    }
    
    public void North(int x, PlayerData you)
    {
        Greenfoot.setWorld(new Tile1(x, AREAHEIGHT, you));
    }
    
    public void South(int x, PlayerData you)
    {
        Greenfoot.setWorld(new Desert1(x, 1, you));
    }
    
    public void East(int y, PlayerData you) {}
    
    public void West(int y, PlayerData you)
    {
        Greenfoot.setWorld(new Town2(AREAWIDTH, y, you));
    }
    
    public void CombatChance(PlayerData you) {}
}
