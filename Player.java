import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor {
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
    private HeartBar heart = new HeartBar(50,"heart/");
    private Weapon weapon; //new ShotgunOne();//new M4();
    //private Weapon secondaryWeapon = new Hand()

    public void act() {
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
    
    public void resetTime(){
        time=0;
        weapon.resetTime();
    }
    
    public int getHeart(){
        return heart.getQuantidadeAtual();
    }
    
    public int getPlayerAppearance(){
        return playerAppearance;
    }
    
    public void createDependencies(){
        World world = getWorld(); // Cria um objeto de classe World e o define como o World atual
        world.addObject(heart, getX() + 25, getY() + 10);
        world.addObject(weapon,getX(),getY());
    }

    public void movePlayer() {

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
        
        if (Greenfoot.isKeyDown(shootButton)) {
            weapon.shoot(direction,time);
        }
    }
    
    public void takeDamage() {
         
        if (isTouching(NonPlayerCharacter.class)){
            
            NonPlayerCharacter enemy = getIntersectingObjects(NonPlayerCharacter.class).get(0);
            heart.lose(enemy.getDamage());
            
            if(heart.getQuantidadeAtual()<=0){
                Greenfoot.stop();
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
