import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shotgun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Shotgun extends Weapon
{
    /**
     * Act - do whatever the Shotgun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void shoot(String direction, int time){
        World world = getWorld();
        
        if(registroShoot + fireRate <= time && !rechargeBar.getRecharge() ){
            registroShoot = time;
            rechargeBar.lose(4);
            
            if (direction == "right") { //velocidade - posição inicial
                world.addObject(new ShotgunBullet(getX(),getY(), 8, -4) , getX() + 25, getY() + 0);
                world.addObject(new ShotgunBullet(getX(),getY(),10, -2) , getX() + 25, getY() + 5);
                world.addObject(new ShotgunBullet(getX(),getY(),10,  2) , getX() + 25, getY() + 10);
                world.addObject(new ShotgunBullet(getX(),getY(), 8,  4) , getX() + 25, getY() + 15);
            } 
            
            if (direction == "left") {
                world.addObject(new ShotgunBullet(getX(),getY(), -8, -4) , getX() - 25, getY() + 0);
                world.addObject(new ShotgunBullet(getX(),getY(),-10, -2) , getX() - 25, getY() + 5);
                world.addObject(new ShotgunBullet(getX(),getY(),-10,  2) , getX() - 25, getY() + 10);
                world.addObject(new ShotgunBullet(getX(),getY(), -8,  4) , getX() - 25, getY() + 15);
                
            } 
            
            if (direction == "up") {
                world.addObject(new ShotgunBullet(getX(),getY(),-4,  -8) , getX() , getY() - 17);
                world.addObject(new ShotgunBullet(getX(),getY(),-2, -10) , getX() , getY() - 17);
                world.addObject(new ShotgunBullet(getX(),getY(), 2, -10) , getX() , getY() - 17);
                world.addObject(new ShotgunBullet(getX(),getY(), 4,  -8) , getX() , getY() - 17);
            } 
            
            if (direction == "down") {
                world.addObject(new ShotgunBullet(getX(),getY(),-4,  8) , getX() , getY() + 20);
                world.addObject(new ShotgunBullet(getX(),getY(),-2, 10) , getX() , getY() + 20);
                world.addObject(new ShotgunBullet(getX(),getY(), 2, 10) , getX() , getY() + 20);
                world.addObject(new ShotgunBullet(getX(),getY(), 4,  8) , getX() , getY() + 20);
            }
        }
    }
}
