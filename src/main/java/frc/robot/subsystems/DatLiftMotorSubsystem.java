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
public class DatLiftMotorSubsystem extends SubsystemBase {

  Spark motor1 = new Spark(Constants.DATLIFT_MOTOR1);
  Spark motor2 = new Spark(Constants.DATLIFT_MOTOR2);
  public DatLiftMotorSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.datLiftMotorCommand);
  }

  public void StartUp(double action1, double action2){
    if(action1 >= .1){
      motor1.set(action1);
      motor2.set(action1);
    }
    else if(action2 >= .1){
      motor1.set(-action2);
      motor2.set(-action2);
    }
    else{
      motor1.set(0);
      motor2.set(0);
    }
  }

}
