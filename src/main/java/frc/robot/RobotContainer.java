/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
import frc.robot.Xbox360Controller;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static GyroCommand gyroCommand = new GyroCommand();
  public static GyroSubsystem gyroSubsystem = new GyroSubsystem();

  public static CameraDriverCommand cameraDriverCommand = new CameraDriverCommand();
  public static CameraDriverSubsystem cameraDriverSubsystem = new CameraDriverSubsystem();

  public static AutoVisionCommand autoVisionCommand = new AutoVisionCommand();
  public static AutoVisionSubsystem autoVisionSubsystem = new AutoVisionSubsystem();

  public static DriveCommand driveCommand = new DriveCommand();
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();

  public static Xbox360Controller driverControl = new Xbox360Controller(Constants.NUM_DRIVER_CONTROLLER);
  public static DifferentialDrive chasis = new DifferentialDrive(new Spark(Constants.CHASIS_LEFT), new Spark(Constants.CHASIS_RIGHT));
  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
