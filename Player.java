import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class Player extends Actor {
    /**
     * Player - construtor
     * @param String moveDown - botão para mover para baixo
     * @param String moveUp - botão para mover para cima
     * @param String moveLeft - botão para mover para esquerda
     * @param String moveRight - botão para mover para direita 
     * @param String shootButton - botão para atirar 
     * @param int playerAppearance - numero da skin do jogador
     * @param Weapon weapon - arma do jogador
     */
    private int time;
    private int velocidade=3;
    
    private String direction ="right"; // Direção do personagem
    private String moveDown;
    private String moveUp;
    private String moveLeft;
    private String moveRight;
    private String shootButton;
    
    private int playerAppearance;
    
    //dependencias 
    private HeartBar heart = new HeartBar(999999999,"heart/");
    private Weapon weapon; //new ShotgunOne();//new M4();
    //private Weapon secondaryWeapon = new Hand()

    public void act() {
        /**
         *  atc - metodo de atuar do greenfoot.
         */
        if (time == 0){
            createDependencies();
        }
        time++;
        movePlayer();
        shoot();
        takeDamage();
        
        weapon.updateWeapon(getX() ,getY(),direction );
        heart.updateStatusBar(getX()-9,getY()-30);
    }

    // Construtor Pirncipal
    public Player(String moveDown, String moveUp, String moveLeft, String moveRight, String shootButton,
            int playerAppearance , Weapon weapon) {
        this.moveDown = moveDown;
        this.moveUp = moveUp;
        this.moveLeft = moveLeft;
        this.moveRight = moveRight;
        this.shootButton = shootButton;
        this.playerAppearance = playerAppearance;
        this.weapon = weapon;
    }
    
    public String getShootButton(){
        /**
         * getShootButton - retorna o valor do botão de atirar
         * @return String shootButton
         */
        return shootButton;
    }
    
    public void resetTime(){
        /**
         * resetTime - reseta o timer do jogador e das armas
         * @return void
         */
        time=0;
        weapon.resetTime();
    }
    
    public Weapon getWeapon(){
        /**
         * getWeapon - retorna a arma do jogador
         * @return Weapon weapon
         */
        return this.weapon;
    }
    
    public void setWeapon(Weapon weapon){
        /**
         * setWeapon - muda a arma do jogador
         * @param Weapon weapon - arma
         * @return void
         */
        this.weapon= weapon;
    }
    
    public String getDirection(){
        /**
         * getDirection - retorna a direção do jogador
         * @return String direction
         */
        return this.direction;
    }
    
    public int getHeart(){
        /**
         * getHeart - retorna a vida atual do jogador
         * @return int heart
         */
        return heart.getQuantidadeAtual();
    }
    
    public int getPlayerAppearance(){
        /**
         * getPlayerAppearance - retorna o valor da skin do jogador
         * @return int playerAppearance
         */
        return playerAppearance;
    }
    public void setPlayerAppearance(int playerAppearance){
        /**
         * setPlayerAppearance - muda o valor da skin do jogador (playerAppearance)
         * @param int playerAppearance - valor da skin 
         * @return void
         */
        this.playerAppearance = playerAppearance;
    }
    
    public void createDependencies(){
        /**
         * createDependencies - adiciona as dependencias ao jogo
         * @return void
         */
        World world = getWorld(); // Cria um objeto de classe World e o define como o World atual
        world.addObject(heart, getX() + 25, getY() + 10);
        world.addObject(weapon,getX(),getY());
    }

    public void movePlayer() {
        /**
         * movePlayer - verifica o botão pressionado e move o jogador
         * @return void
         */

        if (Greenfoot.isKeyDown(moveLeft)) {
            setLocation(getX() - (velocidade -weapon.getPeso()), getY() );
            setImage("ator/leftPlayer" + playerAppearance + ".png");
            direction = "left";
        }

        if (Greenfoot.isKeyDown(moveRight)) {
            setLocation(getX() + (velocidade -weapon.getPeso()), getY() );
            setImage("ator/rightPlayer" + playerAppearance + ".png");
            direction = "right";
        }

        if (Greenfoot.isKeyDown(moveDown)) {
            setLocation(getX(), getY() + (velocidade -weapon.getPeso()) );
            setImage("ator/downPlayer" + playerAppearance + ".png");
            direction = "down";
        }

        if (Greenfoot.isKeyDown(moveUp)) {
            setLocation(getX(), getY() - (velocidade -weapon.getPeso()) );
            setImage("ator/upPlayer" + playerAppearance + ".png");
            direction = "up";
        }
    }

    private void shoot() {
        /**
         * shoot - verifica o botão pressiona e efetua um disparo caso der verdadeiro
         * @return void
         */
        
        if (Greenfoot.isKeyDown(shootButton)) {
            weapon.shoot(direction,time);
        }
    }
    
    public void takeDamage() {
        /**
         * takeDamage - verifica o contato com NonPlayerCharacter.class e EnemyAtaque.class , após isso , efetua um bloco de código.
         * @return void
         */
        Levels world = (Levels)getWorld();
         
        if (isTouching(NonPlayerCharacter.class)){
            
            NonPlayerCharacter enemy = getIntersectingObjects(NonPlayerCharacter.class).get(0);
            heart.lose(enemy.getDamage());
            
            if(heart.getQuantidadeAtual()<=0){
                world.lose();
            }
        }
        
        if (isTouching(EnemyAtaque.class)){
            
            EnemyAtaque ataque = getIntersectingObjects(EnemyAtaque.class).get(0);
            heart.lose(ataque.getDamage());
            
            world.removeObject(ataque);
            
            if(heart.getQuantidadeAtual()<=0){
                world.lose();
            }
        }
        
    }

    /**public void gameOver() {
        if (isTouching(FastZombie.class)) {
            getWorld().showText("GAME OVER!!!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }
    }*/
    

}
