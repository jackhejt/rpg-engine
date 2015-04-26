import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Area extends World
{
    static final int AREAWIDTH = 800;
    static final int AREAHEIGHT = 800;
    
    Player me;
    
    GreenfootImage paint;
    
    public Area(int x, int y)
    {    
        super(AREAWIDTH, AREAHEIGHT, 1);
        me = new Player();
        addObject(me, x, y);
        paint = new GreenfootImage(getBackground());
        setPaintOrder(Player.class);
        Setup();
    }
    
    public Area(int x, int y, PlayerData you)
    {    
        super(AREAWIDTH, AREAHEIGHT, 1);
        me = new Player(you);
        addObject(me, x, y);
        paint = new GreenfootImage(getBackground());
        setPaintOrder(Player.class);
        Setup();
    }
    
    public void North(int x, PlayerData you) {}
    
    public void South(int x, PlayerData you) {}
    
    public void East(int y, PlayerData you) {}
    
    public void West(int y, PlayerData you) {}
    
    public void Setup() {}
    
    public void CombatChance(PlayerData you) {}
}
