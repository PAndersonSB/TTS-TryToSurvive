import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class Level3 extends Levels
{

   /**
     * Constructor for objects of class Levels.
     * @param Player playerOne - jogador numero 1
     * @param Player playerTwo - jogador numero 2
     * @param Counter counter - contador que conta a pontuação dos players
     */
    public Level3(Player playerOne , Player playerTwo, Counter counter)
    {
        super(playerOne, playerTwo, counter);
        setBackground("backgroundLevelThree3.jpg");
        backgroundMusic = new GreenfootSound("soundtrack/Kusari Yarou.wav");
        bossBackgroundMusic = new GreenfootSound("soundtrack/Try Your Luck.wav");
        condicionalSpawnedBoss = counter.getScore() + 7;
    }
    
    public void nextLevel(){
        /**
     * metodo que faz a troca para o proximo level.
     * @return void
     */
        if(spawnedBoss && getObjects(NonPlayerCharacter.class).isEmpty()){
            backgroundMusic.stop();
            bossBackgroundMusic.stop();
            Greenfoot.setWorld(new WindowEndGame("WindowWin"));
        }
        else if(spawnedBoss && getObjects(NonPlayerCharacter.class).isEmpty() && volume > 0){
            transitionMusic = true;
            diminuindoVolume = true;
        }
    }
    
    public void spawnEnemy(int x, int y){
         /**
         * metodo que faz o spawn de inimigos no jogo.
         * @paran int x - posição em X do inimigo 
         * @param int y - posição em Y do inimigo
         * @return void
         */
        int randomSpawn = Greenfoot.getRandomNumber(2);
        switch (randomSpawn){
            case 0:
                addObject(new Anjo(), x, y);
                break;
            case 1:
                addObject(new Ave("pombo"), x, y);
                break;
            case 2:
                addObject(new Ave("pombo"), x, y);
                break;
        }
    }
    
    public void spawnBoss(int x, int y){
        /**
         * metodo que faz o spwan do boss no jogo.
         * @paran int x - posição em X do boss 
         * @param int y - posição em Y do boss
         * @return void
         */
        addObject(new Ave("corvo"), x, y);
        spawnedBoss = false;
    }
}
