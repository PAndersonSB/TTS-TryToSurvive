import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RecoverLife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecoverLife extends NonPlayerCharacter
{
    /**
     * Act - do whatever the RecoverLife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public RecoverLife(){
        damage = -10; //damage negativo com o intuito de curar o jogador;
        setImage("bala0.png");
        speed = 3;
    }
    
    public void act()
    {
        if(timer == 0){
            setPlayerAlvo();
        }
        else{
            move();
        }
        timer +=1;
        
    }
    
    public int getDamage(){
        World world = getWorld();
        world.removeObject(this);
        
        return this.damage;
    }
    
    public void setPlayerAlvo(){
        World world = getWorld();
        Player playerOne = world.getObjects(Player.class).get(0);
        Player playerTwo = world.getObjects(Player.class).get(1);
        
        if (playerOne.getHeart() < playerTwo.getHeart()){
            this.playerAlvo = playerOne;
        }
        else{
            this.playerAlvo = playerTwo;
        }
        
    }
}
