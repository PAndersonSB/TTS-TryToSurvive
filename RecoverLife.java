import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class RecoverLife extends NonPlayerCharacter
{   
    public RecoverLife(){
        damage = -10; //damage negativo com o intuito de curar o jogador;
        setImage("bala0.png");
        speed = 3;
    }
    
    public void act()
    {
         /**
         *  atc - metodo de atuar do greenfoot.
         */
        if(timer == 0){
            setPlayerAlvo();
        }
        else{
            move();
        }
        timer +=1;
        
    }
    
    public int getDamage(){
        /**
         * getDamage - retorna o dano deste objeto
         * @return int damage
         */
        World world = getWorld();
        world.removeObject(this);
        
        return this.damage;
    }
    
    public void setPlayerAlvo(){
        /**
         * setPlayerAlvo - marca um jogador como alvo
         * @return void
         */
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
