import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WindowEndGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WindowEndGame extends World
{

    /**
     * Constructor for objects of class WindowEndGame.
     * 
     */
    private Button sair= new Button("sair.png");
    private Button reniciar= new Button("reniciar.png");
    
    public WindowEndGame(String image)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);
        setBackground("windows/"+image+".png");
        addObject(reniciar,500,310);
        addObject(sair,500,380);
    }
    
    public void act(){
         if (Greenfoot.mouseClicked(sair)){
            Greenfoot.stop();
        }
        if (Greenfoot.mouseClicked(reniciar)){
           Greenfoot.setWorld(new WindowStartWindow() );
        }
    }
}
