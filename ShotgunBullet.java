import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShotgunBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShotgunBullet extends Attack
{
    /**
     * Act - do whatever the ShotgunBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int time = 1;
    
    public ShotgunBullet(int x, int y,int directionX,int directionY ){
        this.x= x;
        this.y= y;
    
        this.directionX= directionX;
        this.directionY= directionY;
        this.damage = 7;
        
        setImage("bala0.png");
    }
    
    public void moveAttack(){
        setLocation(getX() + directionX, getY() + directionY);
        
        time++;
        if(time%3 == 0){
            
            if (directionX > 0){
                directionX -=1;
            }
            else if (directionX < 0){
                directionX +=1;
            }
        
            if(directionY >0){
                directionY -=1;
            }else if(directionY <0){
                directionY +=1;
            }
        }
        
    }
}
