import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Levels
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    
    public Level1(Player playerOne , Player playerTwo , Counter counter)
    {
        super(playerOne, playerTwo, counter);
        
        setBackground("backgroundLevelOne.jpg");
        backgroundMusic = new GreenfootSound("soundtrack/Kusari Yarou.wav");
        bossBackgroundMusic = new GreenfootSound("soundtrack/Try Your Luck.wav");
        condicionalSpawnedBoss = 15;
    }
    
    public void nextLevel(){
        if(spawnedBoss && getObjects(NonPlayerCharacter.class).isEmpty() && volume == 0){
            bossBackgroundMusic.stop();
            //Greenfoot.setWorld(new EntreLevels(1,playerOne,playerTwo,counter));
            Greenfoot.setWorld(new Level2(playerOne, playerTwo,counter));
        }
        else if(spawnedBoss && getObjects(NonPlayerCharacter.class).isEmpty() && volume > 0){
            transitionMusic = true;
            diminuindoVolume = true;
        }
        //diminui musica e para a musica
    }
    
    public void spawnEnemy(int x, int y){
        int randomSpawn = Greenfoot.getRandomNumber(1);
        switch (randomSpawn){
            case 0:
                addObject(new Zombie(), x, y);
                break;
        }
    }
    
    public void spawnBoss(int x, int y){
        addObject(new Cachorro(1000), getWidth() / 2, 0);
        spawnedBoss = false;
    }
    
}
