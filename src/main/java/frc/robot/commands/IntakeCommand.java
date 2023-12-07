// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class IntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  public IntakeCommand() {
    addRequirements(Robot.myIntake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  private XboxController ManipulatorController = new XboxController(Constants.CONTROLLER_MANIPULATOR_ID);

  @Override
  public void execute() {
    /*if (ManipulatorController.getLeftY() > 0.1) {
      Robot.myIntake.intakeSet(1);
      SmartDashboard.putNumber("OnOFF", 1);
    } else if (ManipulatorController.getLeftY() < -0.1) {
      Robot.myIntake.intakeSet(-1);
      SmartDashboard.putNumber("OnOFF", -1);
    } else {
      Robot.myIntake.intakeSet(0);
      SmartDashboard.putNumber("OnOFF", 0);
    }*/

    if (ManipulatorController.getAButton()) {
      Robot.myIntake.intakeSet(1);
      SmartDashboard.putNumber("OnOFF", 1);
    } else if (ManipulatorController.getBButton()) {
      Robot.myIntake.intakeSet(-1);
      SmartDashboard.putNumber("OnOFF", -1);
    } else {
      Robot.myIntake.intakeSet(0);
      SmartDashboard.putNumber("OnOFF", 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
