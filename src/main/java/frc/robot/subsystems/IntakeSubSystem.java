// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IntakeSubSystem extends SubsystemBase {
  /** Creates a new IntakeSubSystem. */
  public IntakeSubSystem() {
  }
  VictorSPX intake = new VictorSPX(1);
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new IntakeCommand());
  }

  public void intakeSet (double speed) {
    intake.set(ControlMode.PercentOutput, speed);
  }
}
