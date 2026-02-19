package org.frc5183.robot.constants.swerve

import org.frc5183.robot.constants.DeviceConstants
import org.frc5183.robot.constants.swerve.modules.*
import swervelib.imu.NavXSwerve
import swervelib.imu.SwerveIMU
import swervelib.parser.SwerveDriveConfiguration
import swervelib.parser.SwerveModulePhysicalCharacteristics

object SwerveConstants {
    val IMU: SwerveIMU = NavXSwerve(DeviceConstants.IMUPort)
    val IMU_INVERTED: Boolean = false

    val COSINE_COMPENSATOR: Boolean = true

    val YAGSL: SwerveDriveConfiguration =
        SwerveDriveConfiguration(
            listOf(
                FLSwerveModuleConstants.YAGSL,
                FRSwerveModuleConstant.YAGSL,
                BLSwerveModuleConstant.YAGSL,
                BRSwerveModuleConstant.YAGSL,
            ).toTypedArray(),
            IMU,
            IMU_INVERTED,
            SwerveModulePhysicalConstants.YAGSL,
        )
}