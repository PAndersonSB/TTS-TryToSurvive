import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fantasma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fantasma extends NonPlayerCharacter
{
    /**
     * Act - do whatever the Fantasma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
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
