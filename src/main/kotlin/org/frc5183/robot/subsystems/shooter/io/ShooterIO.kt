package org.frc5183.robot.subsystems.shooter.io

import org.frc5183.robot.logging.AutoLogInputs

interface ShooterIO {
    fun updateInputs(inputs: ShooterIOInputs)

    fun run(speed: Double)
    fun stop()
}