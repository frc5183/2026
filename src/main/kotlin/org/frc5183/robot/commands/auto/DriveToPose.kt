package org.frc5183.robot.commands.auto

import com.pathplanner.lib.auto.AutoBuilder
import com.pathplanner.lib.path.PathConstraints
import edu.wpi.first.math.geometry.Pose2d
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup
import org.frc5183.robot.subsystems.drive.SwerveDriveSubsystem

/**
 * Automatically drives to a specified pose.
 * @param drive The [SwerveDriveSubsystem] to control.
 * @param target The target [Pose2d] to drive to.
 * @param constraints The [PathConstraints] to use for the pathfinding.
 */
class DriveToPose(
    private val drive: SwerveDriveSubsystem,
    private val target: Pose2d,
    private val constraints: PathConstraints = TODO("requires constants"),
) : SequentialCommandGroup() {
    init {
        addRequirements(drive)

        addCommands(
            AutoBuilder.pathfindToPose(target, constraints),
        )
    }
}
