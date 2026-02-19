package org.frc5183.robot.constants

import com.revrobotics.ColorSensorV3.Register
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.CommandScheduler
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import org.frc5183.robot.commands.drive.TeleopDriveCommand
import org.frc5183.robot.math.curve.Curve
import org.frc5183.robot.subsystems.drive.SwerveDriveSubsystem
import kotlin.math.absoluteValue

object Controls {
    val DRIVER_CONTROLLER: CommandXboxController = CommandXboxController(0)
    val OPERATOR_CONTROLLER: CommandXboxController = CommandXboxController(1)

    lateinit var TELEOP_DRIVE_COMMAND: TeleopDriveCommand
    fun registerControls(drive: SwerveDriveSubsystem) {
        CommandScheduler.getInstance().activeButtonLoop.clear()

        TELEOP_DRIVE_COMMAND = TeleopDriveCommand(
            drive,
            xInput = { DRIVER_CONTROLLER.leftX },
            yInput = { DRIVER_CONTROLLER.leftY },
            rotationInput = { DRIVER_CONTROLLER.rightX },
            translationCurve = Curve({ if (it.absoluteValue > 0.2) it else 0.0 }),
            rotationCurve = Curve({ if (it.absoluteValue > 0.2) it else 0.0 }),
            fieldRelative = true
        )

        drive.defaultCommand = TELEOP_DRIVE_COMMAND
    }
}