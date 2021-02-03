/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.security.PrivilegedActionException;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  //private final LauncherMotorPID launcherMotorPID = new LauncherMotorPID();
  public static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static final ClimbingSubsystem climbingSubsystem = new ClimbingSubsystem();
  public static final ControlPanelSubsystem controlPanelSubsystem = new ControlPanelSubsystem();
  public static final SensorsSubsystem sensorsSubsystem = new SensorsSubsystem();
  public static final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
  public static final AimingSubsystem aimingSubsystem = new AimingSubsystem();

  //private final HeresTheWindUp heresTheWindUp = new HeresTheWindUp(launcherMotorPID);
  private final AimingCommandDown aimingCommandDown = new AimingCommandDown(aimingSubsystem);
  private final AimingCommand aimingCommand = new AimingCommand(aimingSubsystem);
  private final DriveSwerveCommand driveSwerveCommand = new DriveSwerveCommand(driveTrainSubsystem);
  private final StrafeEasyModeCommand strafeEasyModeCommand = new StrafeEasyModeCommand(driveTrainSubsystem);
  private final PointTurnCommand pointTurnCommand = new PointTurnCommand(driveTrainSubsystem);
  private final FlopIntakeInCommand flopIntakeInCommand = new FlopIntakeInCommand(intakeSubsystem);
  private final FlopIntakeOutCommand flopIntakeOutCommand = new FlopIntakeOutCommand(intakeSubsystem);
  private final HandlerBooleanCommand handlerBooleanCommand = new HandlerBooleanCommand(controlPanelSubsystem);
  private final ChangeHandlerPositionCommand changeHandlerPositionCommand = new ChangeHandlerPositionCommand(controlPanelSubsystem);
  private final HandlerMotorCommand handlerMotorCommand = new HandlerMotorCommand(controlPanelSubsystem);
  private final ClimbSolenoidCom climbSolenoidCom = new ClimbSolenoidCom(climbingSubsystem);
  private final ClimbMotorCommand climbMotorCommand = new ClimbMotorCommand(climbingSubsystem);
  private final DisengageStopBallSolenoid disengageStopBallSolenoid = new DisengageStopBallSolenoid(intakeSubsystem);
  private final TargetWithLimelightCommand targetWithLimelightCommand = new TargetWithLimelightCommand(driveTrainSubsystem);

  /**
   * The Driver Joystick declaration and the button definitions associated with it.
   */

  private static final Joystick driverJoystick = new Joystick(0);
  
  private final JoystickButton targetWithLimelightButton = new JoystickButton(driverJoystick, Constants.driverButtonA);
  private final JoystickButton driverButtonB = new JoystickButton(driverJoystick, Constants.driverButtonB);
  private final JoystickButton driverButtonX = new JoystickButton(driverJoystick, Constants.driverButtonX);
  private final JoystickButton driverButtonY = new JoystickButton(driverJoystick, Constants.driverButtonY);
  private final JoystickButton strafeEasyModeButton = new JoystickButton(driverJoystick, Constants.driverButtonLB);
  private final JoystickButton pointTurnButton = new JoystickButton(driverJoystick, Constants.driverButtonRB);
  private final JoystickButton driverButtonBack = new JoystickButton(driverJoystick, Constants.driverButtonBack);
  private final JoystickButton driverButtonStart = new JoystickButton(driverJoystick, Constants.driverButtonStart);
  private final JoystickButton driverButtonLeftJoyClick = new JoystickButton(driverJoystick, Constants.driverButtonLeftJoyClick);
  private final JoystickButton driverButtonRightJoyClick = new JoystickButton(driverJoystick, Constants.driverButtonRightJoyClick);

  /**
   * The Operator Joystick declaration and the button definitions associated with it.
   */ 

  private static final Joystick operatorJoystick = new Joystick(1);

  private final static JoystickButton changeHandlerPositionButton = new JoystickButton(operatorJoystick, Constants.operatorButtonRightJoyClick);
  private final static JoystickButton windLauncherUpButton = new JoystickButton(operatorJoystick, Constants.operatorButtonX);
  private final static JoystickButton windLauncherDownButton = new JoystickButton(operatorJoystick, Constants.operatorButtonY);
  private final JoystickButton flopIntakeInButton = new JoystickButton(operatorJoystick, Constants.operatorButtonA);
  private final JoystickButton flopIntakeOutButton = new JoystickButton(operatorJoystick, Constants.operatorButtonB);
  private final static JoystickButton lowerLauncherButton  = new JoystickButton(operatorJoystick, Constants.operatorButtonLB);
  private final static JoystickButton raiseLauncherButton = new JoystickButton(operatorJoystick, Constants.operatorButtonRB);
  private final static JoystickButton runWinchButton = new JoystickButton(operatorJoystick, Constants.operatorButtonBack);
  private final JoystickButton expelClimberButton = new JoystickButton(operatorJoystick, Constants.operatorButtonStart);
  private final static JoystickButton disengageStopBallSoneloidButton = new JoystickButton(operatorJoystick, Constants.operatorButtonLeftJoyClick);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    driveTrainSubsystem.setDefaultCommand(driveSwerveCommand);
    intakeSubsystem.setDefaultCommand(flopIntakeInCommand);
    controlPanelSubsystem.setDefaultCommand(changeHandlerPositionCommand);
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    pointTurnButton.whileHeld(pointTurnCommand, true);
    strafeEasyModeButton.whileHeld(strafeEasyModeCommand, true);

    runWinchButton.whenPressed(climbMotorCommand, true);
    expelClimberButton.whenPressed(climbSolenoidCom, true);

    changeHandlerPositionButton.whenPressed(changeHandlerPositionCommand, true);

    flopIntakeInButton.whenPressed(flopIntakeInCommand, true);
    flopIntakeOutButton.whenPressed(flopIntakeOutCommand, true);

    //windLauncherUpButton.whenPressed(launcherCommand, true);

    raiseLauncherButton.whenPressed(aimingCommand, true);
    lowerLauncherButton.whenPressed(aimingCommandDown, true);

    disengageStopBallSoneloidButton.whenPressed(disengageStopBallSolenoid, true);

    targetWithLimelightButton.whileHeld(targetWithLimelightCommand, true);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  public static double getDriverAxis(int axis) {
    if (axis == 1 || axis == 5) {
      return -driverJoystick.getRawAxis(axis);
    } else {
      return driverJoystick.getRawAxis(axis);
    }
  }

  public static double getOperatorAxis(int axis) {
    if (axis == 1 || axis == 5) {
      return -operatorJoystick.getRawAxis(axis);
    } else {
      return operatorJoystick.getRawAxis(axis);
    }
  }

  public static boolean handlerPositionValue() {
    return changeHandlerPositionButton.get();
  }

  public static boolean climbButtonValue() {
    return runWinchButton.get();
  }

  public static boolean launcherButVal(){
    return windLauncherUpButton.get();
  }

  public static boolean stopWindin(){
    return windLauncherDownButton.get();
  }

  public static boolean lowerButVal(){
    return lowerLauncherButton.get();
  }
  public static boolean raiseButVal(){
    return raiseLauncherButton.get();
  }

  public static boolean disengageStopBallSoneloidButtonValue() {
    return disengageStopBallSoneloidButton.get();
  }
}
