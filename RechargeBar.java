import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RechargeBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RechargeBar extends StatusBar
{
    /**
     * Act - do whatever the RechargeBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int rechargeTime;
    private boolean recharge;
    private int contador = 0;
    
    private int animate = 1;
    
    public void act()
    {
        // Add your action code here.
        if (contador >= rechargeTime && recharge){
            recharge = false;
            quantidadeAtual = quantidadeInicial;
            contador=0;
        }
        else if(recharge){
            contador ++;
        }
        
        animate++;
        if ( animate > 10){
             animate=1;
        }
    }
    
    public RechargeBar(int quantidadeAtual,String diretorio){
        super(quantidadeAtual, diretorio);
        rechargeTime = quantidadeInicial *5;
    }
    
    public boolean getRecharge(){
        return recharge;
    }
    
    public void updateStatusBar(int x,int y){ //mantem a imagem
        //setImage(image);
        if(recharge){
            setImage(diretorio + "recarregando.png");   
        }
        else{
            setImage(diretorio + "fire" + animate + ".png");   
        }
        setLocation(x + 21, y-30);
                
    }
    
    public void updateImage(){ //muda a imagem
        //imageTemporaria= new GreenfootImage("vida: " + quantidadeAtual, 40, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(diretorio + "fire" + animate + ".png");
        
        if (quantidadeAtual <= 0){
            recharge = true;
        }
    }
}