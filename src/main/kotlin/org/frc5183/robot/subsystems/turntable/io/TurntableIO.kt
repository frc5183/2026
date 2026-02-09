package org.frc5183.robot.subsystems.turntable.io

import org.photonvision.targeting.PhotonTrackedTarget

interface TurntableIO {
    fun updateInputs(inputs: TurntableIOInputs)

    fun setSpeed(speed: Double)
    fun stop()
}