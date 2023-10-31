// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.RandomMotorCommand;

public class RandomMotorSubSystem extends SubsystemBase {
  private VictorSPX randomMotor = new VictorSPX(Constants.RANDOM_MOTOR_ID);
  /** Creates a new RandomMotorSubSystem. */
  public RandomMotorSubSystem() {
    randomMotor.setInverted(true);
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new RandomMotorCommand());
  }
  
  public void setSpeed(double speed) {
    // The motor will rotate left or right based on the input from the user as speed variable will have Postivie and negative values
    randomMotor.set(VictorSPXControlMode.PercentOutput,speed);
  }

}
