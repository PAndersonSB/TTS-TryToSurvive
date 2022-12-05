import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class Level2 extends Levels
{

    /**
     * Constructor for objects of class Levels.
     * @param Player playerOne - jogador numero 1
     * @param Player playerTwo - jogador numero 2
     * @param Counter counter - contador que conta a pontuação dos players
     */
    public Level2(Player playerOne , Player playerTwo, Counter counter)
    {
        super(playerOne,playerTwo,counter);
        setBackground("backgroundLevelTwo.jpg");
        backgroundMusic = new GreenfootSound("soundtrack/Requiem Aranea inferno.wav");
        bossBackgroundMusic = new GreenfootSound("soundtrack/Gyakujuuji no Otoko infernoBoss.wav");
        condicionalSpawnedBoss = counter.getScore() + 7;//15;
    }
    
    public void nextLevel(){
        /**
     * metodo que faz a troca para o proximo level.
     * @return void
     */
        if(spawnedBoss && getObjects(NonPlayerCharacter.class).isEmpty()){
            //Greenfoot.setWorld(new EntreLevels(2,playerOne,playerTwo,counter));
            Greenfoot.setWorld(new Level3(playerOne, playerTwo, counter));
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
        /**
         * metodo que faz o spwan do boss no jogo.
         * @paran int x - posição em X do boss 
         * @param int y - posição em Y do boss
         * @return void
         */
        addObject(new BossInferno(), x, y);
        spawnedBoss = false;
    }
}
