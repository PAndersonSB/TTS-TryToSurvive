import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class Fantasma extends NonPlayerCharacter
{
    public Fantasma(){
        speed = 1;
        heart = new HeartBar(35,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/fantasma";
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
                    frame= "2";
                }
                timer +=1;
            }
            else{ //se movendo
                frame= "1";
                move();
                timer +=1;
            }
            heart.updateStatusBar(getX()-9,getY()-30);
            hitByShot();
            setImage(image+direcao+frame+".png");
        }
    }
    
}
