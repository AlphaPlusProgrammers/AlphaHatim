/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.RobotContainer;

public class LauncherPIDSubsystem extends PIDSubsystem {

    private CANSparkMax launcherMotorMaster;
    private CANSparkMax launcherMotorSlave;

    public double finalSpeed;
    public boolean active;

    /**
     * Creates a new LauncherPIDSubsystem.
     */
    public LauncherPIDSubsystem() {
        super(
                // The PIDController used by the subsystem
                new PIDController(0, 0, 0));

        launcherMotorMaster = new CANSparkMax(13, MotorType.kBrushless);
        launcherMotorSlave = new CANSparkMax(14, MotorType.kBrushless);

        // aimingMotor = new TalonSRX(11);

        finalSpeed = 0;
        active = false;

        setMaster();
    }

    @Override
    public void useOutput(double output, double setpoint) {
        // Use the output here
        // aimingMotor.set(ControlMode.PercentOutput, output);
    }

    @Override
    public double getMeasurement() {
        // Return the process variable measurement here
        return RobotContainer.sensorsSubsystem.linearEncoderValue;
    }

    public void setMaster() {
        launcherMotorSlave.follow(launcherMotorMaster);
    }

    public void MotorStop() {
        // setting speed for sparkMax motor controllers -cory
        launcherMotorMaster.set(0);
        finalSpeed = 0;
    }

    public final void finalSpeedReset() {
        finalSpeed = 0;
    }

    public void motorRun() {
        finalSpeed += 0.01;
        launcherMotorMaster.set(finalSpeed);
    }
}
