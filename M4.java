import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class m4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class M4 extends Rifle
{
    /**
     * Act - do whatever the m4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public M4(){
        image = "1";
        fireRate = 15;
        peso = 1;
        rechargeBar = new RechargeBar(30,"/rechargeBar/");
    }
}
