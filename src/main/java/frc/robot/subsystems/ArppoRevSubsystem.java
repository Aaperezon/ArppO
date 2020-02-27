/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class ArppoRevSubsystem extends SubsystemBase {
  /**
   * Creates a new ArppoRevSubsystem.
   */
  public ArppoRevSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  int dCount =0;
  public void Run(){
    RobotContainer.frikArppoRevSubsystem.Rev(.6, 1); //.6 ; .8
    /*
    dCount++;
    if(dCount>=50){
      dCount=0;
      return true;
    }else{
      //System.out.println("Rev...");
      return false;

    }
    */
  }


}
