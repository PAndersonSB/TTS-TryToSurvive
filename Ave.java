import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ave extends NonPlayerCharacter
{
    /**
     * Act - do whatever the Ave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ave(String nome) {
        speed = 1;
        heart = new HeartBar(30,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/"+nome;
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
