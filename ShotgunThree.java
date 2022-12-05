import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class ShotgunThree extends Shotgun
{
    public ShotgunThree(){
        image = "3";
        fireRate = 50;
        peso = 1;
        rechargeBar = new RechargeBar(32,"/rechargeBar/");
    }
}
