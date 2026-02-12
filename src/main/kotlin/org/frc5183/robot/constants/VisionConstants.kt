package org.frc5183.robot.constants

import edu.wpi.first.apriltag.AprilTagFields
import edu.wpi.first.math.Matrix
import edu.wpi.first.math.VecBuilder
import edu.wpi.first.math.geometry.Transform3d
import org.frc5183.robot.subsystems.vision.FixedCamera
import org.photonvision.PhotonCamera

object VisionConstants {
    val APRIL_TAG_LAYOUT = AprilTagFields.k2026RebuiltWelded // Double check this if outside FIM district.

    val FRONT_CAMERA = FixedCamera("front", Transform3d.kZero, VecBuilder.fill(4.0, 4.0, 8.0), VecBuilder.fill(0.5, 0.5, 1.0)) // todo
    val BACK_CAMERA = FixedCamera("back", Transform3d.kZero, VecBuilder.fill(4.0, 4.0, 8.0), VecBuilder.fill(0.5, 0.5, 1.0)) // todo

    val TURNTABLE_CAMERA = PhotonCamera("turntable") // todo
}