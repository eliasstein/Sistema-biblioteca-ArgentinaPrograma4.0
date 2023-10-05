package proyectofinal.vistas;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainClass {


    
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
            Main main = new Main();
            
            //FlatMaterialDeepOceanIJTheme.setup();
            UIManager.setLookAndFeel(new FlatCarbonIJTheme());
            UIManager.put( "Button.arc", 10 );
            UIManager.put( "Component.arc", 10 );
            UIManager.put( "ProgressBar.arc", 10 );
            UIManager.put( "TextComponent.arc", 10 );
            UIManager.put("InternalFrame", BorderFactory.createLineBorder(Color.BLACK, 2));

            SwingUtilities.updateComponentTreeUI(main);
            
            main.setVisible(true);

    }
    
    
}
