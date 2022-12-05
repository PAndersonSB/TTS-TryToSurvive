import java.lang.System.Logger.Level;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */

public class WindowStartWindow extends World { 
    /**
     * Constructor for objects of class WindowStartWindow.
     */

    private GreenfootSound backgroundMusic = new GreenfootSound("soundtrack/THE BADDEST.wav"); //"soundtrack/Bones.wav"
    private int c=1;
    
    public WindowStartWindow() {
        super(1000, 500, 1);
        setBackground("windows/StartWindow.png");
        backgroundMusic.play();
        backgroundMusic.setVolume(20);
        addObject(new StartWindowFire(), 500,250);

    }
    
    public void act() {
        /**
         * metodo atuar do greenfoot.
         * @return void
         */
        c++;
        if (Greenfoot.isKeyDown("enter") || Greenfoot.mouseClicked(null)){
            //Greenfoot.setWorld(new WindowSelectActor(backgroundMusic) );
            Greenfoot.setWorld(new WindowOptions(backgroundMusic) );
        }
        
        if (c>390){
            c=1;
        }
        backGround();
        // uns extras quem sabe...
    }

    public void backGround(){
        /**
         * metodo que muda o background da tela conforme o numero do contador.
         * @return void
         */
        if(c< 330){
            setBackground("windows/StartWindow.png");
        }
        else if (c<350){
            setBackground("windows/StartWindowBlur.png");
        }
        else{
            setBackground("windows/TryToSurvive.png");
        }
    }
}
