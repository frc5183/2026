package org.frc5183.robot.subsystems.vision.io

import org.frc5183.robot.subsystems.vision.FixedCamera
import org.photonvision.EstimatedRobotPose

class RealVisionIO(
    val frontCamera: FixedCamera,
    val backCamera: FixedCamera,
) : VisionIO {
    override fun updateInputs(inputs: VisionIOInputs) {
        frontCamera.periodic()
        backCamera.periodic()

        inputs.frontTargets = frontCamera.targets.toTypedArray()
        inputs.backTargets = backCamera.targets.toTypedArray()

        inputs.frontEstimatedRobotPose = frontCamera.estimatedRobotPose
        inputs.backEstimatedRobotPose = backCamera.estimatedRobotPose
    }
}
