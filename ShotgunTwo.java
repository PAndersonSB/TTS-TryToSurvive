import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShotgunTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShotgunTwo extends Shotgun
{
    /**
     * Act - do whatever the ShotgunTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ShotgunTwo(){
        image = "3";
        fireRate = 80;
        peso = 1;
        rechargeBar = new RechargeBar(28,"/rechargeBar/");
    }
}
