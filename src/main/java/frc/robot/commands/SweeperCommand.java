// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class SweeperCommand extends CommandBase {
  /** Creates a new SweeperCommand. */
  public SweeperCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        //Get the value from the user.. how the drive controller is pressed
        double LeftStickY = Robot.m_robotContainer.GetManipulatorRawAxis(Constants.LEFT_STICK_Y);
        SmartDashboard.putNumber("LeftStickValue of manipulator", LeftStickY);
            // This is the code that actually drives the robot... We are multiplying the speeds so that it grudually increases the speed
    if(LeftStickY <= 0)
    {
      
      Robot.mySweeper.Sweep((-(LeftStickY*LeftStickY));

    }
    else{
      
    }Robot.mySweeper.Sweep((LeftStickY*LeftStickY));
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
