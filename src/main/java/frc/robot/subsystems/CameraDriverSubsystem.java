/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
public class CameraDriverSubsystem extends SubsystemBase {
  NetworkTableEntry isDriverMode;
  NetworkTableEntry isValid;
  NetworkTable table=NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");
  public CameraDriverSubsystem() {
    isDriverMode = table.getEntry("driverMode");
    isValid = table.getEntry("isValid");
  }
  @Override
  public void periodic() {
	  setDefaultCommand(RobotContainer.cameraDriverCommand);
    // This method will be called once per scheduler run
  }
  public void Run(boolean action){
      isDriverMode.setBoolean(action);
      isValid.setBoolean(!action);
  }
}
