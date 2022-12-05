import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class Zombie extends NonPlayerCharacter
{  
    public Zombie() {
        speed = 1;
        heart = new HeartBar(20,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/zumbi";
        this.direcao = "L";
        this.frame = "1";
        setImage(image + direcao + frame + ".png");
    }
    
}
