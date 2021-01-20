/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelSubsystem;

public class HandlerMotorCommand extends CommandBase {
    /**
     * Creates a new handlerMotorCommand.
     */
    private ControlPanelSubsystem controlPanelSubsystem;

    public HandlerMotorCommand(ControlPanelSubsystem controlPanelSubsystem) {
        this.controlPanelSubsystem = controlPanelSubsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(this.controlPanelSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        controlPanelSubsystem.moveHandlerMotor();
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
