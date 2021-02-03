/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class LauncherMotorPID extends PIDSubsystem {
  /**
   * Creates a new LauncherMotorPID.
   */
    private CANSparkMax launcherMotorMaster;
    private CANSparkMax launcherMoterSlave;

    public double finalSpeed;
    public boolean active;

  public LauncherMotorPID() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0, 0, 0));

        launcherMoterSlave = new CANSparkMax(13, MotorType.kBrushless);
        launcherMotorMaster = new CANSparkMax(14, MotorType.kBrushless);

        finalSpeed = 0;
        active = false;

        setMaster();
  }

  @Override
  public void useOutput(final double output, final double setpoint) {
    // Use the output here
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return 0;
  }

  public void setMaster(){
    launcherMoterSlave.follow(launcherMotorMaster);
  }

  public void windUp(){
    finalSpeed+=.01;
    launcherMotorMaster.set(finalSpeed);
  }

  public void windDown(){
    finalSpeed = 0;
    launcherMotorMaster.set(0);
  }

  public void speedReset(){
    finalSpeed = 0;
  }
}
