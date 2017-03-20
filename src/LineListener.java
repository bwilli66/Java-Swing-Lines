
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.Random;

/**
 * Created by BradWilliams on 1/24/17.
 */
public class LineListener extends JComponent {

    public static int mouseX;
    public static int mouseY;

    public long moveCount = 0;

    int pixelSpacingRows;
    int pixelSpacingColumns;
    int numOfRows;
    int numOfColumns;

    int totalLines;
    // keep track of all all colors
    int[][] colors;

    boolean rainbow;

    public LineListener(int _width, int _height){
        setSize(_width,_height);
        setFocusable(true);

        pixelSpacingRows = (int)(getWidth()*.04f);
        pixelSpacingColumns = (int)(getHeight()*.04f);
        numOfRows = getWidth()/pixelSpacingRows;
        numOfColumns = getHeight()/pixelSpacingColumns;

        totalLines = numOfRows * numOfColumns;
        colors = new int[3][totalLines];


        this.addMouseMotionListener(new MouseMovementListener(this));
        this.addMouseListener(new MouseMovementListener(this));

        setVisible(true);
    }

    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));

        Random r = new Random();

        //System.out.println("paint called");


        for(int i = 1; i < (numOfRows); i++){

            for(int j = 1; j < (numOfColumns); j++) {

                int xOne = i * pixelSpacingRows;
                int yOne = j * pixelSpacingColumns;

                int xTwo;
                if(mouseX > xOne)
                    xTwo = xOne + ((int)((mouseX - xOne)*.1f));
                else
                    xTwo = xOne - ((int)((xOne - mouseX)*.1f));

                int yTwo;
                if(mouseY > yOne)
                    yTwo = yOne + ((int)((mouseY - yOne)*.1f));
                else
                    yTwo = yOne - ((int)((yOne - mouseY)*.1f));


                if(moveCount % 20 == 0) {

                    //System.out.println("-------- " + R + ", " + G + ", " + B + " --------");

                    colors[0][i + j] = r.nextInt(256);
                    colors[1][i + j] = r.nextInt(256);
                    colors[2][i + j] = r.nextInt(256);


                }

                if(rainbow)
                    g2.setColor(new Color(colors[0][i + j], colors[1][i + j], colors[2][i + j]));
                else
                    g2.setColor(Color.WHITE);

                //g.drawLine(xOne, yOne, xTwo, yTwo);

                g2.draw(new Line2D.Float(xOne, yOne, xTwo, yTwo));
            }
        }
    }

    public class MouseMovementListener implements MouseListener, MouseMotionListener {

        LineListener parent;
        public MouseMovementListener(LineListener parent){
            this.parent = parent;
        }

        @Override
        public void mouseDragged(MouseEvent e) {}

        @Override
        public void mouseMoved(MouseEvent e) {

            moveCount++;
            //System.out.println(moveCount);

            int x = e.getX();
            int y = e.getY();
            //System.out.println(x + ", " + y);
            mouseX = x;
            mouseY = y;


            parent.repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e){}

        @Override
        public void mouseReleased(MouseEvent e) {
            rainbow = !rainbow;
        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
}
