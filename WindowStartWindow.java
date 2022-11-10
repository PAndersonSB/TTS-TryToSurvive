import java.lang.System.Logger.Level;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class WindowStartWindow extends World { 

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
