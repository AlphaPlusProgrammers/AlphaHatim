/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LauncherMotorPID;

public class HeresTheWindUp extends CommandBase {
  /**
   * Creates a new HeresTheWindUp.
   */
  private LauncherMotorPID launcherMotorPID;
  public HeresTheWindUp(LauncherMotorPID launcherMotorPID) {
    this.launcherMotorPID = launcherMotorPID;
    addRequirements(this.launcherMotorPID);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    launcherMotorPID.windUp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    launcherMotorPID.windDown();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return RobotContainer.stopWindin();
  }
}
