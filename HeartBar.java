import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class HeartBar extends StatusBar
{
    /**
     * HeartBar - construtor
     * @param int quantidadeAtual - valor atual do objeto
     * @param String diretorio - diretorio da imagem a ser usada
     */
    public void act()
    {
        /**
         *  atc - metodo de atuar do greenfoot.
         */
        if(quantidadeAtual<=0){
            World world = getWorld();
            world.removeObject(this);
        }
    }
    
    public HeartBar(int quantidadeAtual,String diretorio){
        super(quantidadeAtual, diretorio);
        this.image = diretorio+"99.png";
    }
    
    public void updateImage(){
        /**
         * updateImage - muda a imagem do objeto
         * @return void
         */
        //imageTemporaria= new GreenfootImage("vida: " + quantidadeAtual, 40, Color.BLACK, new Color(0, 0, 0, 0));
        float condicional = quantidadeAtual * 100  / quantidadeInicial;
        if(condicional > 66){
            if(condicional > 88){
                image = diretorio+"99.png";
            }
            else if (condicional > 77){
                image = diretorio+"88.png";
            }else{
                image = diretorio+"77.png";
            }
            
        }
        else if (condicional > 33){
            if(condicional > 55){
                image = diretorio+"66.png";
            }
            else if (condicional > 44){
                image = diretorio+"55.png";
            }
            else{
                image = diretorio+"44.png";
            }
            
        }
        else{
            if(condicional > 22){
                image = diretorio+"33.png";
            }            
            else if(condicional > 11){
                image = diretorio+"22.png";
            }
            else{
                image = diretorio+"11.png";
            }
        }
    }
}
