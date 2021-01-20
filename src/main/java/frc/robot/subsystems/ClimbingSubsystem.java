/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;

public class ClimbingSubsystem extends SubsystemBase {
    /**
     * Creates a new ClimbingSubsystem.
     */
    private TalonSRX climbingMotor;
    private Solenoid climbingSol;

    public ClimbingSubsystem() {

        climbingMotor = new TalonSRX(9);
        climbingSol = new Solenoid(2);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void putClimberUp() {
        climbingSol.set(true);
    }

    public void putClimberDown() {
        climbingSol.set(false);
    }

    public void runClimbMotor() {
        climbingMotor.set(ControlMode.PercentOutput, .5);
    }

    public void stopClimbMotor() {
        climbingMotor.set(ControlMode.PercentOutput, 0);
    }

    public void climbMotor() {
        if (RobotContainer.climbButtonValue() == true) {
            runClimbMotor();
        } else {
            stopClimbMotor();
        }
    }

}
