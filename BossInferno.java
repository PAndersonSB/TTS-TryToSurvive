import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class BossInferno extends NonPlayerCharacter
{
    public void act() {
        /**
         *  atc - metodo de atuar do greenfoot.
         */
        if(timer == 0){
            setPlayerAlvo();
            timer +=1;
            novaCaveira("1");
            novaCaveira("5");
        }
        else{
            if (timer%4 == 0){ //parado
                move();
                timer +=1;
            }
            else{ //se movendo
                timer +=1;
            }
            atack();
            heart.updateStatusBar(getX()-9,getY()-30);
            hitByShot();
            setImage(image+direcao+frame+".png");
            
            if (timer%2000 == 0){
                novaCaveira("1");
                novaCaveira("5");
            }
        }
    }
    
    public BossInferno() {
        speed = 1;
        heart = new HeartBar(500,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/bossInferno";
        this.direcao = "D";
        this.frame = "1";
        setImage(image + direcao + frame + ".png");
    }
    
    public void novaCaveira(String frame){
        /**
         * novaCaveira - adiciona um nova caveira no jogo
         * @param String frame - frame da caveira
         * @return void
         */
        World world = getWorld();
        world.addObject(new Caveira(this,frame), getX(), getY() );
    }
    
    public void atack(){
        /**
         * atack - efetua um ataque
         * @return void
         */
        World world = getWorld();
        
        if(timer%280 == 0){
            if (direcao == "R") {//npc/caveira3
            world.addObject(new EnemyAtaque("npc/caveira3",getX(),getY(),10, 0), getX() + 25, getY() + 10);
            } 
                
            if (direcao == "L") {//npc/caveira7
                world.addObject(new EnemyAtaque("npc/caveira7",getX(),getY(),-10, 0), getX() - 25, getY() + 10);
            }
        }

    }
}
