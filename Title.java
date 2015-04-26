import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Title extends MenuScreen
{
    Font titleFont;
    
    int menuPosition, numOptions;
    
    public Title()
    {
        super(new PlayerData());
        
        menuPosition = 0;
        numOptions = 4;
        
        menuImage = new GreenfootImage(700, 700);
        menuBackgroundColor = new Color(0, 255, 220, 255);
        menuFont = new Font("Arial", Font.PLAIN, 18);
        titleFont = new Font("Arial", Font.BOLD, 120);
        
        menuImage.setColor(menuBackgroundColor);
        menuImage.fill();
        menuImage.setFont(titleFont);
        menuImage.setColor(Color.BLACK);
        menuImage.drawString("THE GAME", 40, 200);
        menuImage.setFont(menuFont);
        menuImage.drawString("New Game", 300, 400);
        menuImage.drawString("Load Game", 300, 450);
        menuImage.drawString("Credits", 300, 500);
        menuImage.drawString("Quit", 300, 550);
        menuActive = new GreenfootImage(menuImage);
        
        redraw();
        
    }
    
    public void act()
    {
        control();
    }
    
    public void redraw()
    {
        menuActive = new GreenfootImage(menuImage);
        
        menuActive.setColor(Color.RED);
        menuActive.drawRect(295, 380 + (50 * menuPosition), 120, 40);
        
        setBackground(menuActive);
    }
    
    public void b1()
    {
        switch(menuPosition)
        {
        case(0):
            Greenfoot.setWorld(new Town1(you));
            break;
        default:
            System.out.println("ERROR!");
            break;
        }
    }
    
    public void b2() {}
    
    public void m()
    {
        b1();
    }
    
    public void down()
    {
        if(menuPosition < numOptions - 1)
        {
            menuPosition++;
            redraw();
        }
    }
    
    public void up()
    {
        if(menuPosition > 0)
        {
            menuPosition--;
            redraw();
        }
    }
    
}
