/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class GyroCommand extends CommandBase {
  /**
   * Creates a new GyroCommand.
   */
  boolean termina;
  int i;

  public GyroCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.gyroSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    termina = false;
    i = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean action = RobotContainer.driverControl.GetX();
    //RobotContainer.gyroSubsystem.See(action);
    //RobotContainer.gyroSubsystem.Go();
    System.out.println(i);
    i ++;
    if(i>= 10){
      termina = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return termina;
  }
}