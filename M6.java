import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class M6 extends Rifle
{
    public M6(){
        image = "1";
        fireRate = 8;
        peso = 1;
        rechargeBar = new RechargeBar(30,"/rechargeBar/");
    }
}
