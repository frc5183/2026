package org.frc5183.robot.commands.drive

import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.math.kinematics.ChassisSpeeds
import edu.wpi.first.units.Units
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj2.command.Command
import org.frc5183.robot.constants.PhysicalConstants
import org.frc5183.robot.math.curve.Curve
import org.frc5183.robot.subsystems.drive.SwerveDriveSubsystem
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * A command that allows the driver to control the robot's translation and rotation using the joystick.
 */
class TeleopDriveCommand(
    /**
     * The [SwerveDriveSubsystem] to control.
     */
    val drive: SwerveDriveSubsystem,
    /**
     * A function that returns the X translation input for the robot. This should be in the range [-1, 1] and will
     * have [translationCurve] applied, then scaled to [PhysicalConstants.MAX_SPEED].
     */
    val xInput: () -> Double,
    /**
     * A function that returns the Y translation input for the robot. This should be in the range [-1, 1] and will
     * have [translationCurve] applied, then scaled to [PhysicalConstants.MAX_SPEED].
     */
    val yInput: () -> Double,
    /**
     * A function that returns the rotation input for the robot. This should be in the range [-1, 1] and will
     * have [rotationCurve] applied, then scaled to [PhysicalConstants.MAX_ANGULAR_VELOCITY].
     */
    val rotationInput: () -> Double,
    /**
     * The [Curve] to apply to the translation inputs.
     */
    val translationCurve: Curve,
    /**
     * The [Curve] to apply to the rotation input.
     */
    val rotationCurve: Curve,
    /**
     * Whether to use field-relative control.
     */
    val fieldRelative: Boolean,
) : Command() {
    init {
        addRequirements(drive)
    }

    override fun execute() {
        var translation = applyCurveToTranslation(Translation2d(xInput(), yInput()), translationCurve)

        if (fieldRelative) {
            translation = applyAllianceAwareTranslation(translation)
        }

        val xSpeed = PhysicalConstants.MAX_VELOCITY * translation.x
        val ySpeed = PhysicalConstants.MAX_VELOCITY * translation.y

        drive.drive(ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, Units.DegreesPerSecond.of(0.0), drive.robotPose.rotation))

//        drive.drive(
//            if (fieldRelative) {
//                ChassisSpeeds.fromRobotRelativeSpeeds(
//                    xSpeed,
//                    ySpeed,
//                    PhysicalConstants.MAX_ANGULAR_VELOCITY * rotationCurve(rotationInput()),
//                    drive.robotPose.rotation,
//                )
//            } else {
//                // todo: This was changed from 2025 codebase, make sure that this is correct BEFORE going to competition. Otherwise revert to 2025 code to at least keep the issues consistent with last year.
//                ChassisSpeeds(
//                    xSpeed,
//                    ySpeed,
//                    PhysicalConstants.MAX_ANGULAR_VELOCITY * rotationCurve(rotationInput())
//                )
//            },
//        )
    }

    fun applyCurveToTranslation(
        translation: Translation2d,
        curve: Curve,
    ): Translation2d {
        // todo: This was changed from 2025 codebase, make sure that this is correct BEFORE going to competition. Otherwise revert to 2025 code to at least keep the issues consistent with last year.
        val angle = atan2(translation.y, translation.x)
        val magnitude = curve(sqrt(translation.x.pow(2) + translation.y.pow(2)).coerceIn(0.0, 1.0))
        return Translation2d(magnitude * cos(angle), magnitude * sin(angle))
    }

    fun applyAllianceAwareTranslation(fieldRelativeTranslation: Translation2d): Translation2d =
        if (fieldRelative && DriverStation.getAlliance().orElseGet {
                DriverStation.Alliance.Red
            } == DriverStation.Alliance.Blue
        ) { // todo: This was changed from 2025 codebase, make sure that this is correct BEFORE going to competition.
            // Otherwise revert to 2025 code to at least keep the issues consistent with last year.
            fieldRelativeTranslation.rotateBy(Rotation2d.k180deg)
        } else {
            fieldRelativeTranslation
        }

    override fun isFinished(): Boolean = false
}
