import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rifleBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RifleBullet extends Attack
{
    /**
     * Act - do whatever the rifleBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public RifleBullet(int x, int y,int directionX,int directionY ){
        this.x= x;
        this.y= y;
    
        this.directionX= directionX;
        this.directionY= directionY;
        this.damage = 10;
        
        setImage("bala0.png");
    } 
    
    
}
