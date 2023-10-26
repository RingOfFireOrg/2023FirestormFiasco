// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ArmCommand extends CommandBase {
  /** Creates a new ArmCommand. */
  double armSpeed = 0;

  public ArmCommand() {
    addRequirements(Robot.myArm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double armEncoder = Robot.myArm.getEncoderValue1();
    double leftStickX = Robot.m_robotContainer.GetManipulatorRawAxis(Constants.LEFT_STICK_X); 
    double leftTrigger = Robot.m_robotContainer.GetManipulatorLeftTrigger();
    double rightTrigger = Robot.m_robotContainer.GetManipulatorRightTrigger();
    double triggerDouble = rightTrigger - leftTrigger;
    


    Robot.myArm.ArmMove(leftStickX);
  
    /*if(triggerDouble>0.1) {
      Robot.myArm.ArmMove(leftStickX*.5);
    }*/

  SmartDashboard.putNumber("Position Of Arm", armEncoder);


  // Called once the command ends or is interrupted.

  }
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
