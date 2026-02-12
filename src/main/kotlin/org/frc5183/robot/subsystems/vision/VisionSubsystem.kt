package org.frc5183.robot.subsystems.vision

import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.frc5183.robot.constants.VisionConstants
import org.frc5183.robot.subsystems.vision.io.VisionIO
import org.frc5183.robot.subsystems.vision.io.VisionIOInputs
import org.photonvision.EstimatedRobotPose
import org.photonvision.targeting.PhotonTrackedTarget

class VisionSubsystem(val io: VisionIO) : SubsystemBase() {
    private val inputs = VisionIOInputs()

    val targets: List<PhotonTrackedTarget>
        get() = inputs.targets.toList()

    val estimatedRobotPoses: Map<FixedCamera, EstimatedRobotPose>
        get() {
            val map = mutableMapOf<FixedCamera, EstimatedRobotPose>()

            inputs.frontEstimatedRobotPose?.let { map += Pair(VisionConstants.FRONT_CAMERA, it) }
            inputs.backEstimatedRobotPose?.let { map += Pair(VisionConstants.BACK_CAMERA, it) }

            return map
        }

    override fun periodic() {
        io.updateInputs(inputs)
    }
}