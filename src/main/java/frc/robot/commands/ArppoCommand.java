/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ArppoCommand extends CommandBase {
  /**
   * Creates a new ArppoCommand.
   */
  public ArppoCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.arppoSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double yaw = RobotContainer.mechanismControl.GetLJX();
    double pitch = RobotContainer.mechanismControl.GetLJY();
    boolean speedUp = RobotContainer.mechanismControl.GetLB();
    boolean shoot = RobotContainer.mechanismControl.GetRB();
    RobotContainer.arppoSubsystem.ManualAim(yaw, pitch, speedUp, shoot);
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
