/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends CommandBase {

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(){
    addRequirements(RobotContainer.driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double Throttle1 = -RobotContainer.driverControl.GetLJY();
    double ThrottleTurn = RobotContainer.driverControl.GetRJX();
    RobotContainer.driveSubsystem.Dron(Throttle1 ,ThrottleTurn);

    /*
    double Throttle1 = -RobotContainer.driverControl.GetRT();
    double Throttle2 = -RobotContainer.driverControl.GetLT();
    double ThrottleTurn = RobotContainer.driverControl.GetLJX();
    RobotContainer.driveSubsystem.F1(Throttle1 ,Throttle2,ThrottleTurn);
    */

    boolean LeftSpin = RobotContainer.driverControl.GetLB();
    boolean RightSpin = RobotContainer.driverControl.GetRB();
    RobotContainer.driveSubsystem.GirarSobreEje(LeftSpin ,RightSpin);
    
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
