import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class RechargeBar extends StatusBar
{
    /**
     * RechargeBar - construtor 
     * @param int quantidadeAtual - quantidade atual do objeto
     * @param String diretorio - diretorio da imagem que sera usada
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
        /**
         * getRecharge - retorna se o objeto esta em modo de recarga
         * @return boolean recharge
         */
        return recharge;
    }
    
    public void updateStatusBar(int x,int y){ //mantem a imagem
        /**
         * updateStatusBar - atualiza a posição e muda a imagem do objeto
         * @param int x - posição em X no jogo
         * @param int y - posição em Y no jogo
         * @return void
         */
        //setImage(image);
        if(recharge){
            setImage(diretorio + "recarregando.png");   
        }
        else{
            setImage(diretorio + "fire" + animate + ".png");   
        }
        setLocation(x + 21, y-30);
                
    }
    
    public void updateImage(){ 
         /**
         * updateImage - muda a imagem do objeto
         * @return void
         */
        //muda a imagem
        //imageTemporaria= new GreenfootImage("vida: " + quantidadeAtual, 40, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(diretorio + "fire" + animate + ".png");
        
        if (quantidadeAtual <= 0){
            recharge = true;
        }
    }
}