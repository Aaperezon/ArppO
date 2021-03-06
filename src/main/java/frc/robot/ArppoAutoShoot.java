/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AimUpwardCommand;
import frc.robot.commands.ArppoAimCommand;
import frc.robot.commands.ArppoRevCommand;
import frc.robot.commands.ArppoRevFinalCommand;
import frc.robot.commands.ArppoShootCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ArppoAutoShoot extends SequentialCommandGroup {
  /**
   * Creates a new ArppoAutoShoot.
   */
  public ArppoAutoShoot() {
    super(
      new ParallelCommandGroup(
        new ArppoAimCommand(),
        new ArppoRevCommand()
      ),
      new ParallelCommandGroup(
        new ArppoRevFinalCommand(),
        new ArppoShootCommand())

    );
  }
}
