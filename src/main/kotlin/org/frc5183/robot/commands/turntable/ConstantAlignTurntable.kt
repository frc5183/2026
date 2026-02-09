package org.frc5183.robot.commands.turntable

import edu.wpi.first.wpilibj2.command.Command
import org.frc5183.robot.subsystems.turntable.TurntableSubsystem
import org.frc5183.robot.target.FieldTarget

/**
 * A command that will constantly align the turntable to be centered on the middle hub targets.
 * @param turntable The turntable subsystem to use.
 *
 * @see AlignTurntable
 */
class ConstantAlignTurntable(private val turntable: TurntableSubsystem) : Command() {
    init {
        addRequirements(turntable)
    }

    override fun execute() {
        val targets = turntable.targets.filter { it.fiducialId == FieldTarget.HUB_MIDDLE_LEFT.id || it.fiducialId == FieldTarget.HUB_MIDDLE_RIGHT.id }

        // We can't see any targets, just spin until we can.
        if (targets.isEmpty()) {
            turntable.setSpeed(1.0)
        }

        // Get our left and right targets
        val left = targets.firstOrNull { it.fiducialId == FieldTarget.HUB_MIDDLE_LEFT.id }
        val right = targets.firstOrNull { it.fiducialId == FieldTarget.HUB_MIDDLE_RIGHT.id }

        if (left == null) { // If we can't see the left target, move to the left.
            turntable.setSpeed(-1.0)
        } else if (right == null) { // If we can't see the right target, move to the right.
            turntable.setSpeed(1.0)
        } else { // If we can see both targets, we're centered enough.
            turntable.stop()
        }

        // TODO: Add additional checks to center based off (target).detectedCorners and their positioning on the camera
        //   this will allow for more precision while far.
    }

    override fun end(interrupted: Boolean) {
        turntable.stop()
    }

    override fun isFinished(): Boolean = false
}