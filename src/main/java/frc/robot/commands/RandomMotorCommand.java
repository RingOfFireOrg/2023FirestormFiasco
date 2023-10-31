// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.swing.SwingWorker;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenixpro.signals.RobotEnableValue;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class RandomMotorCommand extends CommandBase {
  double motorSpeed = 0;

  /** Creates a new RandomMotorCommand. */
  public RandomMotorCommand() {
    addRequirements(Robot.myMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean aButton = Robot.m_robotContainer.GetManipulatorA();
    boolean bButton = Robot.m_robotContainer.GetManipulatorB();

    if(aButton) {
      motorSpeed = 1;
      Robot.myMotor.setSpeed(motorSpeed);
    } else if (bButton) {
      motorSpeed = -1;
      Robot.myMotor.setSpeed(motorSpeed);
    } else {
      motorSpeed = 0;
      Robot.myMotor.setSpeed(motorSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Set the motor to 0 speed.. to avoid any movement.
    Robot.myMotor.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}



