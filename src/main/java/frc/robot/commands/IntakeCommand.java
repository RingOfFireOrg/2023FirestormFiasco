// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  public IntakeCommand() {
    addRequirements(Robot.myIntake);// here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     //Get the values from the user and from robot sensors
    // how the drive controller is pressed
    double leftStickX = Robot.m_robotContainer.GetManipulatorRawAxis(Constants.LEFT_STICK_X);
    SmartDashboard.putNumber("LeftStickValue of manipulator", leftStickX);

    // Pass the value of Joystick to the motor so that it either rotates clockwise or anticlockwise
    Robot.myIntake.OpenOrCloseIntake(leftStickX);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.myIntake.OpenOrCloseIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    Robot.myIntake.OpenOrCloseIntake(0);
    return false;
  }
}
