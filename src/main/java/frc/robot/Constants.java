/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //CHASIS CAN DEVICE
    public static final int LEFT_M1 = 3;
    public static final int LEFT_M2 = 1;
    public static final int RIGHT_M1 = 0;
    public static final int RIGHT_M2 = 2;

    // NUMBER OF CONTROLLER FOR DRIVERS
    public static final int NUM_DRIVER_CONTROLLER = 0;
    public static final int NUM_MECHANISM_CONTROLLER = 1;
    

    //** PWM **//
    //BALLSWEEPER MOTOR PORT 
    public static final int BALLSWEEPERPORT = 0;
    //PANCLSPINNER MOTOR PORT
    public static final int PANCLSPINNERPORT = 1;
    //ARPPO MOTOR PORT
    public static final int ARPPOPITCHPORT = 2;
    public static final int ARPPOSUPERIOR = 3;
    public static final int ARPPOINFERIOR = 4;
    //DATLIFT MOTOR
    public static final int DATLIFT_MOTOR1 = 5;
    public static final int DATLIFT_MOTOR2 = 6;
    //CHASIS GEARBOX PORTS
    public static final int CHASIS_LEFT = 8;
    public static final int CHASIS_RIGHT = 9;
    
    //** PNEUMATICS **//
    //SOLENOID PORTS FOR DATLIFT MECHANISM
    public static final int DAT_IN = 0;
    public static final int DAT_OUT = 1;
    //SOLENOID PORTS FOR PANCLSPINNER MECHANISM
    public static final int PANCL_IN = 3;
    public static final int PANCL_OUT = 2;
    //SOLENOID PORTS FOR ARPPO MECHANISM
    public static final int ARPPO_HOLD = 4;
    public static final int ARPPO_RELEASE = 5;


    //** DIGITAL INPUTS **//
    //LIMIT SWITCHES FOR ARPPO
    public static final int FRIK_UP = 1;
    public static final int FRIK_LOW = 0;
    public static final int ENC_LEFT1 = 2;
    public static final int ENC_LEFT2 = 3;
    public static final int ENC_RIGHT1 = 4;
    public static final int ENC_RIGHT2 = 5;
    //** RELAY PORT **/
    public static final int GREEN_LED = 3;


    
}
