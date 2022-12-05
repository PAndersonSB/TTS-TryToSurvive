import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public abstract class Rifle extends Weapon
{
    
    public void shoot(String direction, int time){
        /**
         * shoot - verifica o tempo do ultimo tiro e se a arma esta em recarga e efetua o disparo
         * @param String direction - direção da arma
         * @param int time - tempo contador etc
         * @return void
         */
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
