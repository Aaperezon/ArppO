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
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.MedianFilter;

public class AutonomousDriveSubsystem extends SubsystemBase {
  Encoder encLeft;
  Encoder encRight;
  private static final double whd = 6; // for 6 inch wheel

  private static final double cpr = 360; //if am-3132


   // distance in inches the robot wants to stay from an object
   private double kHoldPosition = 0;
   // proportional speed constant
   private static final double kP = 1;  //.035
   // integral speed constant
   private static final double kI = .1; //.013
   // derivative speed constant
   private static final double kD = .07; //.002
   private static MedianFilter m_filter  = new MedianFilter(5);
   private static PIDController m_pidController = new PIDController(kP, kI, kD);




  public AutonomousDriveSubsystem() {
    encLeft = new Encoder(Constants.ENC_LEFT1,Constants.ENC_LEFT2);
    encLeft.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)

    encRight = new Encoder(Constants.ENC_RIGHT1,Constants.ENC_RIGHT2);
    encRight.setDistancePerPulse(Math.PI*whd/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void SetDistance(double distance){
    m_pidController.setSetpoint(distance);
    kHoldPosition = distance;

  }
  int cont = 0;
  double margin = 10;
  public boolean GoTo(){
    double speed1 = m_pidController.calculate(m_filter.calculate(GetDistanceLeft()));
    double speed2 = m_pidController.calculate(m_filter.calculate(GetDistanceRight()));

    RobotContainer.chasis.tankDrive(speed1, speed2);
    if(GetDistanceLeft() < (kHoldPosition+margin) && GetDistanceLeft()>(kHoldPosition-margin) && GetDistanceRight() < (kHoldPosition+margin) && GetDistanceRight()>(kHoldPosition-margin)  ){
      cont++;
    }
    else{
      cont = 0;
    }
    System.out.println(GetDistanceLeft() + " < "+(kHoldPosition+margin) + "     "+ GetDistanceLeft() + " > "+(kHoldPosition-margin) + "     "+GetDistanceRight() + " < "+ (kHoldPosition+margin + "  ") + "      " + GetDistanceRight() + " > " +(kHoldPosition-margin));
    
    if(cont > 10){
      encLeft.reset();
      encRight.reset();
      cont = 0;
      return true;
    }
    else{
      return false;
    }
  }

  public double GetDistanceLeft(){
    double dist = encLeft.getDistance();
    SmartDashboard.putNumber("EncoderLeft", dist);
    return dist;
  }
  public double GetDistanceRight(){
    double dist = encRight.getDistance();
    SmartDashboard.putNumber("EncoderRight", dist);
    return dist;
  }




}
