package org.frc5183.robot

import edu.wpi.first.hal.FRCNetComm
import edu.wpi.first.hal.HAL
import edu.wpi.first.wpilibj.Threads
import edu.wpi.first.wpilibj.util.WPILibVersion
import edu.wpi.first.wpilibj2.command.CommandScheduler
import org.frc5183.robot.constants.BUILD_DATE
import org.frc5183.robot.constants.BUILD_UNIX_TIME
import org.frc5183.robot.constants.DIRTY
import org.frc5183.robot.constants.GIT_BRANCH
import org.frc5183.robot.constants.GIT_DATE
import org.frc5183.robot.constants.GIT_SHA
import org.frc5183.robot.constants.MAVEN_NAME
import org.littletonrobotics.junction.LoggedRobot
import org.littletonrobotics.junction.Logger

object Robot : LoggedRobot() {
    init {
        HAL.report(FRCNetComm.tResourceType.kResourceType_Language, FRCNetComm.tInstances.kLanguage_Kotlin, 0,
            WPILibVersion.Version)

        HAL.report(FRCNetComm.tResourceType.kResourceType_Framework, FRCNetComm.tInstances.kFramework_AdvantageKit)

        Logger.recordMetadata("ProjectName", MAVEN_NAME)
        Logger.recordMetadata("BuildDate", BUILD_DATE)
        Logger.recordMetadata("BuildDateUnix", BUILD_UNIX_TIME.toString())
        Logger.recordMetadata("GitSHA", GIT_SHA)
        Logger.recordMetadata("GitDate", GIT_DATE)
        Logger.recordMetadata("GitBranch", GIT_BRANCH)

        when (DIRTY) {
            0 -> Logger.recordMetadata("GitDirty", "All changes committed")
            1 -> Logger.recordMetadata("GitDirty", "Uncommitted changes")
            else -> Logger.recordMetadata("GitDirty", "Unknown")
        }

        Logger.start()
    }

    override fun robotPeriodic() {
        // Wrap the command scheduler in a high priority thread.
        //  (thanks AdvantageKit template)
        Threads.setCurrentThreadPriority(true, 99)

        CommandScheduler.getInstance().run()

        Threads.setCurrentThreadPriority(false, 10)
    }
}