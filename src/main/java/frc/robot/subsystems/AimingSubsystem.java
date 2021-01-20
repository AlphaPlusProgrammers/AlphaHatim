/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AimingSubsystem extends SubsystemBase {
    /**
     * Creates a new aimingSubsystem.
     */
    private TalonSRX aimingMotor;

    public AimingSubsystem() {
        aimingMotor = new TalonSRX(11);

    }

    @Override
    public void periodic() {
        setMinMax();
        // This method will be called once per scheduler run
    }

    public void raiseIntake() {
        aimingMotor.set(ControlMode.PercentOutput, .3);
    }

    public void lowerIntake() {
        aimingMotor.set(ControlMode.PercentOutput, -.3);
    }

    public void setMinMax() {
        aimingMotor.configPeakOutputForward(1);
        aimingMotor.configPeakOutputReverse(-1);
    }

    public void killMotors() {
        aimingMotor.set(ControlMode.PercentOutput, 0);
    }
}
