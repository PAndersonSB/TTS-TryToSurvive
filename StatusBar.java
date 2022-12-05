import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public abstract class StatusBar extends Actor
{
    /**
     * StatusBar - constutor
     * @param int quantidadeAtual - quantidade atual de algo
     * @param int diretorio - diretorio no qual esta a imagem que sera usada
     * 
     */    
    protected int quantidadeAtual;
    protected int quantidadeInicial;
    
    protected String image; //trocar 
    protected String diretorio;
    //protected GreenfootImage imageTemporaria ;
    
    public StatusBar(int quantidadeAtual,String diretorio){
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeInicial =quantidadeAtual;
        this.diretorio = diretorio;
        //imageTemporaria= new GreenfootImage("vida: " + quantidadeAtual, 40, Color.BLACK, new Color(0, 0, 0, 0));
    }
    
    public void updateStatusBar(int x,int y){
        /**
         * updateStatusBar - atualiza a posição deste objeto
         * @param int x - posição em X no jogo
         * @param int y - posição em Y no jogo
         * @return void
         */
        //setImage(imageTemporaria);
        setImage(image);
        setLocation(x,y);
                
    }
     
    public void lose(int valor){ 
        /**
         * lose - metodo que diminui a quantidade atual deste objeto
         * @param int valor - valor a ser decrementado
         * @return void
         */
        if( (this.quantidadeAtual-valor) < this.quantidadeInicial){ 
            this.quantidadeAtual-=valor; 
        }
        else{
            this.quantidadeAtual = this.quantidadeInicial;
        }
        updateImage();
    }
    
    public abstract void updateImage();
    
    public int getQuantidadeAtual(){
        /**
         * getQuantidadeAtual - retorna o valor atual 
         * @return int quantidadeAtual
         */
        return this.quantidadeAtual;
    }
}
