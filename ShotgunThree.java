import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShotgunThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShotgunThree extends Shotgun
{
    /**
     * Act - do whatever the ShotgunThree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ShotgunThree(){
        image = "3";
        fireRate = 50;
        peso = 1;
        rechargeBar = new RechargeBar(32,"/rechargeBar/");
    }
}
