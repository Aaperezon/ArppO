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
public class DatLiftSubsystem extends SubsystemBase {
  private DoubleSolenoid piston = new DoubleSolenoid(Constants.DAT_IN, Constants.DAT_OUT);
  boolean pOn = false;
  boolean pOff = false;
  public DatLiftSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.datLiftCommand);
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


}
