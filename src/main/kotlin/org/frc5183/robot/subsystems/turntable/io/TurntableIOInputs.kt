package org.frc5183.robot.subsystems.turntable.io

import org.frc5183.robot.logging.AutoLogInputs
import org.frc5183.robot.logging.struct.PhotonTrackedTargetStruct
import org.photonvision.targeting.PhotonTrackedTarget

class TurntableIOInputs : AutoLogInputs() {
    var speed by log(0.0)
    var targets by log(emptyArray<PhotonTrackedTarget>(), PhotonTrackedTargetStruct)
}
