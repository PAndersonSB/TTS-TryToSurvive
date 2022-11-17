import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossInferno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossInferno extends NonPlayerCharacter
{
    /**
     * Act - do whatever the BossInferno wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(timer == 0){
            setPlayerAlvo();
            timer +=1;
            novaCaveira("1");
            novaCaveira("5");
        }
        else{
            if (timer%9 == 0){ //parado
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
        }
    }
    
    public BossInferno() {
        speed = 1;
        heart = new HeartBar(1000,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/bossInferno";
        this.direcao = "D";
        this.frame = "1";
        setImage(image + direcao + frame + ".png");
    }
    
    public void novaCaveira(String frame){
        World world = getWorld();
        world.addObject(new Caveira(this,frame), getX(), getY() );
    }
    
    public void atack(){
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
