/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
public class FrikLimitSubsystem extends SubsystemBase {
  DigitalInput upperLimit = new DigitalInput(Constants.FRIK_UP);
  DigitalInput lowerLimit = new DigitalInput(Constants.FRIK_LOW );

  public FrikLimitSubsystem() {

  }

  @Override
  public void periodic() {
  }

  public boolean UpperLimitFree(){
    if(upperLimit.get()){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean LowerLimitFree(){
    if(lowerLimit.get()){
      return true;
    }
    else{
      return false;
    }
  }




}
