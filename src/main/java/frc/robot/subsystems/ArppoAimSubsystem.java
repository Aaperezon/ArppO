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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  private static final double kTargetPitch = -3;
  private static final double kTargetYaw = 17;

  private static final double kPpitch = .1;  //.027
  private static final double kIpitch = .01; //.01
  private static final double kDpitch = .005; //.005

  private final MedianFilter m_filterPitch = new MedianFilter(5);
  private final PIDController m_pidControllerPitch = new PIDController(kPpitch, kIpitch, kDpitch);
  private  NetworkTable table=NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("Microsoft LifeCam HD-3000");
  private int yawTolerance = 200;
  private int pitchTolerance = 200;
  private int yawCount =0;
  private int pitchCount =0;

  private static final double kPyaw = .07;  //.027
  private static final double kIyaw = .015; //.01
  private static final double kDyaw = .013; //.005
  private final MedianFilter m_filterYaw = new MedianFilter(5);
  private final PIDController m_pidControllerYaw = new PIDController(kPyaw, kIyaw, kDyaw);
  private double areaTolerance = 6;

  public ArppoAimSubsystem() {
    targetX=table.getEntry("targetYaw");   //Z
    targetY=table.getEntry("targetPitch"); //X
    m_pidControllerPitch.setSetpoint(kTargetPitch);
    m_pidControllerYaw.setSetpoint(kTargetYaw);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  boolean p = false;
  boolean y= false;
  //int dCount = 0;
  public boolean Run(){
    yaw=targetX.getDouble(0.0);
    pitch=targetY.getDouble(0.0);

    double setYaw = m_pidControllerYaw.calculate(m_filterYaw.calculate(-yaw));
    double setPitch = m_pidControllerPitch.calculate(m_filterPitch.calculate(pitch));
    //System.out.println("Mover a:  "+setPitch+ "      "+setYaw);

    RobotContainer.frikArppoAimSubsystem.Aim(setPitch, setYaw);
    /*
    dCount++;
    if(dCount>=150){
      dCount =0;
      return true;
    }else{
      System.out.println("Aim...");
      return false;
    }
    */
    //System.out.println(pitch+" <= "+(kTargetPitch+areaTolerance)+"   "+pitch+" >= "+(kTargetPitch-areaTolerance));

    if(pitch<=(kTargetPitch+areaTolerance) && pitch>=(kTargetPitch-areaTolerance)){
      pitchCount++;
      p=true;
    }
    else{
      p=false;
    }
    if(yaw<=(-kTargetYaw+areaTolerance) && yaw>=(-kTargetYaw-areaTolerance)){
      yawCount++;
      y=true;
    }
    else{
      y=false;
    }

    SmartDashboard.putBoolean("Pitch", p);
    SmartDashboard.putBoolean("Yaw", y);
    if(pitchCount >= pitchTolerance && yawCount >= yawTolerance){
      pitchCount=0;
      yawCount=0;
      return true;
    }
    else{
      return false;
    }
  }
}
