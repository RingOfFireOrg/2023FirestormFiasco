// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ArmCommand;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {}

CANSparkMax armMotor = new CANSparkMax(9, MotorType.kBrushless);
RelativeEncoder armEncoder2 = armMotor.getEncoder();
double armSpeed;
double armEncoderValue = 0;

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new ArmCommand());
    armMotor.set(armSpeed);
    armEncoderValue = armEncoder2.getPosition();
  

  }

  public double getEncoderValue1(){

    return armEncoder2.getPosition();
  }
  public void ArmMove(double speed) {
    armMotor.set(speed);
  }
}
