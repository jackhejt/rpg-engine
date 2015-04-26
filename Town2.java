import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Town2 extends Area
{
    public Town2()
    {
        super(350, 350);
    }
    
    public Town2(int x, int y)
    {
        super(x, y);
    }
    
    public Town2(int x, int y, PlayerData you)
    {
        super(x, y, you);
    }
    
    public void North(int x, PlayerData you) {}
    
    public void South(int x, PlayerData you)
    {
        Greenfoot.setWorld(new Desert2(x, 1, you));
    }
    
    public void East(int y, PlayerData you)
    {
        Greenfoot.setWorld(new Town1(1, y, you));
    }
    
    public void West(int y, PlayerData you) {}
    
    public void CombatChance(PlayerData you) {}
}