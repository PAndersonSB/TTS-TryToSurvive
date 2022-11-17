import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cranio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caveira extends NonPlayerCharacter
{
    /**
     * Act - do whatever the Cranio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private NonPlayerCharacter boss;
    
    public Caveira(NonPlayerCharacter boss,String frame) {
        speed = 1;
        heart = new HeartBar(50,"heart/"); // vida Zombie
        this.damage = 1;
        this.image = "npc/caveira";
        this.frame = frame;
        this.boss = boss;
        setImage(image + frame + ".png");
    }
    
    public void act() {
        if(timer == 0){
            setPlayerAlvo();
            timer +=1;
        }
        else{
            if (timer%10== 0){ 
                timer +=1;
                move();
            }
            else{
                timer +=1;
            }
            heart.updateStatusBar(getX()-9,getY()-30);
            hitByShot();
            setImage(image+frame+".png");
            atack();
        }
    }
    
    public void atack(){
        World world = getWorld();
        
        if(timer%560 == 0){
            if (frame == "3") {//npc/caveira3
            world.addObject(new EnemyAtaque("npc/caveira3",getX(),getY(),10, 0), getX() + 25, getY() + 10);
            } 
                
            if (direcao == "7") {//npc/caveira7
                world.addObject(new EnemyAtaque("npc/caveira7",getX(),getY(),-10, 0), getX() - 25, getY() + 10);
            }
        }

    }
    
    public void move(){
        // se move em volta do boss.
        // localização varia conforme o frame
        // lembrar de mudar o frame frame
        // frame de 1 a 8
        
        if (frame == "1"){
            frame = "2";
            setLocation(boss.getX()+40,boss.getY()+40);
        }
        else if(frame == "2"){
            frame = "3";
            setLocation(boss.getX() +80,boss.getY());
        }
        else if(frame == "3"){
            frame = "4";
            setLocation(boss.getX()+40,boss.getY()-40);
        }
        else if(frame == "4"){
            frame = "5";
            setLocation(boss.getX(),boss.getY()-80);
        }
        else if(frame == "5"){
            frame = "6";
            setLocation(boss.getX()-40,boss.getY()-40);
        }
        else if(frame == "6"){
            frame = "7";
            setLocation(boss.getX()-80,boss.getY());
        }
        else if(frame == "7"){
            frame = "8";
            setLocation(boss.getX()-40,boss.getY()+40);
        }
        else if(frame == "8"){
            frame = "1";
            setLocation(boss.getX(),boss.getY() +80);
        }
        
    }
}
