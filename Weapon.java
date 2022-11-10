import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Weapon extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        if (timer == 0){
            createDependencies();
        }
        timer++;
    }
    
    public void createDependencies(){
        World world = getWorld();
        world.addObject(rechargeBar, getX(), getY());
    }
    
    public void resetTime(){
        registroShoot = 0;
        timer=0;
    }
    
    public int getPeso(){
        return this.peso;
    }
    
    public void updateWeapon(int x,int y,String direction){
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
