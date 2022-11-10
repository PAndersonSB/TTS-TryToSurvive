import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShotgunOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShotgunOne extends Shotgun
{
    /**
     * Act - do whatever the ShotgunOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public ShotgunOne(){
        image = "3";
        fireRate = 100;
        peso = 1;
        rechargeBar = new RechargeBar(24,"/rechargeBar/");
    }
}
