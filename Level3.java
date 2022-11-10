import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends Levels
{

    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3(Player playerOne , Player playerTwo, Counter counter)
    {
        super(playerOne, playerTwo, counter);
        setBackground("backgroundLevelThree.jpg");
        backgroundMusic = new GreenfootSound("soundtrack/Kusari Yarou.wav");
        bossBackgroundMusic = new GreenfootSound("soundtrack/Try Your Luck.wav");
        condicionalSpawnedBoss = counter.getScore() + 15;
    }
    
    public void nextLevel(){
        if(spawnedBoss && getObjects(NonPlayerCharacter.class).isEmpty()){
            //Greenfoot.setWorld(new Level2(playerOne, playerTwo));
            Greenfoot.stop();
        }
    }
    
    public void spawnEnemy(int x, int y){
        addObject(new Zombie(), x, y);
    }
    
    public void spawnBoss(int x, int y){
        addObject(new Zombie(), x, y);
        spawnedBoss = false;
    }
}
