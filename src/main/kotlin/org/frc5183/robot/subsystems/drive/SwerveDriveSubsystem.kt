package org.frc5183.robot.subsystems.drive

import edu.wpi.first.math.geometry.Pose2d
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.frc5183.robot.subsystems.drive.io.SwerveDriveIO
import org.littletonrobotics.junction.Logger

class SwerveDriveSubsystem(
    private val io: SwerveDriveIO,
) : SubsystemBase() {
    private val ioInputs = SwerveDriveIO.SwerveDriveIOInputs()

    val robotPose: Pose2d
        get() = io.pose

    val robotVelocity: ChassisSpeeds
        get() = io.velocity

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
