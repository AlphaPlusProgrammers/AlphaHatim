/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveSwerveCommand extends CommandBase {

    private DriveTrainSubsystem driveTrainSubsystem;

    /**
     * Creates a new driveSwerveCommand.
     */
    public DriveSwerveCommand(DriveTrainSubsystem driveTrainSubsystem) {
        // Use addRequirements() here to declare subsystem dependencies.

        this.driveTrainSubsystem = driveTrainSubsystem;
        addRequirements(this.driveTrainSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        driveTrainSubsystem.moveSwerveAxis(RobotContainer.getDriverAxis(Constants.driverLeftAxisX),
                RobotContainer.getDriverAxis(Constants.driverLeftAxisY),
                RobotContainer.getDriverAxis(Constants.driverRightAxisX),
                RobotContainer.getDriverAxis(Constants.driverRightAxisY),
                RobotContainer.getDriverAxis(Constants.driverLeftAxisTrigger),
                RobotContainer.getDriverAxis(Constants.driverRightAxisTrigger));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
