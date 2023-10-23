// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class SchmooverCommand extends CommandBase {
  /** Creates a new SchmooverCommand. */
  private double speedFactor = 0.58;
  public SchmooverCommand() {
    addRequirements(Robot.mySchmoover);//here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

     //Get the values from the user and from robot sensors
    // how the drive controller is pressed
    double rightStickY = Robot.m_robotContainer.GetManipulatorRawAxis(Constants.RIGHT_STICK_Y);
  
    rightStickY = rightStickY * speedFactor;

    SmartDashboard.putNumber("Right stick Y value of manipulator", rightStickY);

    // Smoothening the motor speed over period
    if(rightStickY <= 0)
    {
      Robot.mySchmoover.MoveSchmoover(-(rightStickY*rightStickY));
    }
    else{
      Robot.mySchmoover.MoveSchmoover((rightStickY*rightStickY));
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.mySchmoover.MoveSchmoover(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    Robot.mySchmoover.MoveSchmoover(0);
    return false;
  }
}
