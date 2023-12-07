// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TeamLightsCommand extends CommandBase {
  /** Creates a new TeamLightsCommand. */
  public TeamLightsCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.myTeamColorsDisplay);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.myTeamColorsDisplay.setLedsOn();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (aButton){
    
    } else if (bButton) {

    }else {
      Robot.myTeamColorsDisplay.setLedsOn();
    }
  }

  boolean aButton = Robot.m_robotContainer.buttonA();
  boolean bButton = Robot.m_robotContainer.buttonB();

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
