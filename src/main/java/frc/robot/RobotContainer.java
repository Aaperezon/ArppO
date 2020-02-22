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
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  public static DriveTrain driveTrain = new DriveTrain();
  public static Xbox360Controller driverControl = new Xbox360Controller(Constants.NUM_DRIVER_CONTROLLER);
  public static Xbox360Controller mechanismControl = new Xbox360Controller(Constants.NUM_MECHANISM_CONTROLLER);

  public static DifferentialDrive chasis = new DifferentialDrive(driveTrain.Leftcontroller(), driveTrain.RightController());
  //public static DifferentialDrive chasis = new DifferentialDrive(new Spark(8),new Spark(9));

  public static AutonomousDriveSubsystem autonomousDriveSubsystem = new AutonomousDriveSubsystem();
  public static AutonomousGyroSubsystem autonomousGyroSubsystem = new AutonomousGyroSubsystem();
  public static CameraDriverSubsystem cameraDriverSubsystem = new CameraDriverSubsystem();
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public static DatLiftSubsystem datLiftSubsystem = new DatLiftSubsystem();
  public static CompressorSubsystem compressorSubsystem = new CompressorSubsystem();
  public static BallSweeperSubsystem ballSweeperSubsystem = new BallSweeperSubsystem();
  public static PanclSpinnerSubsystem panclSpinnerSubsystem = new PanclSpinnerSubsystem();
  public static FrikArppoAimSubsystem frikArppoAimSubsystem = new FrikArppoAimSubsystem();
  public static FrikArppoRevSubsystem frikArppoRevSubsystem = new FrikArppoRevSubsystem();
  public static FrikArppoShootSubsystem frikArppoShootSubsystem = new FrikArppoShootSubsystem();
  public static ArppoAimSubsystem arppoAimSubsystem = new ArppoAimSubsystem();
  public static ArppoRevSubsystem arppoRevSubsystem = new ArppoRevSubsystem();
  public static ArppoShootSubsystem arppoShootSubsystem = new ArppoShootSubsystem();
  public static FrikLimitSubsystem frikLimitSubsystem = new FrikLimitSubsystem();
  public static PanclColorSensorSubsystem panclColorSensorSubsystem = new PanclColorSensorSubsystem();
  public static DatLiftMotorSubsystem datLiftMotorSubsystem = new DatLiftMotorSubsystem();

  public static AutonomousDriveCommand autonomousDriveCommand = new AutonomousDriveCommand();
  public static AutonomousGyroCommand autonomousGyroCommand = new AutonomousGyroCommand();
  public static CameraDriverCommand cameraDriverCommand = new CameraDriverCommand();
  public static DriveCommand driveCommand = new DriveCommand();
  public static DatLiftCommand datLiftCommand = new DatLiftCommand();
  public static CompressorCommand compressorCommand = new CompressorCommand();
  public static BallSweeperCommand ballSweeperCommand = new BallSweeperCommand();
  public static PanclSpinnerCommand panclSpinnerCommand = new PanclSpinnerCommand();
  public static FrikArppoAimCommand frikArppoAimCommand = new FrikArppoAimCommand();
  public static FrikArppoRevCommand frikArppoRevCommand = new FrikArppoRevCommand();
  public static FrikArppoShootCommand frikArppoShootCommand = new FrikArppoShootCommand();
  public static ArppoAimCommand arppoAimCommand = new ArppoAimCommand();
  public static ArppoRevCommand arppoRevCommand = new ArppoRevCommand();
  public static ArppoShootCommand arppoShootCommand = new ArppoShootCommand();
  public static PanclColorSensorCommand panclColorSensorCommand = new PanclColorSensorCommand();
  public static PanclDetectColor panclDetectColor = new PanclDetectColor();
  public static DatLiftMotorCommand datLiftMotorCommand = new DatLiftMotorCommand();

  
  public static AutonomousSequence autonomousSequence = new AutonomousSequence();

  public static ArppoAutoShoot arppoAutoShoot = new ArppoAutoShoot();

  public static ColorSensor colorSensor = new ColorSensor();
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
