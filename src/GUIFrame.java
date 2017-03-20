import javax.swing.*;
import java.awt.*;


/**
 * Created by BradWilliams on 1/24/17.
 */
public class GUIFrame extends JFrame{

    public GUIFrame(int _width, int _height){
        setResizable(false);
        setSize(_width,_height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0,0,0));
        setLayout(null);
        //setFocusable(true);
        setVisible(true);

    }

}
