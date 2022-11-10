import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IconPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IconPlayer extends Actor
{
    /**
     * Act - do whatever the IconPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int icone;
    
    public void act()
    {
        touching();
    }
    
    public IconPlayer(int icone){
        this.icone = icone;
        setImage("/actorArt/art0"+icone+".png");
    }
    
    public int getIcone(){
        return icone;
    }
    
    public void touching(){
        if (isTouching(SelectIconPlayer.class)){
            setImage("/actorArt/art0"+(icone+4)+".png");
        }
        else{
            setImage("/actorArt/art0"+icone+".png");
        }
    }
}
