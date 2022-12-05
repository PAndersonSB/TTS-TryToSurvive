import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class M4 extends Rifle
{  
    public M4(){
        image = "1";
        fireRate = 15;
        peso = 1;
        rechargeBar = new RechargeBar(30,"/rechargeBar/");
    }
}
