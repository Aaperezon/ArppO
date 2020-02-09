package frc.robot;

import edu.wpi.first.wpilibj.*;
public class Test {
    Spark cSuperior = new Spark(5);
    Spark cInferior = new Spark(6);
    Spark pitch = new Spark(3);
    static final double vel1 = 1;
    static final double vel2 = .4;
    
    /*
    DoubleSolenoid piston = new DoubleSolenoid(6, 7);
    boolean pOn = false;
    boolean pOff = false;
    Compressor compressor = new Compressor();
    boolean cOn = false;
    boolean cOff = false;
*/
    public Test(){


    }

    public void Run(){
        double forward = RobotContainer.driverControl.GetRJY();
        double accel = RobotContainer.driverControl.GetLJY();
        double pMovementF = RobotContainer.driverControl.GetRT();
        double pMovementB = RobotContainer.driverControl.GetLT();
        if(forward>.1){
            cSuperior.set(forward*vel1);
            cInferior.set(-forward*vel1+accel);
        }
        else if(forward<-.1){
            cSuperior.set(forward*vel1);
            cInferior.set(-forward*vel1+accel);
        }else{
            cSuperior.set(0);
            cInferior.set(0);
        }


        
        if(pMovementF > .1){
            pitch.set(pMovementF*vel2);
        }else if(pMovementB > -.1){
            pitch.set(-pMovementB*vel2);
        }else{
            pitch.set(0);
        }





        /*
        boolean boton = RobotContainer.driverControl.GetA();

        if(pOn) {
            piston.set(DoubleSolenoid.Value.kForward);
        }else{
            piston.set(DoubleSolenoid.Value.kReverse);
        }
        if (boton == true) {
            if (!pOff) {
                pOn = !pOn;
                pOff = true;
            }
        }
        else {
            pOff = false;
        }

        boolean botonCompresor = RobotContainer.driverControl.GetStart();

        if(cOn) {
            compressor.setClosedLoopControl(true);    
        }else{
            compressor.setClosedLoopControl(false); 
        }
        if (botonCompresor == true) {
            if (!cOff) {
                cOn = !cOn;
                cOff = true;
            }
        }
        else {
            cOff = false;
        }
        */
    }
}