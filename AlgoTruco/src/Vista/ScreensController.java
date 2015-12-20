package Vista;

import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;


public class ScreensController  extends StackPane {
    

    private HashMap<String, Node> screens = new HashMap<>();
    
    public ScreensController() {
        super();
    }

    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    public Node getScreen(String name) {
        return screens.get(name);
    }

    
    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

   
    public boolean setScreen(final String name) {       
        if (screens.get(name) != null) {   
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {    //TRANSICION 
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        getChildren().remove(0);                    
                        getChildren().add(0, screens.get(name));     
                        Timeline fadeIn = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                new KeyFrame(new Duration(1000), new KeyValue(opacity, 1.0)));  //TIEMPO DE TTRANSICION
                        fadeIn.play();
                    }
                }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));      
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(10), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("NO SE PUDO CARGAR LA PANTALLA \n");
            return false;
        }


        /*Node screenToRemove;
         if(screens.get(name) != null){   
         if(!getChildren().isEmpty()){    
         getChildren().add(0, screens.get(name));     
         screenToRemove = getChildren().get(1);
         getChildren().remove(1);                   
         }else{
         getChildren().add(screens.get(name));       
         }
         return true;
         }else {
         System.out.println("screen hasn't been loaded!!! \n");
         return false;
         }*/
    }

    
    public boolean unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen no existe");
            return false;
        } else {
            return true;
        }
    }
}

