package org.frc5183.robot.subsystems.shooter.io

import com.revrobotics.spark.SparkMax

class RealShooterIO(
    val motor: SparkMax,
) : ShooterIO {
    override fun updateInputs(inputs: ShooterIOInputs) {
        inputs.shooterSpeed = motor.get()
    }

    override fun run(speed: Double) {
        motor.set(speed)
    }

    override fun stop() {
        motor.stopMotor()
    }
}
