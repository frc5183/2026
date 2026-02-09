package org.frc5183.robot.subsystems.shooter

import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.frc5183.robot.subsystems.shooter.io.ShooterIO
import org.frc5183.robot.subsystems.shooter.io.ShooterIOInputs

class ShooterSubsystem(
    private val io: ShooterIO,
) : SubsystemBase() {
    private val ioInputs = ShooterIOInputs()

    override fun periodic() {
        io.updateInputs(ioInputs)
    }

    fun run(speed: Double) {
        io.run(speed)
    }

    fun stop() {
        io.stop()
    }
}
