package org.frc5183.robot.commands.turntable

import edu.wpi.first.wpilibj2.command.Command
import org.frc5183.robot.subsystems.turntable.TurntableSubsystem

class AlignTurntable(val turntable: TurntableSubsystem) : Command() {
    init {
        addRequirements(turntable)
    }

    // this is a comment that i [walker] wrote
    // kinda yeah uhhhhhhhhhhhhhhhhhhhhhh thingy
}