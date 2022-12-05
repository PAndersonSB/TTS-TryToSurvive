import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class RifleBullet extends Attack
{
    /**
     * RifleBullet - construtor
     * int x - posição inicial em X
     * int y - posição inicial em Y
     * int directionX - valor X que o attack ira se mover na tela
     * int directionY - valor Y que o attack ira se mover na tela
     */
    
    public RifleBullet(int x, int y,int directionX,int directionY ){
        this.x= x;
        this.y= y;
    
        this.directionX= directionX;
        this.directionY= directionY;
        this.damage = 8;
        
        setImage("bala0.png");
    } 
    
    
}
