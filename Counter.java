import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Counter extends Actor {
    private int score;

    public void act() {
        setImage(new GreenfootImage("Score: " + score, 40, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    public Counter() {
        setImage(new GreenfootImage("Score: " + score, 40, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void incrementScore(int valor){
        this.score+= valor;
    }
    
}
