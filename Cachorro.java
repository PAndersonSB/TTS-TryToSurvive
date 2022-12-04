import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cachorro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cachorro extends NonPlayerCharacter
{
    /**
     * Act - do whatever the Cachorro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Cachorro(int vida) {
        speed = 1;
        heart = new HeartBar(500,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/cachorro";
        this.direcao = "L";
        this.frame = "1";
        setImage(image + direcao + frame + ".png");
    }
    
    public void animacao(){
        //ordemDeAnimacao;// se true crescente , se false decrescente
        if (timer%15 == 0){
            if(frame =="2"){
                if(ordemDeAnimacao){
                    frame = "3";
                }
                else{
                    frame = "1";
                }
            }
            else if(frame =="3"){
                if(ordemDeAnimacao){
                    frame = "4";
                }
                else{
                    frame = "2";
                }
            }
            else if(frame == "4"){
                ordemDeAnimacao = false;
                frame = "2";
            }
            else{
                ordemDeAnimacao = true;
                frame = "2";
            }
        }
        
        
    }
}
