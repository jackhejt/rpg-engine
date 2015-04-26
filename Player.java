import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    PlayerData you;
    
    Player()
    {
        you = new PlayerData();
    }
    
    Player(PlayerData you)
    {
        this.you = you;
        you.boomerang = true;
    }
    
    public void act()
    {
        you.currentArea = (Area) getWorld();
        if(you.canMove)
        {
            control();
        }
        redraw();
    }
    
    public void redraw()
    {
        if(you.aniTimer > 500)
        {
            you.aniTimer = 0;
        }
        switch(you.animation)
        {
        case 0:
            if(you.walk)
            {
                if(you.aniTimer > 0)
                {
                    switch(you.direction)
                    {
                    case 90:
                        setImage("playerdownwalk1.png");
                        break;
                    case -90:
                        setImage("playerupwalk1.png");
                        break;
                    case 180:
                        setImage("playerleftwalk1.png");
                        break;
                    case 0:
                        setImage("playerrightwalk1.png");
                        break;
                    
                    }
                }
                else
                {
                    switch(you.direction)
                    {
                    case 90:
                        setImage("playerdownwalk2.png");
                        break;
                    case -90:
                        setImage("playerupwalk2.png");
                        break;
                    case 180:
                        setImage("playerleftwalk2.png");
                        break;
                    case 0:
                        setImage("playerrightwalk2.png");
                        break;
                    
                    }
                }
                if(you.aniTimer < you.WALKANISPEED)
                {
                    you.aniTimer++;
                }
                else
                {
                    you.aniTimer = -you.WALKANISPEED;
                }
            }
            else
            {
                switch(you.direction)
                {
                case 90:
                    setImage("playerdown.png");
                    break;
                case -90:
                    setImage("playerup.png");
                    break;
                case 180:
                    setImage("playerleft.png");
                    break;
                case 0:
                    setImage("playerright.png");
                    break;
                
                }
            }
            break;
        default:
            setImage("placeholder.png");
            break;
        }
    }
    
    public void moveArea(int direction)
    {
        if(getY() >= Area.AREAHEIGHT - 1 && direction == 2)
        {
            you.currentArea.South(getX(), you);
        }
        else if(getY() <= 1 && direction == 1)
        {
            you.currentArea.North(getX(), you);
        }
        else if(getX() <= 1 && direction == 4)
        {
            you.currentArea.West(getY(), you);
        }
        else if(getX() >= Area.AREAWIDTH - 1 && direction == 3)
        {
            you.currentArea.East(getY(), you);
        }
    }
    
    public void control()
    {
        if(Greenfoot.isKeyDown(you.up))
        {
            setLocation(getX(), getY()-you.speed);
            you.currentArea.CombatChance(you);
            moveArea(1);
            you.upD = true;
            you.walk = true;
            you.direction = -90;
        }
        else if(!Greenfoot.isKeyDown(you.up))
        {
            you.upD = false;
        }
        if(Greenfoot.isKeyDown(you.down))
        {
            setLocation(getX(), getY()+you.speed);
            you.currentArea.CombatChance(you);
            moveArea(2);
            you.downD = true;
            you.walk = true;
            you.direction = 90;
        }
        else if(!Greenfoot.isKeyDown(you.down))
        {
            you.downD = false;
        }
        if(Greenfoot.isKeyDown(you.right))
        {
            setLocation(getX()+you.speed, getY());
            you.currentArea.CombatChance(you);
            moveArea(3);
            you.rightD = true;
            you.walk = true;
            you.direction = 0;
        }
        else if(!Greenfoot.isKeyDown(you.right))
        {
            you.rightD = false;
        }
        if(Greenfoot.isKeyDown(you.left))
        {
            setLocation(getX()-you.speed, getY());
            you.currentArea.CombatChance(you);
            moveArea(4);
            you.leftD = true;
            you.walk = true;
            you.direction = 180;
        }
        else if(!Greenfoot.isKeyDown(you.left))
        {
            you.leftD = false;
        }
        if(
        
        (!Greenfoot.isKeyDown(you.up) && !Greenfoot.isKeyDown(you.down) && !Greenfoot.isKeyDown(you.left) && !Greenfoot.isKeyDown(you.right)) ||
        
        (Greenfoot.isKeyDown(you.up) && Greenfoot.isKeyDown(you.down) && !Greenfoot.isKeyDown(you.left) && !Greenfoot.isKeyDown(you.right)) ||
        
        (!Greenfoot.isKeyDown(you.up) && !Greenfoot.isKeyDown(you.down) && Greenfoot.isKeyDown(you.left) && Greenfoot.isKeyDown(you.right)) ||
        
        (Greenfoot.isKeyDown(you.up) && Greenfoot.isKeyDown(you.down) && Greenfoot.isKeyDown(you.left) && Greenfoot.isKeyDown(you.right))
        
                )
        {
            you.walk = false;
            you.aniTimer = 0;
        }
        if(Greenfoot.isKeyDown(you.b1) && !you.b1D)
        {
            you.b1D = true;
            useWeapon(you.b1Item);
        }
        else if(!Greenfoot.isKeyDown(you.b1))
        {
            you.b1D = false;
        }
        if(Greenfoot.isKeyDown(you.b2)  && !you.b2D)
        {
            you.b2D = true;
            useWeapon(you.b2Item);
        }
        else if(!Greenfoot.isKeyDown(you.b2))
        {
            you.b2D = false;
        }
        if(Greenfoot.isKeyDown(you.m) && !you.mD)
        {
            you.mD = true;
            Greenfoot.setWorld(new Items(you));
        }
        else if(!Greenfoot.isKeyDown(you.m))
        {
            you.mD = false;
        }
    }
    
    public void useWeapon(String weapon)
    {
        if(weapon.equals("boomerang"))
        {
            boomerang();
        }
        else if(weapon.equals("arrow"))
        {
            arrow();
        }
        else if(weapon.equals("sword"))
        {
            sword();
        }
        else if(weapon.equals("bomb"))
        {
            bomb();
        }
    }
    
    public void boomerang()
    {
        if(you.boomerang)
        {
            getWorld().addObject(new Boomerang(you.direction, this), getX(), getY());
            you.boomerang = false;
        }
    }
    
    public void arrow()
    {
        if(you.arrows > 0)
        {
            getWorld().addObject(new Arrow(you.direction, this), getX(), getY());
            you.arrows--;
        }
    }
    
    public void bomb()
    {
        if(you.bombs > 0)
        {
            getWorld().addObject(new Bomb(this), getX(), getY());
            you.bombs--;
        }
    }
    
    public void sword()
    {
        you.canMove = false;
        you.walk = false;
        switch(you.direction)
        {
        case(0):
            getWorld().addObject(new Sword(0, this), getX(), getY() - 56);
            break;
        case(90):
            getWorld().addObject(new Sword(90, this), getX() + 56, getY());
            break;
        case(180):
            getWorld().addObject(new Sword(180, this), getX(), getY() + 56);
            break;
        case(-90):
            getWorld().addObject(new Sword(-90, this), getX() - 56, getY());
            break;
        }
    }
}
