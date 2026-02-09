package org.frc5183.robot.subsystems.turntable

import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.frc5183.robot.subsystems.turntable.io.TurntableIO
import org.frc5183.robot.subsystems.turntable.io.TurntableIOInputs
import org.photonvision.targeting.PhotonTrackedTarget

class TurntableSubsystem(val io: TurntableIO) : SubsystemBase() {
    val ioInputs = TurntableIOInputs()

    val targets: Array<PhotonTrackedTarget>
        get() = ioInputs.targets

    override fun periodic() {
        io.updateInputs(ioInputs)
    }

    fun setSpeed(speed: Double) {
        io.setSpeed(speed)
    }

    fun stop() {
        io.stop()
    }
}