import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Anderson Silva Brito
 * @version 1
 */
public class WindowSelectActor extends World
{

    /**
     * Constructor for objects of class selectActor.
     * 
     */
    
    private Player playerOne ;
    private Player playerTwo ;
    private GreenfootSound backgroundMusic;
    
    private Button button;
    
    private IconPlayer icon1;
    private IconPlayer icon2;
    private IconPlayer icon3;
    private IconPlayer icon4;
    
    private SelectIconPlayer p1;
    private SelectIconPlayer p2;
    
    public WindowSelectActor(GreenfootSound backgroundMusic)
    {    
        super(1000, 500, 1);
        setBackground("windows/WindowSelect.png");
        
        this.backgroundMusic = backgroundMusic;
        
        this.button = new Button("Start game.png");
        addObject( button ,490, 470);
        
        //icones
        this.icon1 = new IconPlayer(1);
        addObject(icon1, 200 , 200);
        
        this.icon2 = new IconPlayer(2);
        addObject(icon2, 400 , 200);
        
        this.icon3 = new IconPlayer(3);
        addObject(icon3, 600 , 200);
        
        this.icon4 = new IconPlayer(4);
        addObject(icon4, 800 , 200);
        
        //selecaoDeIcone
        this.p1 = new SelectIconPlayer(1);
        addObject(p1, 200,70);
        
        this.p2 = new SelectIconPlayer(2);
        addObject(p2, 400,70);
        
        
    }
    
    public void act() {
        /**
         * metodo atuar do greenfoot.
         * @return void
         */
        if (Greenfoot.mouseClicked(button)){
            backgroundMusic.stop();
            
            playerOne = new Player("s", "w", "a", "d", "e", p1.getIcone(),new ShotgunOne());
            playerTwo = new Player("down", "up", "left", "right", "space", p2.getIcone(),new M4());
            Greenfoot.setWorld(new Level1(playerOne, playerTwo ,new Counter()));
        }
    }
}
