/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.RobotContainer;


public class FrikArppoShootSubsystem extends SubsystemBase {
 
  private DoubleSolenoid piston = new DoubleSolenoid(Constants.ARPPO_HOLD, Constants.ARPPO_RELEASE);
  private boolean pOn = false;
  private boolean pOff = false;
  private boolean activation = false;

  public FrikArppoShootSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.frikArppoShootCommand);
  }


  public void Shoot(boolean shoot){
    if(pOn && RobotContainer.arppoAutoShoot.isScheduled()==false){
        piston.set(DoubleSolenoid.Value.kForward);
        activation = true;
    }else if(RobotContainer.arppoAutoShoot.isScheduled()==false){
      piston.set(DoubleSolenoid.Value.kReverse);
      activation = false;
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
    SmartDashboard.putBoolean("Shooter", activation);
  }

  public void Hold(){
    piston.set(DoubleSolenoid.Value.kReverse);
    SmartDashboard.putBoolean("Shooter", false);



  }

  public void Release(){
    piston.set(DoubleSolenoid.Value.kForward);
    SmartDashboard.putBoolean("Shooter", true);



  }




}
