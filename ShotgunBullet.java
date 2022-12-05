/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class ShotgunBullet extends Attack
{
    /**
     * RifleBullet - construtor
     * int x - posição inicial em X
     * int y - posição inicial em Y
     * int directionX - valor X que o attack ira se mover na tela
     * int directionY - valor Y que o attack ira se mover na tela
     */
    int time = 1;
    
    public ShotgunBullet(int x, int y,int directionX,int directionY ){
        this.x= x;
        this.y= y;
    
        this.directionX= directionX;
        this.directionY= directionY;
        this.damage = 200;
        
        setImage("bala0.png");
    }
    
    public void moveAttack(){
        /**
         * moveAttack - faz com que o objeto attack se mova na tela e com o tempo essa distancia em que ele se move diminui
         * @return void
         */
        setLocation(getX() + directionX, getY() + directionY);
        
        time++;
        if(time%3 == 0){
            
            if (directionX > 0){
                directionX -=1;
            }
            else if (directionX < 0){
                directionX +=1;
            }
        
            if(directionY >0){
                directionY -=1;
            }else if(directionY <0){
                directionY +=1;
            }
        }
        
    }
}
