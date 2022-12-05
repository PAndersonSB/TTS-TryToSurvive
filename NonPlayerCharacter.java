import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NonPlayerCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class NonPlayerCharacter extends Actor
{
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
        /**
         *  atc - metodo de atuar do greenfoot.
         */
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
        /**
         * setPlayerAlvo - marca um jogador como inimigo
         * @return void
         */
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
        /**
         * getDamage - retorna o dano deste inimigo
         * @return int damage
         */
        return damage;
    }
    
    public void move(){
        /**
         * move - move este objeto em direção ao seu alvo e muda a direção deste objeto
         * @return void
         */
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
        /**
         * sendoObservado - verifica se um player esta direcionado a este objeto e se este objeto esta direcionado ao jogador
         * @return boolean
         */
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
        /**
         * animacao - muda os frames deste objeto a cada N segundos
         * @return void
         */
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
        /**
         * hitByShot - verifica se este objeto esta em contato com  RifleBullet.class ou ShotgunBullet.class
         * se sim diminui a vida deste objeto e remove esse Attack do mundo
         * se a vida chegar a zero este objeto morre
         * 
         * @return void
         */
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
