/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class FrikArppoAimCommand extends CommandBase {
  /**
   * Creates a new ArppoManualAimCommand.
   */
  public FrikArppoAimCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.frikArppoAimSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double pitch = RobotContainer.mechanismControl.GetLJY();
    double yaw = RobotContainer.mechanismControl.GetLJX();
    RobotContainer.frikArppoAimSubsystem.Aim(pitch, yaw);

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
