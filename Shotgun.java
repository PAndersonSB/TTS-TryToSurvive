import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public abstract class Shotgun extends Weapon
{

    
    public void shoot(String direction, int time){
        /**
         * shoot - verifica o tempo do ultimo tiro e se a arma esta em recarga e efetua 4 disparos
         * @param String direction - direção da arma
         * @param int time - tempo contador etc
         * @return void
         */
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
            
            GreenfootSound sound =  new GreenfootSound("shotgun.wav");
            sound.setVolume(70);
            sound.play();
        }
    }
}
