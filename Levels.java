import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Levels extends World
{

    /**
     * Constructor for objects of class Levels.
     * 
     */
    protected Player playerOne ;
    protected Player playerTwo ;
    
    protected boolean spawnedBoss = false;
    protected int condicionalSpawnedBoss;
    
    protected Counter counter;
    
    protected int time=1;
    
    //music
    protected GreenfootSound backgroundMusic;
    protected GreenfootSound bossBackgroundMusic;
    
    protected int volume = 0;
    
    protected boolean transitionMusic = true;
    
    protected boolean diminuindoVolume = true;
    protected boolean aumentandoVolume = true;
    
    //
    protected int SpawnSpeed = 70; // Velocidade Spawn
    
    public Levels(Player playerOne , Player playerTwo, Counter counter )
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.counter = counter;
        
        addObject(playerOne ,490, 250);
        addObject(playerTwo ,510, 250);
        
        playerOne.resetTime();
        playerTwo.resetTime();
        
        addObject(counter ,500, 20);
        
    }
    
    public void act(){
        nextLevel();
        spawn();
        transitionMusic();
        time++;
    }
    
    public void incrementScore(int valor){
        counter.incrementScore(valor);
    }
    
    public void spawn(){
        if (counter.getScore() >= condicionalSpawnedBoss){//condicional para momento do boss.
            if(!spawnedBoss){
                spawnBoss(500,250);
                spawnedBoss = true;
                transitionMusic = true;
                diminuindoVolume = true;
                aumentandoVolume = true;
            }
        }else{
            if (time % SpawnSpeed == 0) {
                int randomSpawn = Greenfoot.getRandomNumber(8);
                switch (randomSpawn) {
                    case 0:
                        spawnEnemy(0, 0);
                        break;
                    case 1:
                        spawnEnemy(getWidth() / 2, 0);
                        break;
                    case 2:
                        spawnEnemy(getWidth(), 0);
                        break;
                    case 3:
                        spawnEnemy(0, getHeight() / 2);
                        break;
                    case 4:
                        spawnEnemy(getWidth(), getHeight());
                        break;
                    case 5:
                        spawnEnemy(0, getHeight());
                        break;
                    case 6:
                        spawnEnemy(getWidth() / 2, getHeight());
                        break;
                    case 7:
                        spawnEnemy(getWidth(), getHeight());
                        break;
                }
            }
        }
    }
    
    public abstract void spawnEnemy(int x, int y);
    public abstract void spawnBoss(int x, int y);
    
    public abstract void nextLevel();
    
    //music
    
    public void transitionMusic(){
        if(transitionMusic && time%10 == 0){ // se sim
            //abaixa o volume
            if(diminuindoVolume && volume > 0){
                transitionVolumeMusic(1);
            }
            else if(aumentandoVolume && volume < 20){
                diminuindoVolume = false;
                setBackgroundMusic();
                transitionVolumeMusic(-1);
            }
            else{
                aumentandoVolume = false;
                transitionMusic = false;
            }
        }
    }
    
    public void transitionVolumeMusic(int valor){
        volume-=valor;
        backgroundMusic.setVolume(volume);
    }
    
    public void setBackgroundMusic(){
        if (spawnedBoss){
            bossBackgroundMusic.playLoop();
            bossBackgroundMusic.setVolume(volume);
            backgroundMusic.stop();
        }
        else{
            backgroundMusic.playLoop();
            backgroundMusic.setVolume(volume);
            bossBackgroundMusic.stop();
        }
        
    }
    
    public void lose(){
        backgroundMusic.stop();
        bossBackgroundMusic.stop();
        Greenfoot.setWorld(new WindowEndGame("WindowLose"));
    }
}
