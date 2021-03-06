/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutonomousGyroCommand extends CommandBase {
  /**
   * Creates a new GyroCommand.
   */
  boolean terminate=false;
  public AutonomousGyroCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements();

  }
  public AutonomousGyroCommand(double deg){
    RobotContainer.autonomousGyroSubsystem.SetDegree(deg);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    terminate = false;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.autonomousGyroSubsystem.Go() == true){
      terminate = true;
    }
    else{
      terminate = false;
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.autonomousGyroSubsystem.Reset();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return terminate;
  }
}
