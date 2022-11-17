import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Esqueleto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Esqueleto extends NonPlayerCharacter
{
    /**
     * Act - do whatever the Esqueleto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Esqueleto() {
        speed = 1;
        heart = new HeartBar(20,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/esqueleto";
        this.direcao = "L";
        this.frame = "1";
        setImage(image + direcao + frame + ".png");
    }
}
