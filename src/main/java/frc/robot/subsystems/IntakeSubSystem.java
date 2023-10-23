// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.cscore.CameraServerCvJNI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.IntakeCommand;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubSystem extends SubsystemBase {
  
  private CANSparkMax IntakeMotorController;  
  
  /** Creates a new IntakeSubSystem. */
  public IntakeSubSystem() {
    IntakeMotorController = new CANSparkMax(Constants.MOTOR_INTAKE_ID,MotorType.kBrushed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new IntakeCommand());
  }
  
    // The motor will rotate left or right based on the input from the user as speed variable will have Postivie and negative alues
  public void OpenOrCloseIntake(double speed)
  {
    // Set the speed of the motor to rotate clockwise or anti clockwise
    IntakeMotorController.set(speed);
  }


}
