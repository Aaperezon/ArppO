/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.RobotContainer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  @Override
  public void robotInit() {

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    // schedule the autonomous command (example)
    //RobotContainer.autonomousSequence.schedule();
  }

  /**
   * This function is called periodically during autonomous.
   */
  boolean p0 = true;
   boolean p1 = false;
   boolean p2 = false;
  @Override
  public void autonomousPeriodic() {
    if(p0 == true){
      RobotContainer.drive.schedule();
      p0 = false;
      p1 = true;
      p2 = false;
      System.out.println("-1-1");

    }
    if(p1 == true){
      RobotContainer.autonomousSequence.schedule();
      System.out.println("11");
      p0 = false;
      p1 = false;
      p2 = true;
    }else if(p2 == true){
      RobotContainer.arppoAutoShoot.schedule();
      System.out.println("00");
      p0 = false;
      p1 = false;
      p2 = false;

    }

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

  }

  /**
   * This function is called periodically during operator control.
   */
  boolean aim = false;
  boolean color = false;
  @Override
  public void teleopPeriodic() {
    boolean activate = RobotContainer.mechanismControl.GetB();
    if (activate == true) {
      RobotContainer.arppoAutoShoot.schedule();
    }else{
    }
    if(RobotContainer.arppoAutoShoot.isScheduled()){
      aim = true;
    }else{
      aim = false;
    }
    if(RobotContainer.colorSensor.isScheduled()){
      color = true;
    }else{
      color = false;
    }
    SmartDashboard.putBoolean("Aim", aim);
    SmartDashboard.putBoolean("Color", color);

    boolean detect = RobotContainer.mechanismControl.GetA();
    if(detect == true){
      RobotContainer.colorSensor.schedule();
    }
       
    boolean cancel = RobotContainer.mechanismControl.GetLP();
    if(cancel == true){
      RobotContainer.colorSensor.cancel();
      RobotContainer.arppoAutoShoot.cancel();

    }
    
    
  }


  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
