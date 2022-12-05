import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class StartWindowFire extends Actor
{
    private int indentificador = 1;
    private int timer = 0;
    
    public void act()
    {
        /**
         *  atc - metodo de atuar do greenfoot.
         */
        animate();
        timer++;
    }
    
    public StartWindowFire(){
        setImage("/fire/fire"+ indentificador +".png");
    }
    public void animate(){
        /**
         * animate - metodo que usa o timer para mudar os frames e dar sensação de movimento ao objeto
         * @return - void
         */
        if (timer%5== 0){
            if (indentificador>10){
                indentificador=1;
                setImage("/fire/fire"+ indentificador +".png");
                indentificador++;
            }
            else{
                setImage("/fire/fire"+ indentificador +".png");
                indentificador++;
            }   
        }
    }
}
