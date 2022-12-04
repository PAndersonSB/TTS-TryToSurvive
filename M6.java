import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class M6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class M6 extends Rifle
{
    /**
     * Act - do whatever the M6 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public M6(){
        image = "1";
        fireRate = 8;
        peso = 1;
        rechargeBar = new RechargeBar(30,"/rechargeBar/");
    }
}
