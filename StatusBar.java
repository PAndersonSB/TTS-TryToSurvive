import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatusBarr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class StatusBar extends Actor
{
    /**
     * Act - do whatever the StatusBarr wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
        //setImage(imageTemporaria);
        setImage(image);
        setLocation(x,y);
                
    }
     
    public void lose(int valor){ 
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
        return this.quantidadeAtual;
    }
}
