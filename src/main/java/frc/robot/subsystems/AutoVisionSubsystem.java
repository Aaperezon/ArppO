/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.MedianFilter;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
public class AutoVisionSubsystem extends SubsystemBase {
  /**
   * Creates a new AutoVisionSubsystem.
   */
  NetworkTableEntry targetX;
  NetworkTableEntry targetY;
  double yaw;
  double pitch;
  // distance in inches the robot wants to stay from an object
  private static final double kHoldDistance = 0;
  // proportional speed constant
  private static final double kP = .017;
  // integral speed constant
  private static final double kI = .01;
  // derivative speed constant
  private static final double kD = .002;
  private final MedianFilter m_filter = new MedianFilter(5);
  private final PIDController m_pidController = new PIDController(kP, kI, kD);
  private  NetworkTable table=NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");

  public AutoVisionSubsystem() {
    targetX=table.getEntry("targetYaw");   //Z
    targetY=table.getEntry("targetPitch"); //X
    m_pidController.setSetpoint(kHoldDistance);
  }

  @Override
  public void periodic() {
    setDefaultCommand(RobotContainer.autoVisionCommand);

    // This method will be called once per scheduler run
  }
  public void Run(boolean start){
    if (start == true)//the action button
    {
      yaw=targetX.getDouble(0.0);
      pitch=targetY.getDouble(0.0);

      double turn = m_pidController.calculate(m_filter.calculate(-yaw));
      System.out.println("Mover a:  "+turn+ "      ");

      //Output the power signals to a arcade drivetrain
      RobotContainer.chasis.arcadeDrive(0, turn);
    }
  }

/*
    Fetches the rotation and distance values from the vision co processor
    sets the value to 0.0 if the value doesnt exist in the database
*/
/*
rotationError=targetX.getDouble(0.0);
distanceError=targetY.getDouble(0.0);

/*
    Proportional (to targetX) control loop for rotation
    Deadzone of angleTolerance
    Constant power is added to the direction the control loop wants to turn (to overcome friction)
*/
/*
if(rotationError>angleTolerance)
    rotationAjust=KpRot*rotationError+constantForce;
else
    if(rotationError<angleTolerance)
        rotationAjust=KpRot*rotationError-constantForce;
/*
    Proportional (to targetY) control loop for distance
    Deadzone of distanceTolerance
    Constant power is added to the direction the control loop wants to turn (to overcome friction)
*/
/*
if(distanceError>distanceTolerance)
    distanceAjust=KpDist*distanceError+constantForce;
else
    if(distanceError<distanceTolerance)
        distanceAjust=KpDist*distanceError-constantForce;
*/

}
