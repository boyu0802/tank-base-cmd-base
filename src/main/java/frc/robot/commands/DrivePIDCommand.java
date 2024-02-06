// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;


public class DrivePIDCommand extends Command {
  private final DriveSubsystem driveSubsystem;
  private final Supplier<Double> speedFunction, trunFunction;


  public DrivePIDCommand(DriveSubsystem subsystem, Supplier<Double> SpeedFunction, 
    Supplier<Double> TrunFunction) {
      this.driveSubsystem = subsystem;
      this.speedFunction = SpeedFunction;
      this.trunFunction = TrunFunction;
      addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    driveSubsystem.initialize();
  }



  @Override
  public void execute() {
    double speed = speedFunction.get();
    double turn = trunFunction.get();

    double leftSpeed = (speed + turn);
    double rightSpeed = (speed - turn);
    driveSubsystem.drive( leftSpeed, rightSpeed);

  }

  
  @Override
  public void end(boolean interrupted) {}


  @Override
  public boolean isFinished() {
    return false;
  }
}
