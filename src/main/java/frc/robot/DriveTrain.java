package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class DriveTrain {
    WPI_VictorSPX m_frontLeft = new WPI_VictorSPX(Constants.LEFT_M1);
    WPI_VictorSPX m_rearLeftFollower =  new WPI_VictorSPX(Constants.LEFT_M2);
    WPI_VictorSPX m_frontRight =  new WPI_VictorSPX(Constants.RIGHT_M1);
    WPI_VictorSPX m_rearRightFollower =  new WPI_VictorSPX(Constants.RIGHT_M2);
    public DriveTrain(){
        m_frontLeft.configFactoryDefault();
        m_rearLeftFollower.configFactoryDefault();
        m_frontRight.configFactoryDefault();
        m_rearRightFollower.configFactoryDefault();

        m_rearLeftFollower.follow(m_frontLeft);
        m_rearRightFollower.follow(m_frontRight);

        m_frontLeft.setInverted(false); // !< Update this
        m_frontRight.setInverted(false); // !< Update this

        m_rearLeftFollower.setInverted(false);
        m_rearRightFollower.setInverted(false);
        m_frontLeft.setInverted(false);
        m_frontRight.setInverted(false);

        //m_frontLeft.setSensorPhase(true);
        //m_frontRight.setSensorPhase(true);

    }
    public WPI_VictorSPX Leftcontroller(){

        return m_frontLeft;
    }
    public WPI_VictorSPX RightController(){
        return m_frontRight;

    }

    
}
