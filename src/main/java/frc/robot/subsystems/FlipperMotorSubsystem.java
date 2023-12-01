// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.FlipperMotorCommand;

public class FlipperMotorSubsystem extends SubsystemBase {
  /** Creates a new FlipperMotor. */
  public FlipperMotorSubsystem() {}

  CANSparkMax flipper = new CANSparkMax(3, MotorType.kBrushless);


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new FlipperMotorCommand());
  }

  public void motorSet( double speed) {
    flipper.set(speed*0.3);
  }
}
