import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startSelectionFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWindowFire extends Actor
{
    /**
     * Act - do whatever the startSelectionFire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int indentificador = 1;
    private int timer = 0;
    public void act()
    {
        animate();
        timer++;
    }
    
    public StartWindowFire(){
        setImage("/fire/fire"+ indentificador +".png");
    }
    public void animate(){
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
