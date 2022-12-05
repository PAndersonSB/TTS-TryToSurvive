import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Anjo here.
 * 
 * @author Anderson Silva Brito
 * @version 1
 */
public class Anjo extends NonPlayerCharacter
{
    public Anjo() {
        speed = 1;
        heart = new HeartBar(20,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/anjo";
        this.direcao = "L";
        this.frame = "1";
        setImage(image + direcao + frame + ".png");
    }
    
    public void act() {
        /**
         *  atc - metodo de atuar do greenfoot.
         */
        if(timer == 0){
            setPlayerAlvo();
            timer +=1;
        }
        else{
            if (timer%2 == 0 || sendoObservado() ){ //parado
                if(sendoObservado()){
                    frame = "2";
                    atack();
                }
                timer +=1;
            }
            else{ //se movendo
                frame = "1";
                move();
                timer +=1;
            }
            heart.updateStatusBar(getX()-9,getY()-30);
            hitByShot();
            setImage(image+direcao+frame+".png");
        }
    }

    public void atack(){
        /**
         * atack - efetua um ataque a cada N segundos
         * @return void
         */
        World world = getWorld();
        
        if(timer%70 == 0){
            if (direcao == "R") {
            world.addObject(new EnemyAtaque("bala0",getX(),getY(),10, 0), getX() + 25, getY() + 10);
            } 
                
            if (direcao == "L") {
                world.addObject(new EnemyAtaque("bala0",getX(),getY(),-10, 0), getX() - 25, getY() + 10);
            }
        }

    }
}
