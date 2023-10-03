package proyectofinal.vistas;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainClass {


    
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
            Main main = new Main();
            
            //FlatMaterialDeepOceanIJTheme.setup();
            UIManager.setLookAndFeel(new FlatCarbonIJTheme());
            UIManager.put( "Button.arc", 999 );
            UIManager.put( "Component.arc", 999 );
            UIManager.put( "ProgressBar.arc", 999 );
            UIManager.put( "TextComponent.arc", 999 );
            UIManager.put( "InternalFrameUI.arc",999);
            SwingUtilities.updateComponentTreeUI(main);
            
            main.setVisible(true);

    }
    
    
}
