import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class ShotgunTwo extends Shotgun
{
    public ShotgunTwo(){
        image = "3";
        fireRate = 80;
        peso = 1;
        rechargeBar = new RechargeBar(28,"/rechargeBar/");
    }
}
