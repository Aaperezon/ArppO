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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Relay;
public class GreenLightSubsystem extends SubsystemBase {


  Relay greenLED = new Relay(Constants.GREEN_LED);

  boolean lOn = false;
  boolean lOff = false;
  boolean activation;

  public GreenLightSubsystem() {

  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.greenLightCommand);
  }


  public void Activate(boolean act){
    if(lOn){
      greenLED.set(Relay.Value.kOff);
    activation = false;

  }else{
    greenLED.set(Relay.Value.kReverse);
    activation = true;
  }
  if (act == true) {
    if (!lOff) {
      lOn = !lOn;
      lOff = true;
    }
  }
  else {
    lOff = false;
  }
  SmartDashboard.putBoolean("Green LED", activation);
  }
}
