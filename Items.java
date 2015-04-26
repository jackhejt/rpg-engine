import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Items extends MenuScreen
{
    public Items(PlayerData you)
    {    
        super(you);
        
        menuImage = new GreenfootImage(800, 800);
        menuBackgroundColor = new Color(0, 255, 220, 255);
        menuFont = new Font("Arial", Font.PLAIN, 18);
        
        menuImage.setFont(menuFont);
        menuImage.setColor(menuBackgroundColor);
        menuImage.fill();
        
        menuImage.setColor(Color.BLACK);
        
        menuImage.fillRect(5, 5, 390, 790);
        menuImage.fillRect(405, 5, 390, 790);
        
        menuImage.setColor(menuBackgroundColor);
        
        menuImage.fillRect(8, 8, 384, 85);
        menuImage.fillRect(8, 95, 384, 696);
        menuImage.fillRect(408, 8, 384, 784);
        
        redraw();
    }
    
    public void redraw()
    {
        menuActive = new GreenfootImage(menuImage);
        
        // ITEM DRAW
        
        for(int x = 0; x < you.items.length; x++)
        {
            if(!you.items[x].equals(""))
            {
                if(x % 2 == 0)
                {
                    menuActive.drawImage(new GreenfootImage("menu/" + you.items[x] + ".png"), 15, 100 + (50 * x));
                    if(hasAmountItem(you.items[x]))
                    {
                        menuActive.drawImage(amountDraw(amountOfItem(you.items[x], you)), 15, 100 + (50 * x));
                    }
                }
                else
                {
                    menuActive.drawImage(new GreenfootImage("menu/" + you.items[x] + ".png"), 195, 100 + (50 * (x - 1)));
                    if(hasAmountItem(you.items[x]))
                    {
                        menuActive.drawImage(amountDraw(amountOfItem(you.items[x], you)), 195, 100 + (50 * (x - 1)));
                    }
                }
            }
        }
        
        if(!you.b1Item.equals(""))
        {
            menuActive.drawImage(new GreenfootImage("menu/" + you.b1Item + ".png"), 10, 10);
            if(hasAmountItem(you.b1Item))
            {
                menuActive.drawImage(amountDraw(amountOfItem(you.b1Item, you)), 10, 10);
            }
        }
        if(!you.b2Item.equals(""))
        {
            menuActive.drawImage(new GreenfootImage("menu/" + you.b2Item + ".png"), 210, 10);
            if(hasAmountItem(you.b2Item))
            {
                menuActive.drawImage(amountDraw(amountOfItem(you.b2Item, you)), 210, 10);
            }
        }
        
        // CURSOR DRAW
        menuActive.setColor(Color.RED);
        if(you.menuPosition % 2 == 0)
        {
            menuActive.drawRect(15, 100 + (50 * you.menuPosition), 180, 80);
        }
        else
        {
            menuActive.drawRect(195, 100 + (50 * (you.menuPosition - 1)), 180, 80);
        }
        
        setBackground(menuActive);
    }
    
    public void b1()
    {
        String swap = you.b1Item;
        you.b1Item = you.items[you.menuPosition];
        you.items[you.menuPosition] = swap;
        redraw();
    }
    
    public void b2()
    {
        String swap = you.b2Item;
        you.b2Item = you.items[you.menuPosition];
        you.items[you.menuPosition] = swap;
        redraw();
    }
    
    public void m()
    {
        Greenfoot.setWorld(you.currentArea);
    }
    
    public void down()
    {
        you.menuPosition += 2;
        positionFix();
        redraw();
    }
    
    public void up()
    {
        you.menuPosition -= 2;
        positionFix();
        redraw();
    }
}