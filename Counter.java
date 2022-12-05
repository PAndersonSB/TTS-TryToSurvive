import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class Counter extends Actor {
    private int score;

    public void act() {
        /**
         *  atc - metodo de atuar do greenfoot.
         */
        setImage(new GreenfootImage("Score: " + score, 40, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    public Counter() {
        setImage(new GreenfootImage("Score: " + score, 40, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    public int getScore(){
        /**
         * getScore - traz a pontuação dos jogadores
         * @return int score - pontuação dos jogadores
         */
        return this.score;
    }
    
    public void incrementScore(int valor){
        /**
         * incrementScore - metodo que incrementa a pontuação
         * @param int valor - valor a ser incrementado no score
         * @return void
         */
        this.score+= valor;
    }
    
}
