// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PIDConstants;


public class DriveSubsystem extends SubsystemBase {
  private final CANSparkMax leftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax rightMotor = new CANSparkMax(2, MotorType.kBrushless);
  public DriveSubsystem() {}

  public void initialize(){
    leftMotor.restoreFactoryDefaults();
    rightMotor.restoreFactoryDefaults();

    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);
    
    leftMotor.getPIDController().setP(PIDConstants.Kp);
    leftMotor.getPIDController().setI(PIDConstants.Ki);
    leftMotor.getPIDController().setD(PIDConstants.Kd);
    rightMotor.getPIDController().setP(PIDConstants.Kp);
    rightMotor.getPIDController().setI(PIDConstants.Ki);
    rightMotor.getPIDController().setD(PIDConstants.Kd);
    
    leftMotor.setSmartCurrentLimit(40);
    rightMotor.setSmartCurrentLimit(40);



    rightMotor.setInverted(true);

    leftMotor.set(0);
    rightMotor.set(0);
  }

  // private final MutableMeasure<Voltage> m_appliedVoltage = mutable(Volts.of(0));
  // // Mutable holder for unit-safe linear distance values, persisted to avoid reallocation.
  // private final MutableMeasure<Distance> m_distance = mutable(Meters.of(0));
  // // Mutable holder for unit-safe linear velocity values, persisted to avoid reallocation.
  // private final MutableMeasure<Velocity<Distance>> m_velocity = mutable(MetersPerSecond.of(0));


  public void drive(double leftSpeed, double rightSpeed){

    leftMotor.getPIDController().setReference(leftSpeed, ControlType.kVelocity,0);
    rightMotor.getPIDController().setReference(rightSpeed, ControlType.kVelocity,0);
  }

  // public SysIdRoutine sysIdRoutine =
  //   new SysIdRoutine(
  //     new SysIdRoutine.Config(),
  //     new SysIdRoutine.Mechanism(
  //       (Measure<Voltage> voltage) -> {
  //         rightMotor.setVoltage(voltage.in(Volts));
  //         leftMotor.setVoltage(voltage.in(Volts));

          
  //       },
        
  //       log -> 
  //       {
  //         log.motor("drive-left")
  //           .voltage(
  //             m_appliedVoltage.mut_replace(leftMotor.get() * RobotController.getBatteryVoltage(), Volts)
  //           )
  //           .linearPosition(m_distance.mut_replace(leftMotor.getEncoder().getPosition(), Meters))
  //           .linearVelocity(
  //             m_velocity.mut_replace(leftMotor.getEncoder().getVelocity(), MetersPerSecond));

  //         log.motor("drive-right")
  //           .voltage(
  //             m_appliedVoltage.mut_replace(rightMotor.get() * RobotController.getBatteryVoltage(), Volts))
  //           .linearPosition(m_distance.mut_replace(rightMotor.getEncoder().getPosition(), Meters))
  //           .linearVelocity(
  //             m_velocity.mut_replace(rightMotor.getEncoder().getVelocity(), MetersPerSecond));
  //       }, this));

  // public Command sysIdQuasistatic(SysIdRoutine.Direction direction) {
  //   return sysIdRoutine.quasistatic(direction);
  // }

  // public Command sysIdDynamic(SysIdRoutine.Direction direction) {
  //   return sysIdRoutine.dynamic(direction);
  // }

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
  }
}
