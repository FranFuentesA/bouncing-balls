import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);
        
        Random ra = new Random(); 
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        int countX = 50;
        int countY = 60;
        int pX = 0;
        int pY = 0;
        int tamaño = 0;
        ArrayList<BouncingBall> bolas = new ArrayList<BouncingBall>(); //Array donde guardaremos las bolas
        
        for(int i = 0; i < numeroBolas; i++) {
            // crate and show the balls           
            Color colores = new Color(ra.nextInt(256),ra.nextInt(256),ra.nextInt(256)); // crea de la gama rgb tres colores aleatorios
            BouncingBall ball = new BouncingBall(pX, pY, tamaño, colores, ground, myCanvas);
            bolas.add(ball);
            // posiciones y tamaños aleatorios
            pX = ra.nextInt(150);
            pY = ra.nextInt(200);
            tamaño = ra.nextInt(10);
        }
        // make them bounce
        boolean finished =  false;
        
         while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0;i < bolas.size();i++)
            {
                bolas.get(i).move();
                // stop once ball has travelled a certain distance on x axis
                if (bolas.get(i).getXPosition() >= 550)
                {
                    finished = true;
                }
            }
        }
    }
    
     public void boxBounce(int num)
    {
        int ground = 400;   // position of the ground line
        
        myCanvas.setVisible(true);
        
        Random ra = new Random();
        // draw the ground
        myCanvas.drawLine(60, 60, 480, 60);
        myCanvas.drawLine(480, 60, 480, 480);
        myCanvas.drawLine(480, 480,60, 480);
        myCanvas.drawLine(60, 480, 60, 60);
        
        int countX = 0;
        int countY = 0;
        int pX = 0;
        int pY = 0;
        int tamaño = 0;
        boolean direc;
        boolean direc2;
         ArrayList<BoxBall> bolasB = new ArrayList<BoxBall>(); //Array donde guardaremos las bolas
        
        for(int i = 0; i < num; i++) {
            // crate and show the balls   
            direc = ra.nextBoolean();
            Color colores = new Color(ra.nextInt(256),ra.nextInt(256),ra.nextInt(256)); // crea de la gama rgb tres colores aleatorios
           //para que de valores aleatorios y asi cambie de direccion
            direc = ra.nextBoolean(); 
            direc2 = ra.nextBoolean();
             pX= ra.nextInt(300) + 80;
            pY = ra.nextInt(200) + 80;
            tamaño = ra.nextInt(30) + 20;
            BoxBall ball = new BoxBall(pX, pY, tamaño, colores, ground, myCanvas, direc, direc2);
            bolasB.add(ball);
            // posiciones y tamaños aleatorios
            
           
            
        }
        // make them bounce
        boolean finished =  false;
        
         while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0;i < bolasB.size();i++)
            {
                bolasB.get(i).move();                
            }
        }
        
        
    }
}
