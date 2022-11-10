import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectIconPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectIconPlayer extends Actor
{
    /**
     * Act - do whatever the SelectIconPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private String moveLeft;
    private String moveRight;
    
    private int icone;
    
    private int timer=1;
    private boolean wait = false;
    
    public void act()
    {
        touching();
        
        if(wait){
            if (timer >10){
                wait = false;
                timer = 1;
            }
            else{
                timer++;
            }
        }else{
            move();
        }
    }
    
    public SelectIconPlayer(int valor){
        setImage( new GreenfootImage("P" + valor, 34, Color.ORANGE, new Color(0, 0, 0, 0)));
        
        if(valor ==1){
            this.moveLeft = "a";
            this.moveRight = "d";
        }else{
            this.moveLeft = "left";
            this.moveRight = "right";
        }
    }
    
    public int getIcone(){
        return icone;
    }
    
    public void move(){
        
        if (Greenfoot.isKeyDown(moveLeft)){
            
            if(getX()-200 > 199){
                
                setLocation(getX()-200,getY());
                wait= true;
                
                if (isTouching(SelectIconPlayer.class)){
                    if(getX()==800){
                        setLocation(600,getY());
                    }
                    else if(getX()==200){
                        setLocation(400,getY());
                    }
                    else{
                        setLocation(getX()-200,getY());
                    }
                }
                
            }
        }
        
        if (Greenfoot.isKeyDown(moveRight)){
            
            if(getX()+200 < 801){
                
                setLocation(getX()+200,getY());
                wait= true;
                
                 if (isTouching(SelectIconPlayer.class)){
                    if(getX()==800){
                        setLocation(600,getY());
                    }
                    else if(getX()==200){
                        setLocation(400,getY());
                    }
                    else{
                        setLocation(getX()+200,getY());
                    }
                }
            }
            
        }
        
    }
    
    public void touching(){
        if (isTouching(IconPlayer.class)){
            IconPlayer iconePlayer = getIntersectingObjects(IconPlayer.class).get(0);
            
            this.icone = iconePlayer.getIcone();
        }
        
    }
}
