/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;


public class Xbox360Controller {
    private boolean a,b,x,y,LB,RB,back,start,LP,RP;
    private double LJX,LJY,LT,RT,RJX,RJY;                
    private  int pov;                                     

    private Joystick control;
    public Xbox360Controller(int port){
        control = new Joystick(port);
    }

    /*
    *Metodos que regresan valores de los botones booleanos del control
    */
    public boolean GetA(){
        a = control.getRawButton(1);
        return a;
    }
    public boolean GetB(){
		b = control.getRawButton(2);	
        return b;
    }
    public boolean GetX(){
		x = control.getRawButton(3);		
        return x;
    }
    public Boolean GetY(){
	    y = control.getRawButton(4);
        return y;
    }
    public Boolean GetLB(){
		LB = control.getRawButton(5);
        return LB;
    }
    public Boolean GetRB(){
		RB= control.getRawButton(6);
        return RB;
    }
    public Boolean GetBack(){
		back= control.getRawButton(7);
        return back;
    }
    public Boolean GetStart(){
		start = control.getRawButton(8);
        return start;
    }
    public Boolean GetLP(){
		LP = control.getRawButton(9);
        return LP;
    }
    public Boolean GetRP(){
        RP = control.getRawButton(10);
        return RP;
    }
    /*
    *Metodos que regresan valores double de los gatillos o palancas
    */
    public Double GetLJX(){
        LJX = control.getRawAxis(0);
        return LJX;
    }
    public Double GetLJY(){
        LJY = control.getRawAxis(1);
        return LJY;
    }
    public Double GetLT(){
        LT = control.getRawAxis(2);
        return LT;
    }
    public Double GetRT(){
        RT = control.getRawAxis(3);
        return RT;
    }
    public Double GetRJX(){
        RJX = control.getRawAxis(4);
        return RJX;
    }
    public Double GetRJY(){
        RJY = control.getRawAxis(5);
        return RJY;  
    }
    /*
    *Metodo que regresa el valor entero de la cruz
    */
    public int GetPOV(){
		pov = control.getPOV();
        return pov;
    }
    

}