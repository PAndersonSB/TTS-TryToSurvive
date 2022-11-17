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
        setBackground("backgroundLevelThree3.jpg");
        backgroundMusic = new GreenfootSound("soundtrack/Kusari Yarou.wav");
        bossBackgroundMusic = new GreenfootSound("soundtrack/Try Your Luck.wav");
        condicionalSpawnedBoss = counter.getScore() + 15;
    }
    
    public void nextLevel(){
        if(spawnedBoss && getObjects(NonPlayerCharacter.class).isEmpty()){
            backgroundMusic.stop();
            bossBackgroundMusic.stop();
            Greenfoot.setWorld(new WindowEndGame("WindowWin"));
        }
    }
    
    public void spawnEnemy(int x, int y){
        int randomSpawn = Greenfoot.getRandomNumber(2);
        switch (randomSpawn){
            case 0:
                addObject(new Anjo(), x, y);
                break;
            case 1:
                addObject(new Ave("pombo"), x, y);
                break;
            case 2:
                addObject(new Ave("corvo"), x, y);
                break;
        }
    }
    
    public void spawnBoss(int x, int y){
        addObject(new Ave("corvo"), x, y);
        spawnedBoss = false;
    }
}
