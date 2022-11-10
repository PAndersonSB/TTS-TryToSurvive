import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NonPlayerCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class NonPlayerCharacter extends Actor
{
    /**
     * Act - do whatever the NonPlayerCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int damage;
    protected HeartBar heart;
    
    protected Player playerAlvo;
    protected int speed;
    protected int timer;
    protected String image;
        
    public void act() {
        if(timer == 0){
            setPlayerAlvo();
            timer +=1;
        }
        else{
            if (timer%2 == 0){ //parado
                timer +=1;
            }
            else{ //se movendo
                move();
                heart.updateStatusBar(getX()-9,getY()-30);
                hitByShot();
                
                timer +=1;
            }
        }
    }
    
    public void setPlayerAlvo(){
        World world = getWorld();
        
        world.addObject(heart, getX() + 25, getY() + 10);
        
        Player playerOne = world.getObjects(Player.class).get(0);
        Player playerTwo = world.getObjects(Player.class).get(1);
        
        // pegar a posição e setar o mais proximos
        int numRandom = Greenfoot.getRandomNumber(2);
        if(numRandom == 0){
            this.playerAlvo= playerOne;
            System.out.println(numRandom);
        }else{
            this.playerAlvo= playerTwo;
            System.out.println(numRandom);
        }
        
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void move(){
        int x;
        int y; 
        
        if(getX() > playerAlvo.getX()){// realacao de x
            x = getX() - speed ;
        }
        else{
            x = getX() + speed ;
        }
        
        if(getY() > playerAlvo.getY()){// relacao de y 
            y = getY() - speed ;
        }
        else{
            y = getY() + speed ;
        }
        
        setLocation(x,y);
    }
    
    public void hitByShot() {
        if (isTouching(Attack.class)){
            Levels world = (Levels)getWorld();
            
            Attack attack = getIntersectingObjects(Attack.class).get(0);
            heart.lose(attack.getDamage());
            world.removeObject(attack);
            
            if (heart.getQuantidadeAtual() <= 0) {
                world.incrementScore(1);
                //adicinar uma pequena chance de spawnar RecoverLife;
                if(Greenfoot.getRandomNumber(3) == 1){
                    world.addObject(new RecoverLife() ,getX() ,getY() );
                }
                world.removeObject(this);
                
            }
        }
    }
}
