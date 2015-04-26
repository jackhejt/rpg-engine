import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Desert2 extends Area
{
    
    public Desert2()
    {
        super(350, 350);
    }
    
    public Desert2(int x, int y)
    {
        super(x, y);
    }
    
    public Desert2(int x, int y, PlayerData you)
    {
        super(x, y, you);
    }
    
    public void Setup()
    {
        addObject(new Mushroom(), 100, 500);
    }
    
    public void North(int x, PlayerData you)
    {
        Greenfoot.setWorld(new Town2(x, AREAHEIGHT, you));
    }
    
    public void South(int x, PlayerData you) {}
    
    public void East(int y, PlayerData you)
    {
        Greenfoot.setWorld(new Desert1(1, y, you));
    }
    
    public void West(int y, PlayerData you) {}
    
    public void CombatChance(PlayerData you)
    {
        you.combatTimer++;
    }
}
