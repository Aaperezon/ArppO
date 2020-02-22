/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import com.analog.adis16448.frc.ADIS16448_IMU;
import edu.wpi.first.wpilibj.MedianFilter;
import edu.wpi.first.wpilibj.controller.PIDController;
public class AutonomousGyroSubsystem extends SubsystemBase {
  /**
   * Creates a new GyroSubsystem.
   */
  // distance in inches the robot wants to stay from an object
  private static double kHoldPosition = 0;
  // proportional speed constant
  private static final double kP = 40;  //.035
  // integral speed constant
  private static final double kI = .15; //.013
  // derivative speed constant
  private static final double kD = .24; //.002
  private final MedianFilter m_filter = new MedianFilter(5);
  private final PIDController m_pidController = new PIDController(kP, kI, kD);

  Gyro gyro = new ADIS16448_IMU();

  public AutonomousGyroSubsystem() {
    gyro.reset();
    m_pidController.setSetpoint(kHoldPosition);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void SetDegree(double deg){
    gyro.reset();
    kHoldPosition = deg;
    m_pidController.setSetpoint(kHoldPosition);

  }

  public void See(boolean action){
    if(action){
      System.out.println("Angle: "+gyro.getRate());
    }

  }
  int cont = 0;
  public boolean Go(){
    double angle = gyro.getAngle();
    double turn = m_pidController.calculate(m_filter.calculate(angle));
    System.out.println("Mover a:  "+kHoldPosition+ "      " + "Angulo Actual: "+angle+"    Velocidad: "+turn);
    //Output the power signals to a arcade drivetrain
    RobotContainer.chasis.tankDrive(turn, -turn);

    if(angle <= (kHoldPosition+1) && angle >= (kHoldPosition-1) ){
      cont++;
    }else{
      cont=0;
    }
    if(cont >= 3){
      return true;
    }
    else{
      return false;
    }
  }
  
}
