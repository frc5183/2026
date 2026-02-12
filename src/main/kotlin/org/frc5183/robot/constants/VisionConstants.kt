package org.frc5183.robot.constants

import edu.wpi.first.apriltag.AprilTagFields
import edu.wpi.first.math.Matrix
import edu.wpi.first.math.VecBuilder
import edu.wpi.first.math.geometry.Transform3d
import org.frc5183.robot.subsystems.vision.FixedCamera
import org.photonvision.PhotonCamera

object VisionConstants {
    val APRIL_TAG_LAYOUT = AprilTagFields.k2026RebuiltWelded // Double check this if outside FIM district.

    val FRONT_CAMERA: FixedCamera = TODO()
    val BACK_CAMERA: FixedCamera = TODO()

    val TURNTABLE_CAMERA: PhotonCamera = TODO()
}
