package margonkirpgpordoba.display;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    
    private String title;
    private int width, height;
    
    // Konstruktor
    public Display(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
        createDisplay();
    }
    
    private void createDisplay(){
        frame = new JFrame(title); // Powołanie okna, nadanie nazwy
        frame.setSize(width,height); // Nadanie wielkości
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Co dzieje się po kliknięciu x w prawym rogu
        frame.setResizable(false); // Brak możliwości ręcznej zmiany wielkości okna
        frame.setLocationRelativeTo(null); // okno zostanie pokazane an środku
        frame.setVisible(true); // widoczność na tak
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        
        
        frame.add(canvas);
        frame.pack();
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
}
