package org.frc5183.robot.subsystems.climber

import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.littletonrobotics.junction.Logger

class ClimberSubsystem(
    private val io: ClimberIO,
) : SubsystemBase() {
    private val ioInputs = ClimberIO.ClimberIOInputs()

    override fun periodic() {
        io.updateInputs(ioInputs)
        Logger.processInputs("Climber", ioInputs)
    }
}
