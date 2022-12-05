import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class EnemyAtaque extends Attack
{
    /**
     * EnemyAtaque - construtor
     * String nomeImage - nome da imagem do attack
     * int x - posição inicial em X
     * int y - posição inicial em Y
     * int directionX - valor X que o attack ira se mover na tela
     * int directionY - valor Y que o attack ira se mover na tela
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
