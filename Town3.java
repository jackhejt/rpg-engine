import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Town3 extends Area
{
    public Town3(PlayerData you)
    {
        super(350, 350, you);
    }
    
    public Town3(int x, int y)
    {
        super(x, y);
    }
    
    public Town3(int x, int y, PlayerData you)
    {
        super(x, y, you);
    }
    
    public void Setup()
    {
        addObject(new Penguin(), 100, 100);
    }
    
    public void North(int x, PlayerData you) {}
    
    public void South(int x, PlayerData you) {}
    
    public void East(int y, PlayerData you) {}
    
    public void West(int y, PlayerData you)
    {
        Greenfoot.setWorld(new Tile1(AREAWIDTH, y, you));
    }
    
    public void CombatChance(PlayerData you) {}
}
