package org.frc5183.robot.target

import edu.wpi.first.wpilibj.DriverStation
import kotlin.jvm.optionals.getOrNull

enum class FieldTarget(
    val redId: Int,
    val blueId: Int,
) {
    HUB_MIDDLE_RIGHT(10, 26),
    HUB_MIDDLE_LEFT(9, 25),
    ;

    val id: Int
        get() =
            if ((DriverStation.getAlliance().getOrNull() ?: DriverStation.Alliance.Red) == DriverStation.Alliance.Red) {
                redId
            } else {
                blueId
            }
}
