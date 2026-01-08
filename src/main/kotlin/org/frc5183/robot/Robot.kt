package org.frc5183.robot

import edu.wpi.first.hal.FRCNetComm
import edu.wpi.first.hal.HAL
import edu.wpi.first.wpilibj.Threads
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.util.WPILibVersion
import edu.wpi.first.wpilibj2.command.CommandScheduler

object Robot : TimedRobot() {
    init {
        HAL.report(FRCNetComm.tResourceType.kResourceType_Language, FRCNetComm.tInstances.kLanguage_Kotlin, 0,
            WPILibVersion.Version)

        HAL.report(FRCNetComm.tResourceType.kResourceType_Framework, FRCNetComm.tInstances.kFramework_AdvantageKit)
    }

    override fun robotPeriodic() {
        // Wrap the command scheduler in a high priority thread.
        //  (thanks AdvantageKit template)
        Threads.setCurrentThreadPriority(true, 99)

        CommandScheduler.getInstance().run()

        Threads.setCurrentThreadPriority(false, 10)
    }
}