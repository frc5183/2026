package org.frc5183.robot.constants.swerve.modules

import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.units.Units
import edu.wpi.first.units.measure.Angle
import swervelib.encoders.CANCoderSwerve
import swervelib.encoders.SwerveAbsoluteEncoder
import swervelib.motors.SwerveMotor
import swervelib.motors.TalonFXSwerve

object BLSwerveModuleConstant : SwerveModuleConstants {
    override val NAME: String = "backleft"
    override val LOCATION: Translation2d = Translation2d(Units.Inches.of(12.5), Units.Inches.of(-12.0))
    override val ABSOLUTE_ENCODER: SwerveAbsoluteEncoder = CANCoderSwerve(16)
    override val ABSOLUTE_ENCODER_OFFSET: Angle = Units.Degrees.of(72.598)
    override val ABSOLUTE_ENCODER_INVERTED: Boolean = false
    override val DRIVE_MOTOR: SwerveMotor = TalonFXSwerve(17, true, SwerveModulePhysicalConstants.MOTOR_TYPE)
    override val DRIVE_MOTOR_INVERTED: Boolean = false
    override val ANGLE_MOTOR: SwerveMotor = TalonFXSwerve(18, true, SwerveModulePhysicalConstants.MOTOR_TYPE)
    override val ANGLE_MOTOR_INVERTED: Boolean = false
}