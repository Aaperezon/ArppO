/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class FrikArppoAimSubsystem extends SubsystemBase {
  private Spark pitchmotor = new Spark(Constants.ARPPOPITCHPORT);
  private double speedPitch = .35;
  private double speedYaw = .5;


  public FrikArppoAimSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.frikArppoAimCommand);
    
  }

  public void Aim(double pitch, double yaw){
    if(yaw >= .1 || yaw <= -1){
        RobotContainer.chasis.tankDrive(yaw*speedYaw, -yaw*speedYaw);
    }

    if(pitch>=.1 && RobotContainer.frikLimitSubsystem.UpperLimitFree() == true){
        pitchmotor.set(pitch*speedPitch);
    }
    else if(pitch<=-.1 && RobotContainer.frikLimitSubsystem.LowerLimitFree()==true){
        pitchmotor.set(pitch*speedPitch);
    }
    else{
        pitchmotor.set(0);
    }
    

}


}
