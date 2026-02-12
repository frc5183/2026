package org.frc5183.robot.subsystems.drive.io

import edu.wpi.first.math.Matrix
import edu.wpi.first.math.geometry.Pose2d
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.math.numbers.N1
import edu.wpi.first.math.numbers.N3
import org.frc5183.robot.subsystems.vision.VisionSubsystem
import swervelib.SwerveDrive

open class RealSwerveDriveIO(
    private val drive: SwerveDrive,
) : SwerveDriveIO {
    init {
        drive.headingCorrection = false
    }

    override val pose: Pose2d
        get() = drive.pose

    override val velocity: ChassisSpeeds
        get() = drive.robotVelocity

    override fun updateInputs(inputs: SwerveDriveIO.SwerveDriveIOInputs) {
        inputs.pose = pose
        inputs.velocity = velocity
        inputs.moduleStates = drive.states
    }

    override fun stopOdometryThread() = drive.stopOdometryThread()

    override fun updateOdometry() = drive.updateOdometry()

    override fun addVisionMeasurement(
        pose: Pose2d,
        timestampSeconds: Double,
        standardDeviations: Matrix<N3, N1>,
    ) = drive.addVisionMeasurement(pose, timestampSeconds, standardDeviations)

    override fun setMotorBrake(brake: Boolean) = drive.setMotorIdleMode(brake)

    override fun resetPose(pose: Pose2d) = drive.resetOdometry(pose)

    override fun drive(
        translation: Translation2d,
        rotation: Double,
        fieldOriented: Boolean,
        openLoop: Boolean,
    ) = drive.drive(translation, rotation, fieldOriented, openLoop)

    override fun drive(speeds: ChassisSpeeds) = drive.drive(speeds)
}
