import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public abstract class Attack extends Actor
{
    protected int damage;

    protected int x;
    protected int y;
    
    protected int directionX;
    protected int directionY;
        
    public void act()
    {
        /**
         *  atc - metodo de atuar do greenfoot.
         */
        moveAttack();
        deadAttack();
    }
    
    public int getDamage(){
        /**
         * getDamage - traz quanto de dano dar esse attack
         * @return int damage - dano do ataque
         */
        return damage;
    }
    
    public void moveAttack(){
        /**
         * moveAttack - faz com que o objeto attack se mova na tela
         * @return void
         */
        setLocation(getX() + directionX, getY() + directionY);
        
    }
    
    public void deadAttack() {
        /**
         * deadAttack - conforme os parametros setados verifica e da fim a este attack
         * @return void
         */
        World world = getWorld();
        
        if (this.getX() >= world.getWidth()-1 || this.getX() <= 1 || this.getY() >= world.getHeight()-1 || this.getY() <= 1 || (directionX == 0 && directionY ==0)) {
            getWorld().removeObject(this);
        }
    }
    
    //public abstract void attack();
    
    //public abstract void moveBullet();
    
}
