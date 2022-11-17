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
    protected Player outroPlayer;
    
    protected int speed;
    protected int timer;
    
    protected String image; //nome
    protected String direcao; // direcao do movimento
    protected String frame; // variacao de frames
    
    protected boolean ordemDeAnimacao = true;// se true crescente , se false decrescente
    
        
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
                timer +=1;
            }
            animacao();
            heart.updateStatusBar(getX()-9,getY()-30);
            hitByShot();
            setImage(image+direcao+frame+".png");
        }
    }
    
    public void setPlayerAlvo(){
        World world = getWorld();
        
        world.addObject(heart, getX() + 25, getY() + 10);
        
        int numRandom = Greenfoot.getRandomNumber(2);
        
        if(numRandom == 0){
            this.playerAlvo= world.getObjects(Player.class).get(0);
            this.outroPlayer = world.getObjects(Player.class).get(1);
        }else{
            this.playerAlvo= world.getObjects(Player.class).get(1);
            this.outroPlayer = world.getObjects(Player.class).get(0);
        }
        
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void move(){
        int x;
        int y; 
        
        if(getX() > playerAlvo.getX()){// realacao de x
            x = getX() - speed ; //esquerda
            this.direcao = "L";
        }
        else{
            x = getX() + speed ; //direita
            this.direcao = "R";
        }
        
        if(getY() > playerAlvo.getY()){// relacao de y 
            y = getY() - speed ;
        }
        else{
            y = getY() + speed ;
        }
        
        setLocation(x,y);
    }
    
    public boolean sendoObservado(){
        boolean validacao = false;
        //pega a posicao dele e compara com a do player //verifica com base nisso e na direcao se eles estão se olhando
        if( (playerAlvo.getX() > getX() && playerAlvo.getDirection() == "left") || (playerAlvo.getX() < getX() && playerAlvo.getDirection() == "right") ){
            validacao = true;
        }
        else if( (playerAlvo.getY() > getY() && playerAlvo.getDirection() == "up") || (playerAlvo.getY() < getY() && playerAlvo.getDirection() == "down") ){
            validacao = true;
        }
        else if ( (outroPlayer.getX() > getX() && outroPlayer.getDirection() == "left") || (outroPlayer.getX() < getX() && outroPlayer.getDirection() == "right") ){
            validacao = true;
        }
        else if( (playerAlvo.getY() > getY() && playerAlvo.getDirection() == "up") || (playerAlvo.getY() < getY() && playerAlvo.getDirection() == "down") ){
            validacao = true;
        }
        return validacao;
    }
    
    public void animacao(){
        //ordemDeAnimacao;// se true crescente , se false decrescente
        if (timer%10 == 0){
            if(frame =="2"){
                if(ordemDeAnimacao){
                    frame = "3";
                }
                else{
                    frame = "1";
                }
            }
            else if(frame == "3"){
                ordemDeAnimacao = false;
                frame = "2";
            }
            else{
                ordemDeAnimacao = true;
                frame = "2";
            }
        }
        
        
    }
        
    public void hitByShot() {
        if (isTouching(RifleBullet.class) || isTouching(ShotgunBullet.class) ){
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
