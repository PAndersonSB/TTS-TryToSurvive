import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyAtaque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyAtaque extends Attack
{
    /**
     * Act - do whatever the EnemyAtaque wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public EnemyAtaque(String nomeImage,int x, int y,int directionX,int directionY ){
        this.x= x;
        this.y= y;
    
        this.directionX= directionX;
        this.directionY= directionY;
        this.damage = 10;
        
        setImage(nomeImage+".png");
    }
}
