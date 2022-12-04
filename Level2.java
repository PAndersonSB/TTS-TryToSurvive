import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Levels
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2(Player playerOne , Player playerTwo, Counter counter)
    {
        super(playerOne,playerTwo,counter);
        setBackground("backgroundLevelTwo.jpg");
        backgroundMusic = new GreenfootSound("soundtrack/Kusari Yarou.wav");
        bossBackgroundMusic = new GreenfootSound("soundtrack/Try Your Luck.wav");
        condicionalSpawnedBoss = counter.getScore() + 15;//15;
    }
    
    public void nextLevel(){
        if(spawnedBoss && getObjects(NonPlayerCharacter.class).isEmpty()){
            //Greenfoot.setWorld(new EntreLevels(2,playerOne,playerTwo,counter));
            Greenfoot.setWorld(new Level3(playerOne, playerTwo, counter));
        }
    }
    
    public void spawnEnemy(int x, int y){
        int randomSpawn = Greenfoot.getRandomNumber(3);
        switch (randomSpawn){
            case 0:
                addObject(new Fantasma(), x, y);
                break;
            case 1:
                addObject(new Esqueleto(), x, y);
                break;
            case 2:
                addObject(new Cachorro(30), x, y);
                break;
        }
    }
    
    public void spawnBoss(int x, int y){
        addObject(new BossInferno(), x, y);
        spawnedBoss = false;
    }
}
