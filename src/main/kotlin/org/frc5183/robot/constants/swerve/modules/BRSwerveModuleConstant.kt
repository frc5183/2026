package org.frc5183.robot.constants.swerve.modules

import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.units.Units
import edu.wpi.first.units.measure.Angle
import swervelib.encoders.CANCoderSwerve
import swervelib.encoders.SwerveAbsoluteEncoder
import swervelib.motors.SwerveMotor
import swervelib.motors.TalonFXSwerve

object BRSwerveModuleConstant : SwerveModuleConstants {
    override val NAME: String = "backright"
    override val LOCATION: Translation2d = Translation2d(Units.Inches.of(-12.5), Units.Inches.of(-12.0))
    override val ABSOLUTE_ENCODER: SwerveAbsoluteEncoder = CANCoderSwerve(19)
    override val ABSOLUTE_ENCODER_OFFSET: Angle = Units.Degrees.of(293.115)
    override val ABSOLUTE_ENCODER_INVERTED: Boolean = false
    override val DRIVE_MOTOR: SwerveMotor = TalonFXSwerve(20, true, SwerveModulePhysicalConstants.MOTOR_TYPE)
    override val DRIVE_MOTOR_INVERTED: Boolean = false
    override val ANGLE_MOTOR: SwerveMotor = TalonFXSwerve(21, true, SwerveModulePhysicalConstants.MOTOR_TYPE)
    override val ANGLE_MOTOR_INVERTED: Boolean = false
}