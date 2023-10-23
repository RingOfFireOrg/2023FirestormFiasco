// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.SchmooverCommand;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class SchmooverSubSystem extends SubsystemBase {
  private CANSparkMax LiftMotorController;
  /** Creates a new SchmooverSubSystem. */
  public SchmooverSubSystem() {
    // we are using a CIM motor so defined as Brushed motor
    LiftMotorController = new CANSparkMax(Constants.MOTOR_LIFT_ID, MotorType.kBrushed);
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new SchmooverCommand());
  }
  
    // The motor will rotate left or right based on the input from the user as speed variable will have Postivie and negative alues
    public void MoveSchmoover(double speed)
  {
    // Set the speed of the motor to either move up or down
      LiftMotorController.set(speed);
  }

}
