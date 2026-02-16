package org.frc5183.robot.subsystems.vision.io

import org.frc5183.robot.logging.AutoLogInputs
import org.frc5183.robot.logging.struct.EstimatedRobotPoseStruct
import org.frc5183.robot.logging.struct.PhotonTrackedTargetStruct
import org.photonvision.EstimatedRobotPose
import org.photonvision.targeting.PhotonTrackedTarget

class VisionIOInputs : AutoLogInputs() {
    var frontTargets by log(emptyArray<PhotonTrackedTarget>(), PhotonTrackedTargetStruct)
    var backTargets by log(emptyArray<PhotonTrackedTarget>(), PhotonTrackedTargetStruct)
    var frontEstimatedRobotPose by log(null as EstimatedRobotPose?, EstimatedRobotPoseStruct)
    var backEstimatedRobotPose by log(null as EstimatedRobotPose?, EstimatedRobotPoseStruct)
}
