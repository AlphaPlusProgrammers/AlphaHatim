/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimbingSubsystem;

public class ClimbMotorCommand extends CommandBase {
    /**
     * Creates a new ClimbMotorCom.
     */
    private ClimbingSubsystem climbingSubsystem;

    public ClimbMotorCommand(ClimbingSubsystem climbingSubsystem) {
        this.climbingSubsystem = climbingSubsystem;
        addRequirements(this.climbingSubsystem);
        // Use addRequirements() here to declare subsystem dependencies.
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        climbingSubsystem.runClimbMotor();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        climbingSubsystem.stopClimbMotor();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return !RobotContainer.climbButtonValue();
    }
}
