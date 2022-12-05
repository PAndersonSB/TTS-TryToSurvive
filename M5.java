import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class M5 extends Rifle
{
    public M5(){
        image = "1";
        fireRate = 12;
        peso = 1;
        rechargeBar = new RechargeBar(30,"/rechargeBar/");
    }
}
