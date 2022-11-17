import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Rifle extends Weapon
{
    /**
     * Act - do whatever the Rifle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void shoot(String direction, int time){
        World world = getWorld();
        
        if(registroShoot + fireRate <= time && !rechargeBar.getRecharge() ){//validação de fire rate 
            registroShoot = time;
            rechargeBar.lose(1);
            
            if (direction == "right") {
                world.addObject(new RifleBullet(getX(),getY(),10, 0), getX() + 25, getY() + 10);
            } 
            
            if (direction == "left") {
                world.addObject(new RifleBullet(getX(),getY(),-10, 0), getX() - 25, getY() + 10);
            } 
            
            if (direction == "up") {
                world.addObject(new RifleBullet(getX(),getY(),0, -10), getX() + 14, getY() - 17);
            } 
            
            if (direction == "down") {
                world.addObject(new RifleBullet(getX(),getY(),0, 10), getX() - 9, getY() + 20);
            }
            GreenfootSound sound =  new GreenfootSound("rifle.wav");
            sound.setVolume(55);
            sound.play();
        }
    }
}
