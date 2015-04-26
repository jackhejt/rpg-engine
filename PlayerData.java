import greenfoot.*;

public class PlayerData  
{
    Area currentArea;
    
    String name;
    
    String up, down, left, right, b1, b2, m;
    
    boolean upD, downD, leftD, rightD, b1D, b2D, mD;
    
    int speed;
    
    int hpMax, hpCurrent;
    
    int money;
    
    int menuPosition, numMenuItems;
    
    int combatTimer;
    
    int direction;
    
    boolean walk;
    
    int animation, aniTimer;
    
    final int WALKANISPEED = 15;
    
    boolean canMove;
    
    // ITEMS
    boolean boomerang;
    int arrows, arrowsMax;
    int bombs, bombsMax;
    
    String[] items;
    String b1Item, b2Item;
    
    public PlayerData()
    {
        // CONTROLS
        this.up = "up";
        this.down = "down";
        this.left = "left";
        this.right = "right";
        this.b1 = "z";
        this.b2 = "x";
        this.m = "space";
        // CONTROL BOOLEANS
        this.upD = false;
        this.downD = false;
        this.leftD = false;
        this.rightD = false;
        this.b1D = false;
        this.b2D = false;
        this.mD = false;
        
        //PLAYER SPEED
        this.speed = 5;
        
        // PLAYER STATS
        this.name = "Boring Guy";
        
        this.money = 0;
        
        // ITEMS
        this.boomerang = true;
        this.arrows = 20;
        this.arrowsMax = arrows;
        this.bombs = 10;
        this.bombsMax = arrows;
        
        this.items = new String[14];
        
        for(int x = 0; x < items.length; x++)
        {
            this.items[x] = "";
        }
        
        this.b1Item = "sword";
        this.b2Item = "arrow";
        
        this.items[0] = "boomerang";
        this.items[3] = "bomb";
        
        // MENU STUFF
        this.menuPosition = 0;
        this.numMenuItems = 14;
        
        // ANIMATION STUFF
        this.walk = false;
        this.animation = 0;
        this.direction = 90;
        this.aniTimer = 0;
        
        this.canMove = true;
        
        // RANDOM COMBAT?
        this.combatTimer = 0;
    }
}
