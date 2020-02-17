/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class FrikArppoRevSubsystem extends SubsystemBase {
  private Spark cSuperior = new Spark(Constants.ARPPOSUPERIOR);
  private Spark cInferior = new Spark(Constants.ARPPOINFERIOR);
  private Boolean mOn = false;
  private Boolean mOff = false;
  private double speed = .7;


  public FrikArppoRevSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.frikArppoRevCommand);
  }

  public void Rev(boolean speedUp){
    if(mOn) {
        cSuperior.set(speed);
        cInferior.set(-speed);
      }else{
        cSuperior.set(0);
        cInferior.set(0);
      }
      
      if (speedUp == true) {
        if (!mOff) {
          mOn = !mOn;
          mOff = true;
        }
      }
      else {
        mOff = false;
      }
  }

  public void Rev(double up, double down){
    cSuperior.set(up);
    cInferior.set(-down);

  }




}
