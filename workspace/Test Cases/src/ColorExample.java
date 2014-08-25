/**
 *  This class just illustrates several of the ways to set a color in Java
 */
import java.awt.*;
import javax.swing.*;
import com.otherwise.jurtle.*;

public class ColorExample extends Turtle
{


    public void runTurtle()
    {
        // set the display to blue using the static Color variable
        setDisplayColor( Color.blue );
        pause( 1000 );

        // set the display to green by creating a new Color object
        setDisplayColor( new Color( 255, 0, 0 ) );
        pause( 1000 );

        // set the display color to a sort of cyan by calling the static 
        // Color method getHSBColor()
        setDisplayColor( Color.getHSBColor( 0.5f, 0.8f, 1.0f ) );
        pause( 1000 );
    }


}
