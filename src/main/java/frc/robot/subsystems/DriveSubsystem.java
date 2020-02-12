/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Map;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

import frc.robot.RobotContainer;
/**
 * Add your docs here.
 */
public class DriveSubsystem extends SubsystemBase {
	private double speed = 1;
	private double speedV = .5;
	private double speedG = .8;
	private String direction;	

	/*
	private ShuffleboardTab tab = Shuffleboard.getTab("Drive");
	private NetworkTableEntry maxSpeed =
		tab.add("Max Speed", 1)
		.withWidget(BuiltInWidgets.kNumberSlider) // specify the widget here
		.getEntry();
	private double speed = maxSpeed.getDouble(1.0);
	private NetworkTableEntry maxSpeedV =
		tab.add("Max SpeedV", 1)
		.withWidget(BuiltInWidgets.kNumberSlider) // specify the widget here
		.getEntry();
	private double speedV = maxSpeedV.getDouble(1.0);
	
	private NetworkTableEntry maxSpeedG =
		tab.add("Max SpeedG", 1)
		.withWidget(BuiltInWidgets.kNumberSlider) // specify the widget here
		.getEntry();
	private double speedG = maxSpeedG.getDouble(1.0);
	*/
  public DriveSubsystem() {
  }

  @Override
  public void periodic() {
	setDefaultCommand(RobotContainer.driveCommand);
	//speed = maxSpeed.getDouble(1.0);
	//speedV = maxSpeedV.getDouble(1.0);
	//speedG = maxSpeedG.getDouble(1.0);
  }

  public void Dron(double Throttle1, double ThrottleTurn) {
		if (Throttle1 >= .1) {
			if (ThrottleTurn >= 0.1) {
				RobotContainer.chasis.tankDrive((Throttle1 * speed), (Throttle1 * speed) - (ThrottleTurn * speedV));
				direction = "Reverse-Right";
			} else if (ThrottleTurn <= -0.1) {
				RobotContainer.chasis.tankDrive((Throttle1 * speed) - (-ThrottleTurn * speedV), (Throttle1 * speed));
				direction = "Reverse-Left";
			} else {
				RobotContainer.chasis.tankDrive(Throttle1 * speed, Throttle1 * speed);
				direction = "Reverse";
			}
		} else if (Throttle1 <= -.1) {
			if (ThrottleTurn >= 0.1) {
				direction = "Forward-Right";
				RobotContainer.chasis.tankDrive((Throttle1 * speed), (Throttle1 * speed) - (-ThrottleTurn * speedV));
			} else if (ThrottleTurn <= -0.1) {
				direction = "Forward-Left";
				RobotContainer.chasis.tankDrive((Throttle1 * speed) - (ThrottleTurn * speedV), (Throttle1 * speed));
			} else {
				RobotContainer.chasis.tankDrive(Throttle1 * speed, Throttle1 * speed);
				direction = "Forward";
			}
		} else {
			RobotContainer.chasis.tankDrive(0, 0);
			direction = "Waiting";
		}
		SmartDashboard.putString("Direccion", direction);

	}

	public void Tank(double Throttle2, double Throttle1) {
		if (Throttle1 != 0 || Throttle2 != 0) {
			RobotContainer.chasis.tankDrive(Throttle1 * speed, Throttle2 * speed);
		} else {
			RobotContainer.chasis.tankDrive(0, 0);
		}
	}

	public void F1(double Throttle1, double Throttle2, double ThrottleTurn) {
		if (Throttle2 >= .1) {
			if (ThrottleTurn >= 0.1) {
				RobotContainer.chasis.tankDrive(Throttle2 * speed, (Throttle2 * speed) - (ThrottleTurn * speedV));
			} else if (ThrottleTurn <= -0.1) {
				RobotContainer.chasis.tankDrive((Throttle2 * speed) - (-ThrottleTurn * speedV), Throttle2 * speed);
			} else {
				RobotContainer.chasis.tankDrive(Throttle2 * speed, Throttle2 * speed);
			}
		} else if (Throttle1 >= .1) {
			if (ThrottleTurn >= 0.1) {
				RobotContainer.chasis.tankDrive(-Throttle1 * speed, (-Throttle1 * speed) - (-ThrottleTurn * speedV));
			} else if (ThrottleTurn <= -0.1) {
				RobotContainer.chasis.tankDrive((-Throttle1 * speed) - (ThrottleTurn * speedV), -Throttle1 * speed);
			} else {
				RobotContainer.chasis.tankDrive(-Throttle1 * speed, -Throttle1 * speed);
			}
		} else {
			RobotContainer.chasis.tankDrive(0, 0);
		}
	}

	public void F1_Volante(double Throttle1, double Throttle2, double ThrottleTurn) {
		//System.out.println("Acelerador: "+Throttle2+"Reversa: "+ Throttle1+ "Vuelta: "+ThrottleTurn);
		ThrottleTurn = ThrottleTurn*5;
		if (Throttle2 < 1) {

			if (ThrottleTurn >= 0.1) {
				RobotContainer.chasis.tankDrive(1-Throttle2 * speed, (1-Throttle2 * speed) - (ThrottleTurn * speedV));
			} else if (ThrottleTurn <= -0.1) {
				RobotContainer.chasis.tankDrive((1-Throttle2 * speed) - (-ThrottleTurn * speedV), 1-Throttle2 * speed);
			} else {
				RobotContainer.chasis.tankDrive(1-Throttle2 * speed, 1-Throttle2 * speed);
			}
		}else if (Throttle1 < 1) {
			if (ThrottleTurn >= 0.1) {
				RobotContainer.chasis.tankDrive(-1*(1-Throttle1) * speed, (-1*(1-Throttle1) * speed) - (-ThrottleTurn * speedV));
			} else if (ThrottleTurn <= -0.1) {
				RobotContainer.chasis.tankDrive((-1*(1-Throttle1) * speed) - (ThrottleTurn * speedV), -1*(1-Throttle1) * speed);
			} else {
				RobotContainer.chasis.tankDrive(-1*(1-Throttle1) * speed, -1*(1-Throttle1) * speed);
			}
		} else {
			RobotContainer.chasis.tankDrive(0, 0);
		}
	}


	public void GirarSobreEje(boolean LeftSpin, boolean RightSpin) {
		if (LeftSpin == true) {
			RobotContainer.chasis.tankDrive(-speedG, speedG);
			direction = "Left-Spin";
		}
		if (RightSpin == true) {
			RobotContainer.chasis.tankDrive(speedG, -speedG);
			direction = "Right-Spin";
		}
		SmartDashboard.putString("Direccion", direction);
	}

  






}
