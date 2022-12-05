import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class Cachorro extends NonPlayerCharacter
{
    /**
     * Cachorro - construtor
     * @param int vida - vida deste inimigo
     */    
    public Cachorro(int vida) {
        speed = 1;
        heart = new HeartBar(vida,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/cachorro";
        this.direcao = "L";
        this.frame = "1";
        setImage(image + direcao + frame + ".png");
    }
    
    public void animacao(){
        /**
         * animacao - muda o frame do objeto para dar uma impressão de movimento a cada N segundos
         * @return void
         */
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
