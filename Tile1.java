import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tile1 extends Area
{
    public Tile1(PlayerData you)
    {
        super(350, 350, you);
    }
    
    public Tile1(int x, int y)
    {
        super(x, y);
    }
    
    public Tile1(int x, int y, PlayerData you)
    {
        super(x, y, you);
    }
    
    public void North(int x, PlayerData you) {}
    
    public void South(int x, PlayerData you)
    {
        Greenfoot.setWorld(new Town1(x, 1, you));
    }
    
    public void East(int y, PlayerData you)
    {
        Greenfoot.setWorld(new Town3(0, y, you));
    }
    
    public void West(int y, PlayerData you)
    {
    }
    
    public void CombatChance(PlayerData you)
    {
        you.combatTimer += 3;
    }
}
