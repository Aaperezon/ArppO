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
public class ArppoAimSubsystem extends SubsystemBase {
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
  private static final double kP = .027;  //.027
  // integral speed constant
  private static final double kI = .01; //.01
  // derivative speed constant
  private static final double kD = .005; //.005
  private final MedianFilter m_filter = new MedianFilter(5);
  private final PIDController m_pidController = new PIDController(kP, kI, kD);
  private  NetworkTable table=NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");
  private int yawTolerance = 20;
  private int pitchTolerance = 20;
  private int yawCount =0;
  private int pitchCount =0;
  public ArppoAimSubsystem() {
    targetX=table.getEntry("targetYaw");   //Z
    targetY=table.getEntry("targetPitch"); //X
    m_pidController.setSetpoint(kHoldDistance);
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }
  int dCount = 0;
  public boolean Run(){
    yaw=targetX.getDouble(0.0);
    pitch=targetY.getDouble(0.0);

    double setYaw = m_pidController.calculate(m_filter.calculate(-yaw));
    double setPitch = m_pidController.calculate(m_filter.calculate(-yaw));
    //System.out.println("Mover a:  "+setYaw+ "      "+setPitch);

    //RobotContainer.frikArppoAimSubsystem.Aim(pitch, yaw);

    dCount++;
    if(dCount>=150){
      dCount =0;
      return true;
    }else{
      System.out.println("Aim...");
      return false;

    }
    /*
    if(setPitch>=-.1 && setPitch<=.1){
      pitchCount++;
    }
    if(setYaw>=-.1 && setYaw<=.1){
      yawCount++;
    }

    if(pitchCount >= pitchTolerance && yawCount >= yawTolerance){
      pitchCount=0;
      yawCount=0;
      return true;
    }
    else{
      pitchCount=0;
      yawCount=0;
      return false;
    }
  */

  }


}
