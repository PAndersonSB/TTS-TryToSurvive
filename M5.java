import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class M5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class M5 extends Rifle
{
    /**
     * Act - do whatever the M5 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public M5(){
        image = "1";
        fireRate = 12;
        peso = 1;
        rechargeBar = new RechargeBar(30,"/rechargeBar/");
    }
}
