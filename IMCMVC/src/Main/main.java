/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import models.ModelCalculator;
import views.ViewCalculator;
import controllers.ControllerCalculator;
/**
 *
 * @author manl_
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelCalculator modelCalculator = new ModelCalculator();
        ViewCalculator viewCalculator = new ViewCalculator();
        ControllerCalculator controllerCalculator = new ControllerCalculator(modelCalculator,viewCalculator);
    }   
}
