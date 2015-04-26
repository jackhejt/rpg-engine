import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Desert1 extends Area
{
    public Desert1()
    {
        super(350, 350);
    }
    
    public Desert1(int x, int y)
    {
        super(x, y);
    }
    
    public Desert1(int x, int y, PlayerData you)
    {
        super(x, y, you);
    }
    
    public void North(int x, PlayerData you)
    {
        Greenfoot.setWorld(new Town1(x, AREAHEIGHT, you));
    }
    
    public void South(int x, PlayerData you) {}
    
    public void East(int y, PlayerData you) {}
    
    public void West(int y, PlayerData you)
    {
        Greenfoot.setWorld(new Desert2(AREAWIDTH, y, you));
    }
    
    public void CombatChance(PlayerData you)
    {
        you.combatTimer++;
    }
}