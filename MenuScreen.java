import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class MenuScreen extends World
{
    PlayerData you;
    
    GreenfootImage menuImage, menuActive;
    
    Color menuBackgroundColor;
    
    static Font menuFont;
    final static Font amountFont = new Font("Arial", Font.PLAIN, 12);

    public MenuScreen(PlayerData you)
    {    
        super(800, 800, 1);
        this.you = you;
    }
    
    public void redraw() {};
    
    public void act()
    {
        control();
    }
    
    public void control()
    {
        if(Greenfoot.isKeyDown(you.b1) && !you.b1D)
        {
            you.b1D = true;
            b1();
        }
        else if(!Greenfoot.isKeyDown(you.b1))
        {
            you.b1D = false;
        }
        if(Greenfoot.isKeyDown(you.b2) && !you.b2D)
        {
            you.b2D = true;
            b2();
        }
        else if(!Greenfoot.isKeyDown(you.b2))
        {
            you.b2D = false;
        }
        if(Greenfoot.isKeyDown(you.m) && !you.mD)
        {
            you.mD = true;
            m();
        }
        else if(!Greenfoot.isKeyDown(you.m))
        {
            you.mD = false;
        }
        if(Greenfoot.isKeyDown(you.down) && !you.downD)
        {
            you.downD = true;
            down();
        }
        else if(!Greenfoot.isKeyDown(you.down))
        {
            you.downD = false;
        }
        if(Greenfoot.isKeyDown(you.up) && !you.upD)
        {
            you.upD = true;
            up();
        }
        else if(!Greenfoot.isKeyDown(you.up))
        {
            you.upD = false;
        }
        if(Greenfoot.isKeyDown(you.left) && !you.leftD)
        {
            you.leftD = true;
            left();
        }
        else if(!Greenfoot.isKeyDown(you.left))
        {
            you.leftD = false;
        }
        if(Greenfoot.isKeyDown(you.right) && !you.rightD)
        {
            you.rightD = true;
            right();
        }
        else if(!Greenfoot.isKeyDown(you.right))
        {
            you.rightD = false;
        }
    }
    
    public void b1() {}
    
    public void b2() {}
    
    public void m() {}
    
    public void down()
    {
        you.menuPosition++;
        positionFix();
        redraw();
    }
    
    public void up()
    {
        you.menuPosition--;
        positionFix();
        redraw();
    }
    
    public void left()
    {
        you.menuPosition--;
        positionFix();
        redraw();
    }
    
    public void right()
    {
        you.menuPosition++;
        positionFix();
        redraw();
    }
    
    public void positionFix()
    {
        if(you.menuPosition >= you.numMenuItems)
        {
            you.menuPosition -= you.numMenuItems;
        }
        else if(you.menuPosition < 0)
        {
            you.menuPosition += you.numMenuItems;
        }
    }
    
    static GreenfootImage amountDraw(int amount)
    {
        GreenfootImage image = new GreenfootImage(180, 80);
        image.setFont(amountFont);
        image.drawString("x " + amount, 150, 70);
        return image;
    }
    
    static boolean hasAmountItem(String item)
    {
        if(item.equals("bomb") || item.equals("arrow"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    static int amountOfItem(String item, PlayerData you)
    {
        if(item.equals("bomb"))
        {
            return you.bombs;
        }
        else if(item.equals("arrow"))
        {
            return you.arrows;
        }
        else
        {
            return 0;
        }
    }
}
