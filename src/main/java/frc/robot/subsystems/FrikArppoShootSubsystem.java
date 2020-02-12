/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants;
import frc.robot.RobotContainer;


public class FrikArppoShootSubsystem extends SubsystemBase {
 
  private DoubleSolenoid piston = new DoubleSolenoid(Constants.ARPPO_HOLD, Constants.ARPPO_RELEASE);
  private boolean pOn = false;
  private boolean pOff = false;
  

  public FrikArppoShootSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.frikArppoShootCommand);
  }


  public void Shoot(boolean shoot){
    if(pOn) {
        piston.set(DoubleSolenoid.Value.kForward);
    }else{
    piston.set(DoubleSolenoid.Value.kReverse);
    }
    if (shoot == true) {
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
