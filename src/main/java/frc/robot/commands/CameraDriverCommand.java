/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class CameraDriverCommand extends CommandBase {
  boolean cOn = false;
  boolean cOff = false;

  public CameraDriverCommand() {
    addRequirements(RobotContainer.cameraDriverSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean action = RobotContainer.mechanismControl.GetBack();
    if(cOn) {
      RobotContainer.cameraDriverSubsystem.Run(true);
    }else{
      RobotContainer.cameraDriverSubsystem.Run(false);
    }
    if (action == true) {
      if (!cOff) {
        cOn = !cOn;
        cOff = true;
      }
    }
    else {
      cOff = false;
    }

  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
