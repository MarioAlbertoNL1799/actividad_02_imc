/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.ViewCalculator;
import models.ModelCalculator;
/**
 *
 * @author manl_
 */
public class ControllerCalculator implements ActionListener{
    ModelCalculator modelCalculator;
    ViewCalculator viewCalculator;
    private Float pesaje;
    private Float medida;
    private Float operacion;
    private String mensaje = null;

    public ControllerCalculator(ModelCalculator modelCalculator, ViewCalculator viewCalculator) {
        this.modelCalculator = modelCalculator;
        this.viewCalculator = viewCalculator;
        this.viewCalculator.jb_calcular.addActionListener(this);
        initComponents();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== viewCalculator.jb_calcular){
            jb_calcular_action_performed();
        }
    }
    
    public void jb_calcular_action_performed(){
        pesaje = Float.parseFloat(viewCalculator.jtf_peso.getText());
        modelCalculator.setPeso(pesaje);
        medida = Float.parseFloat(viewCalculator.jtf_altura.getText());
        modelCalculator.setAltura(medida);
        
        if (modelCalculator.getAltura() == 0 && modelCalculator.getPeso() == 0){
            JOptionPane.showMessageDialog(viewCalculator,"Ingrese valores", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (modelCalculator.getAltura() > 2 || modelCalculator.getAltura() < 1){
            JOptionPane.showMessageDialog(viewCalculator,"El valor de altura no es correcto intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(modelCalculator.getPeso() <= 0){
            JOptionPane.showMessageDialog(viewCalculator,"El valor de peso no es correcto intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
        operacion = pesaje / (medida * medida);
        if (operacion < 18.5){
            mensaje = "Peso bajo";
        }
        else if (operacion >= 30){
            mensaje = "Sobrepeso";
        }
        else{
            mensaje = "Peso Normal";
        }
        viewCalculator.jl_resultado.setText("Tu IMC es de " + operacion + " y tu estas en " + mensaje);
        }
    }
    public void initComponents(){
        viewCalculator.setVisible(true);
    }
}
