import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EntreLevels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntreLevels extends World
{

    /**
     * Constructor for objects of class EntreLevels.
     * 
     */
    protected Player playerOne ;
    protected Player playerTwo ;
    
    protected Counter counter;
    
    protected GreenfootSound backgroundMusic;
    protected GreenfootSound bossBackgroundMusic;
    
    public EntreLevels(Player playerOne , Player playerTwo, Counter counter )
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);
    }
}
