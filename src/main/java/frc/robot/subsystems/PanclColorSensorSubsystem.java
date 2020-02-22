/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.DriverStation;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
public class PanclColorSensorSubsystem extends SubsystemBase {
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();


  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  String colorString;

  public PanclColorSensorSubsystem() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(RobotContainer.panclColorSensorCommand);
    
  }
  public void Data(){
    
  
  }
  public String ColorMatch(boolean action){
    if(action == true){
      Color detectedColor = m_colorSensor.getColor();
      ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
      if (match.color == kBlueTarget) {
        colorString = "Blue";
      } else if (match.color == kRedTarget) {
        colorString = "Red";
      } else if (match.color == kGreenTarget) {
        colorString = "Green";
      } else if (match.color == kYellowTarget) {
        colorString = "Yellow";
      } else {
        colorString = "null";
      }
      
      /*
      SmartDashboard.putNumber("Red", detectedColor.red);
      SmartDashboard.putNumber("Green", detectedColor.green);
      SmartDashboard.putNumber("Blue", detectedColor.blue);
      SmartDashboard.putNumber("Confidence", match.confidence);
      */
      SmartDashboard.putString("Detected Color", colorString);
      SmartDashboard.putString("Color Auto", colorSelection);

      return colorString;
    }else{
      return colorString;
    }
  }
  public static String colorSelection = "null";

  public boolean SetColor(){
    colorSelection = ColorMatch(true);
    if(colorSelection != "null"){
      //System.out.println("El color es "+colorSelection);
      return true;
    }else{
      return false;
    }
  }

  int count = 0;
  boolean spin = true;
  public boolean SpinUntilColor(){
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
          colorSelection = "Blue";
          break;
        case 'G' :
          colorSelection = "Green";
          break;
        case 'R' :
          colorSelection = "Red ";
          break;
        case 'Y' :
          colorSelection = "Yellow ";
          break;
        default :
          break;
      }
      

      do{
        String color = ColorMatch(true);

  
        RobotContainer.panclSpinnerSubsystem.StartUp(.8);
        
        if(color!=colorSelection && color != "null"){
          spin = false;
        }else if(color == "null"){
          spin = true;
        }
        if(spin == false && color == colorSelection){
          count++;
          spin = true;
          //System.out.println("Se encontro "+count+" veces");
        }
      
        SmartDashboard.putNumber("Count", count);

      }while(count <1);
      RobotContainer.panclSpinnerSubsystem.StartUp(0);
      count = 0;
      spin = true;
      colorSelection = "null";



    } else {

      do{
        String color = ColorMatch(true);
        RobotContainer.panclSpinnerSubsystem.StartUp(.8);
        if(color!=colorSelection && color != "null"){
          spin = false;
        }else if(color == "null"){
          spin = true;
        }
        if(spin == false && color == colorSelection){
          count++;
          spin = true;
          System.out.println("Se encontro "+count+" veces");
        }
      
        SmartDashboard.putNumber("Count", count);

      }while(count <= 3);
      RobotContainer.panclSpinnerSubsystem.StartUp(0);
      count = 0;
      spin = true;
      colorSelection = "null";
    }
    return true;


  }



}
