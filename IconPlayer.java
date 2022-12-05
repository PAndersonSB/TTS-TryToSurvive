import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class IconPlayer extends Actor
{
    /**
     * IconPlayer -  construtor
     * @param int icone - numeração do icone do player
     */
    private int icone;
    
    public void act()
    {
        /**
         *  atc - metodo de atuar do greenfoot.
         */
        touching();
    }
    
    public IconPlayer(int icone){
        this.icone = icone;
        setImage("/actorArt/art0"+icone+".png");
    }
    
    public int getIcone(){
        /**
         * getIcone - retorna o valor do icone deste objeto
         * @return icone - icone deste objeto
         */
        return icone;
    }
    
    public void touching(){
        /**
         * touching - verifica se esta em contato com SelectIconPlayer.class
         */
        if (isTouching(SelectIconPlayer.class)){
            setImage("/actorArt/art0"+(icone+4)+".png");
        }
        else{
            setImage("/actorArt/art0"+icone+".png");
        }
    }
}
