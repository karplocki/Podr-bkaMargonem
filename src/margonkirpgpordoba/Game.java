package margonkirpgpordoba;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import margonkirpgpordoba.display.Display;
import margonkirpgpordoba.gfx.ImageLoader;
import margonkirpgpordoba.gfx.SpriteSheet;

public class Game implements Runnable{
    
    private Display display;
    private Thread thread;
    
    public int width, height;
    public String title;
    private boolean running = false;
    
    private BufferStrategy bs;
    private Graphics g;
    
    private BufferedImage test;
    private SpriteSheet sheet;
    
    public Game(String title, int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;
        
        
    }
    
    private void init(){
        display = new Display(title, width, height);
        test = ImageLoader.loadImage("/textures/map1.png");
        sheet = new SpriteSheet(test);
    }
    
    private void tick(){
        
    }
    
    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        //clear
        g.clearRect(0, 0, width, width);
        //
        
        g.drawImage(sheet.crop(55, 55, 32, 32),5,5,null);
        
        //
        bs.show();
        g.dispose();
    }
    
    public void run(){
        init();
        
        while(running){
            tick();
            render();
        }
        stop();
    }
    
    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
