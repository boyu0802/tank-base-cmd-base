

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DrivePIDCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
  public XboxController driverController = new XboxController(Constants.OperatorConstants.kDriverControllerPort);

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();


  public RobotContainer() {
    driveSubsystem.setDefaultCommand(
      new DrivePIDCommand(
        driveSubsystem,
        () -> -driverController.getLeftY(),
        () -> driverController.getRightX()
        )
    );

    configureBindings();
  }

  private void configureBindings() {
    // if (driverController.getAButton()) {
    //   driveSubsystem.sysIdQuasistatic(SysIdRoutine.Direction.kForward);
    // }

    // if (driverController.getBButton()) {
    //   driveSubsystem.sysIdQuasistatic(SysIdRoutine.Direction.kReverse);
    // }

    // if (driverController.getXButton()) {
    //   driveSubsystem.sysIdDynamic(SysIdRoutine.Direction.kForward);
    // }

    // if (driverController.getYButton()) {
    //   driveSubsystem.sysIdDynamic(SysIdRoutine.Direction.kReverse);
    // }
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
