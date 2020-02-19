/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
public class ArppoShootSubsystem extends SubsystemBase {

  boolean pOn = false;
  boolean pOff = false;
  long endTime;
  long time = 3000;

  public ArppoShootSubsystem() {
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  int dCount =0;
  public void Run(){
    RobotContainer.frikArppoShootSubsystem.Release();
    /*
    dCount++;
    if(dCount>=1000){
      dCount=0;
      RobotContainer.frikArppoShootSubsystem.Hold();
      return true;
    }else{
      //System.out.println("Shoot...");
      return false;

    }
    */
  } 




}
