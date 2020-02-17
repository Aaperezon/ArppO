/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CompressorSubsystem extends SubsystemBase {
  Compressor compressor = new Compressor();
  boolean cOn = false;
  boolean cOff = false;
  boolean comp = false;
  public CompressorSubsystem() {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.compressorCommand);
  }

  public void StartUp(boolean boton){
    if(cOn) {
      compressor.setClosedLoopControl(true);  
      comp = true;  
    }else{
      compressor.setClosedLoopControl(false); 
      comp = false;
    }
    if (boton == true) {
      if (!cOff) {
        cOn = !cOn;
        cOff = true;
      }
    }
    else {
      cOff = false;
    }

    SmartDashboard.putBoolean("Compressor", comp);
  }
}
