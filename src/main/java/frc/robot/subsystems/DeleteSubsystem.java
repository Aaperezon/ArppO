/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class DeleteSubsystem extends SubsystemBase {
  /**
   * Creates a new DeleteSubsystem.
   */
  double variable;
  public DeleteSubsystem() {
    variable = 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //setDefaultCommand(RobotContainer.deleteCommand);

  }
  public boolean Go(){
    variable++;
    if(variable<=60){
      return false;
    }
    else{
      variable = 0;
      return true;
    }
  }



}
