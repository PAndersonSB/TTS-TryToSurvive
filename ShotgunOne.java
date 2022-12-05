import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class ShotgunOne extends Shotgun
{
    public ShotgunOne(){
        image = "3";
        fireRate = 100;
        peso = 1;
        rechargeBar = new RechargeBar(24,"/rechargeBar/");
    }
}
