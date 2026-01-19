package org.frc5183.robot.commands.auto

import com.pathplanner.lib.path.PathConstraints
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup
import org.frc5183.robot.subsystems.drive.SwerveDriveSubsystem

/**
 * Automatically drives to the climb position with the correct alliance.
 * @param drive The [SwerveDriveSubsystem] to control.
 * @param side The side of the climb to drive to.
 * @param constraints The [PathConstraints] to use for the pathfinding.
 */
class DriveToClimb(
    private val drive: SwerveDriveSubsystem,
    private val side: ClimbSide,
    private val constraints: PathConstraints = TODO("requires constants"),
) : SequentialCommandGroup() {
    enum class ClimbSide(
        translation: Translation2d,
    ) {
        LEFT(TODO("requires constants")),
        MIDDLE(TODO("requires constants")),
        RIGHT(TODO("requires constants")),
    }

    init {
        addRequirements(drive)

        addCommands(
            DriveToPose(
                drive,
                when (side) {
                    ClimbSide.LEFT -> TODO("offset based on climb position and alliance color")
                    ClimbSide.MIDDLE -> TODO("offset based on climb position and alliance color")
                    ClimbSide.RIGHT -> TODO("offset based on climb position and alliance color")
                },
            ),
        )
    }
}
