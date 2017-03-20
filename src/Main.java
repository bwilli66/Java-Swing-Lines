import java.awt.*;

/**
 * Created by BradWilliams on 1/24/17.
 */
public class Main {




    public static void main(String[] args){

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

        GUIFrame frame = new GUIFrame((int)rect.getWidth(),(int)rect.getHeight());

        frame.getContentPane().add(new LineListener(frame.getWidth(),frame.getHeight()));

    }
}
