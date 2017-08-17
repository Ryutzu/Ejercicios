/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obtenernum;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Alumno
 */
public class cPrincipal extends JFrame implements ActionListener{
    JTextField get = new JTextField();
    JButton obt = new JButton("Obtener");
    JLabel res1 = new JLabel();
    JLabel res2 = new JLabel();
    /*
    Metodo constructor
    Inicializa la ventana principal
    */
    public cPrincipal(){
        setPreferredSize(new Dimension(500,500));
        setMinimumSize(new Dimension(500,500));
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        Components();
    }
    
    private void Components() {
        get.setBounds(200, 50, 100, 50);
        add(get);
        obt.addActionListener(this);
        obt.setBounds(200, 200, 100, 50);
        add(obt);
        res1.setBounds(10, 300, 480, 50);
        add(res1);
        res2.setBounds(10, 400, 480, 50);
        add(res2);
    }
    private String Fibonacci(String num){
        String ser = "0,1";
        long no = Integer.parseInt(num);
        if(no!=0){
            if(no==1){
                ser="0";
            }else if(no==2){
                
            }else{
                for(int j=2;j<no;j++){
                    String[] arr = ser.split(",");
                    long one;
                    //if(arr.length>2)
                    one = Integer.parseInt(arr[arr.length-1]);
                    long two;
                    two = Integer.parseInt(arr[arr.length-2]);
                    long tot = one+two;
                    ser+=","+tot;
                }
            }
        }
        return ser;
    }
    private String Factorial(String num){
        String fac ="";
        long no = Integer.parseInt(num);
        long res=no;
        for(long j=no-1;j>0;j--){
            res*=j;
        }
        fac=String.valueOf(res);
        return fac;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==obt){
            String re1 = get.getText();
            if(Integer.parseInt(re1)<=20){
                Pattern pat = Pattern.compile("[0-9]{1,7}");
                Matcher mat = pat.matcher(re1);
                if(mat.matches()){
                    res1.setText("Fibonacci: "+Fibonacci(re1));
                    res2.setText("Factorial: "+Factorial(re1));
                }else{
                    res1.setText("Numero!");
                    res2.setText("Numero!");
                }
            }else{
                res1.setText("20 es el maximo...");
                res2.setText("20 es el maximo...");
            }
        }
    }
    
}
