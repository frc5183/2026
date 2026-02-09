package org.frc5183.robot.subsystems.turntable.io

import com.revrobotics.spark.SparkMax
import org.photonvision.PhotonCamera
import org.photonvision.targeting.PhotonTrackedTarget

class RealTurntableIO(val motor: SparkMax, val camera: PhotonCamera) : TurntableIO {
    override fun updateInputs(inputs: TurntableIOInputs) {
        inputs.speed = motor.get()

        inputs.targets = camera.allUnreadResults.map { it.targets }.flatten().toTypedArray()
    }

    override fun setSpeed(speed: Double) {
        motor.set(speed)
    }

    override fun stop() {
        motor.stopMotor()
    }
}