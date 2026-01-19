package org.frc5183.robot.subsystems.drive

import com.pathplanner.lib.auto.AutoBuilder
import com.pathplanner.lib.commands.PathfindingCommand
import com.pathplanner.lib.config.PIDConstants
import com.pathplanner.lib.controllers.PPHolonomicDriveController
import com.pathplanner.lib.pathfinding.Pathfinding
import edu.wpi.first.math.geometry.Pose2d
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj2.command.CommandScheduler
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.frc5183.robot.math.pathfinding.LocalADStarAK
import org.frc5183.robot.subsystems.drive.io.SwerveDriveIO
import org.littletonrobotics.junction.Logger
import kotlin.jvm.optionals.getOrNull

class SwerveDriveSubsystem(
    private val io: SwerveDriveIO,
) : SubsystemBase() {
    private val ioInputs = SwerveDriveIO.SwerveDriveIOInputs()

    val robotPose: Pose2d
        get() = io.pose

    val robotVelocity: ChassisSpeeds
        get() = io.velocity

    init {
        AutoBuilder.configure(
            { robotPose },
            this::resetPose,
            { robotVelocity },
            PPHolonomicDriveController(
                PIDConstants(
                    TODO("requires constants"),
                    TODO("requires constants"),
                    TODO("requires constants"),
                ),
                PIDConstants(
                    TODO("requires constants"),
                    TODO("requires constants"),
                    TODO("requires constants"),
                ),
            ),
            TODO("requires constants"),
            { DriverStation.getAlliance().getOrNull() == DriverStation.Alliance.Red },
            this,
            TODO("requires constants"),
        )

        Pathfinding.setPathfinder(LocalADStarAK())

        // https://pathplanner.dev/pplib-follow-a-single-path.html#java-warmup
        CommandScheduler.getInstance().schedule(PathfindingCommand.warmupCommand())
    }

    override fun periodic() {
        io.updateInputs(ioInputs)
        Logger.processInputs("Swerve", ioInputs)
    }

    fun setMotorBrake(brake: Boolean) = io.setMotorBrake(brake)

    fun resetPose(pose: Pose2d = Pose2d.kZero) = io.resetPose(pose)

    fun drive(
        translation: Translation2d,
        rotation: Double,
        fieldOriented: Boolean,
        openLoop: Boolean,
    ) = io.drive(translation, rotation, fieldOriented, openLoop)

    fun drive(speeds: ChassisSpeeds) = io.drive(speeds)
}
