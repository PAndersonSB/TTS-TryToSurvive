import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Attack extends Actor
{
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int damage;

    protected int x;
    protected int y;
    
    protected int directionX;
    protected int directionY;
        
    public void act()
    {
        moveAttack();
        deadAttack();
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void moveAttack(){
        setLocation(getX() + directionX, getY() + directionY);
        
    }
    
    public void deadAttack() {
        World world = getWorld();
        
        if (this.getX() >= world.getWidth()-1 || this.getX() <= 1 || this.getY() >= world.getHeight()-1 || this.getY() <= 1 || (directionX == 0 && directionY ==0)) {
            getWorld().removeObject(this);
        }
    }
    
    //public abstract void attack();
    
    //public abstract void moveBullet();
    
}
