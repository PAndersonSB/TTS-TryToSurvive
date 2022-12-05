import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public abstract class Weapon extends Actor
{
    //protected Attack attack;
    protected String image;
    protected int peso;
    
    protected int registroShoot = 0;
    protected int fireRate;
    
    protected String soundEfect;
    
    protected RechargeBar rechargeBar;
    
    protected int timer=0;
    
    public void act()
    {
         /**
         *  atc - metodo de atuar do greenfoot.
         */
        if (timer == 0){
            createDependencies();
        }
        timer++;
    }
    
    public void createDependencies(){
        /**
         * createDependencies - cria as dependencias no jogo
         * @return void
         */
        World world = getWorld();
        world.addObject(rechargeBar, getX(), getY());
    }
    
    public void resetTime(){
        /**
         * resetTime - reinicia o timer deste objeto
         * @return void
         */
        registroShoot = 0;
        timer=0;
    }
    
    public int getPeso(){
        /**
         * getPeso - retorna o peso da arma
         * @return int peso
         */
        return this.peso;
    }
    
    public void updateWeapon(int x,int y,String direction){
        /**
         * updateWeapon - atualiza a posição deste objeto
         * @param int x - posição em X no jogo 
         * @param int y - posição em Y no jogo
         * @param String direction - direção em que o esta o player
         * @return void
         */
        rechargeBar.updateStatusBar(x, y);
        
        if (direction == "left"){   
            setImage("weapon/"+ image +"-3.png");
            setLocation(x, y+7);
        }
        if (direction == "right"){
            setImage("weapon/"+image+"-1.png");
            setLocation(x, y+7);
        }
        if (direction== "down"){
            setImage("weapon/"+image+"-4.png");
            setLocation(x, y);
        }
        if (direction== "up"){
            setImage("weapon/"+image+"-2.png");
            setLocation(x, y);
        }
    }
    
    public abstract void shoot(String direction,int time);  
    
}
