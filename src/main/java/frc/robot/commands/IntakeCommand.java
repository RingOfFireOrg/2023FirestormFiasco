// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.swing.SwingWorker;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeCommand extends CommandBase {
  /** Creates a new SweeperCommand. */
  double intakeSpeed = 0;

  public IntakeCommand() {
    addRequirements(Robot.myIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Get the values from the user and from robot sensors
    // how the drive controller is pressed
    double leftStickX = Robot.m_robotContainer.GetManipulatorRawAxis(Constants.LEFT_STICK_X);
    boolean aIntake = Robot.m_robotContainer.GetManipulatorA();
    boolean bIntake = Robot.m_robotContainer.GetManipulatorB();

   // XboxController opweatowr = new XboxController(1);

    SmartDashboard.putNumber("LeftStickValue of manipulator", leftStickX);

    // Deal with limit switch and state.
    boolean limitSwitchState = Robot.m_robotContainer.getSweeperLimitSwitchValue();
    SmartDashboard.putBoolean("Sweeper limit switch state", limitSwitchState);
    // Multiplying two negatives makes it positive so negating sweepspeed if original value is negative
    if (aIntake) {
      intakeSpeed = 1;
      Robot.myIntake.Intake(1);
    } else if (bIntake) {
      intakeSpeed = -0.5;
      Robot.myIntake.Intake(-0.5);
    } else {
      intakeSpeed = 0;
      Robot.myIntake.Intake(0);

    }

    SmartDashboard.putNumber("sweep speed of manipulator", intakeSpeed);


    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Set the motor to 0 speed.. to avoid any movement.
    //Robot.myIntake.Intake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}



