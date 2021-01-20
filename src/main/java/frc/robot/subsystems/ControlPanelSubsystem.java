/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;

public class ControlPanelSubsystem extends SubsystemBase {
    /**
     * Creates a new ControlPanelSubsystem.
     */
    private TalonSRX controlPanelMotor;

    private Solenoid controlPanelSol;

    public boolean handlerPosition;

    private int i;

    public ControlPanelSubsystem() {

        controlPanelMotor = new TalonSRX(12);

        controlPanelSol = new Solenoid(0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void moveHandlerOut() {
        controlPanelSol.set(true);
    }

    public void moveHandlerIn() {
        controlPanelSol.set(false);
    }

    public void moveControlPanel() {
        controlPanelMotor.set(ControlMode.PercentOutput, 1);
    }

    public void handlerPositionSetting() {
        if (handlerPosition) {
            moveHandlerOut();
        } else {
            moveHandlerIn();
        }
    }

    public void setHandlerBoolean() {
        if (i == 0 && RobotContainer.handlerPositionValue()) {
            handlerPosition = !handlerPosition;
            i++;
        } else if (!RobotContainer.handlerPositionValue()) {
            i = 0;
        }
    }

    public void moveHandlerMotor() {
        controlPanelMotor.set(ControlMode.PercentOutput, Constants.handlerMotorSpeed);
    }
}