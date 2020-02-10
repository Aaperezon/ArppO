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
    //CHASIS GEARBOX PORTS
    public static final int CHASIS_LEFT = 8;
    public static final int CHASIS_RIGHT = 9;
   
    //** PNEUMATICS **//
    //SOLENOID PORTS FOR DATLIFT MECHANISM
    public static final int DAT_IN = 0;
    public static final int DAT_OUT = 1;
    //SOLENOID PORTS FOR PANCLSPINNER MECHANISM
    public static final int PANCL_IN = 2;
    public static final int PANCL_OUT = 3;
    //SOLENOID PORTS FOR ARPPO MECHANISM
    public static final int ARPPO_HOLD = 4;
    public static final int ARPPO_RELEASE = 5;


    
}
