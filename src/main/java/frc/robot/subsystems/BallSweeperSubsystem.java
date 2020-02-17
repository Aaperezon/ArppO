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
import edu.wpi.first.wpilibj.Spark;
public class BallSweeperSubsystem extends SubsystemBase {
  private Spark motor = new Spark(Constants.BALLSWEEPERPORT);
  private Boolean mOn = false;
  private Boolean mOff = false;

  public BallSweeperSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.ballSweeperCommand);
  }


  public void StartUp(boolean boton){
    if(mOn) {
      motor.set(.7);
    }else{
      motor.set(0);
    }
    if (boton == true) {
      if (!mOff) {
        mOn = !mOn;
        mOff = true;
      }
    }
    else {
      mOff = false;
    }

  }
}
