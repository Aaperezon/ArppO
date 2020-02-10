/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;

public class PanclSpinnerSubsystem extends SubsystemBase {
  private DoubleSolenoid piston = new DoubleSolenoid(Constants.PANCL_IN, Constants.PANCL_OUT);
  private boolean pOn = false;
  private boolean pOff = false;
  private Spark motor = new Spark(Constants.PANCLSPINNERPORT);
  public PanclSpinnerSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.panclSpinnerCommand);
  }

  public void Launch(boolean boton){
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
  }
  public void StartUp(double action){
    if(action >= .1 || action <= -1){
      motor.set(action);
    }
    else{
      motor.set(0);
    }
  }
}
