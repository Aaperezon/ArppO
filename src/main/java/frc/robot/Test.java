package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
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
        double pMovement = RobotContainer.driverControl.GetLJY();
        if(forward>.1){
            cSuperior.set(forward*vel1);
            cInferior.set(-forward*vel1+pMovement);
        }
        else if(forward<-.1){
            cSuperior.set(forward*vel1);
            cInferior.set(-forward*vel1+pMovement);
        }else{
            cSuperior.set(0);
            cInferior.set(0);
        }
        if(pMovement > .1){
            pitch.set(pMovement*vel2);
        }else if(pMovement < -.1){
            pitch.set(pMovement*vel2);
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