/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArppoShootSubsystem extends SubsystemBase {
  /**
   * Creates a new ArppoShootSubsystem.
   */
  public ArppoShootSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  int dCount =0;
  public boolean Run(){
    dCount++;
    if(dCount>=40){
      dCount=0;
      return true;
    }else{
      System.out.println("Shoot...");
      return false;

    }
  } 




}
