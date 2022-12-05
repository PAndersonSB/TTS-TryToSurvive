import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class SelectIconPlayer extends Actor
{
    /**
     * SelectIconPlayer - construtor
     * @param int valor - valor do objeto , 1 para palayer 1 e 2 para player 2
     */    
    private String moveLeft;
    private String moveRight;
    
    private int icone;
    
    private int timer=1;
    private boolean wait = false;
    
    public void act()
    {
        /**
         *  atc - metodo de atuar do greenfoot.
         */
        touching();
        
        if(wait){
            if (timer >10){
                wait = false;
                timer = 1;
            }
            else{
                timer++;
            }
        }else{
            move();
        }
    }
    
    public SelectIconPlayer(int valor){
        //setImage( new GreenfootImage("P" + valor, 34, Color.ORANGE, new Color(0, 0, 0, 0)));
        
        if(valor ==1){
            setImage("botoes/P1.png");
            this.moveLeft = "a";
            this.moveRight = "d";
        }else{
            setImage("botoes/P2.png");
            this.moveLeft = "left";
            this.moveRight = "right";
        }
    }
    
    public int getIcone(){
        /**
         * getIcone - retorna o valor do icone
         * @return int icone - retorna o icone do player
         */
        
        return icone;
    }
    
    public void move(){
        /**
         * move - metodo que verifica a tecla apertada pelos jogadores e move o objeto na tela
         * @return void
         */
        
        if (Greenfoot.isKeyDown(moveLeft)){
            
            if(getX()-200 > 199){
                
                setLocation(getX()-200,getY());
                wait= true;
                
                if (isTouching(SelectIconPlayer.class)){
                    if(getX()==800){
                        setLocation(600,getY());
                    }
                    else if(getX()==200){
                        setLocation(400,getY());
                    }
                    else{
                        setLocation(getX()-200,getY());
                    }
                }
                
            }
        }
        
        if (Greenfoot.isKeyDown(moveRight)){
            
            if(getX()+200 < 801){
                
                setLocation(getX()+200,getY());
                wait= true;
                
                 if (isTouching(SelectIconPlayer.class)){
                    if(getX()==800){
                        setLocation(600,getY());
                    }
                    else if(getX()==200){
                        setLocation(400,getY());
                    }
                    else{
                        setLocation(getX()+200,getY());
                    }
                }
            }
            
        }
        
    }
    
    public void touching(){
        /**
         * touching - verifica se esta em contato com IconPlayer.class e muda o valor do icone deste objeto
         */
        if (isTouching(IconPlayer.class)){
            IconPlayer iconePlayer = getIntersectingObjects(IconPlayer.class).get(0);
            
            this.icone = iconePlayer.getIcone();
        }
        
    }
}
