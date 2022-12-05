import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class Ave extends NonPlayerCharacter
{
    /**
     * Ave - construtor
     * @param String nome - nome da imagem a ser usada
     * 
     */
    public Ave(String nome) {
        speed = 1;
        if (nome == "corvo"){
            heart = new HeartBar(500,"heart/"); 
        }
        else{
            heart = new HeartBar(30,"heart/"); 
        }
        
        this.damage = 1;
        this.image = "npc/"+nome;
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
