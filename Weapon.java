import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Weapon extends Item
{
   int speed;
   Player owner;
   
   Weapon(Player owner)
   {
       this.speed = 0;
       this.owner = owner;
   }
   
   Weapon(int speed, Player owner)
   {
       this.speed = speed;
       this.owner = owner;
   }
}
