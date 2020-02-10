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
import edu.wpi.first.wpilibj.DoubleSolenoid;
public class ArppoSubsystem extends SubsystemBase {
  private Spark pitchmotor = new Spark(Constants.ARPPOPITCHPORT);

  private double speed = .7;
  private Spark cSuperior = new Spark(Constants.ARPPOSUPERIOR);
  private Spark cInferior = new Spark(Constants.ARPPOINFERIOR);
  private Boolean mOn = false;
  private Boolean mOff = false;

  private DoubleSolenoid piston = new DoubleSolenoid(Constants.ARPPO_HOLD, Constants.ARPPO_RELEASE);
  private boolean pOn = false;
  private boolean pOff = false;
  public ArppoSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.arppoCommand);
  }
  public void ManualAim(double yaw, double pitch, boolean speedUp, boolean shoot){
    if(yaw >= .1 || yaw <= -1){
      RobotContainer.chasis.arcadeDrive(0, yaw);
    }
    else{
      RobotContainer.chasis.arcadeDrive(0, 0);
    }
    if(pitch >= .1 || pitch <= -.1){
      pitchmotor.set(pitch);
    }
    else{
      pitchmotor.set(0);
    }

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

    if(pOn) {
      piston.set(DoubleSolenoid.Value.kForward);
    }else{
      piston.set(DoubleSolenoid.Value.kReverse);
    }
    if (shoot == true) {
      if (!pOff) {
        pOn = !pOn;
        pOff = true;
      }
    }
    else {
      pOff = false;
    }


  }






}
