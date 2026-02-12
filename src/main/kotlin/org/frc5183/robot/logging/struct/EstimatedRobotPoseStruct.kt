package org.frc5183.robot.logging.struct

import edu.wpi.first.math.geometry.Pose3d
import edu.wpi.first.util.struct.Struct
import org.photonvision.EstimatedRobotPose
import org.photonvision.targeting.PhotonTrackedTarget
import java.nio.ByteBuffer

// todo: some things here are missing which might mess with simulation. works for basic logging tho
object EstimatedRobotPoseStruct : Struct<EstimatedRobotPose> {
    override fun getTypeClass(): Class<EstimatedRobotPose> = EstimatedRobotPose::class.java

    override fun getTypeName(): String = "EstimatedRobotPose"

    override fun getSize(): Int = Struct.kSizeDouble * 7

    override fun getSchema(): String = "double poseX;double poseY;double poseZ;double rotX;double rotY;double rotZ;double timestampSeconds"

    override fun unpack(bb: ByteBuffer): EstimatedRobotPose {
        val poseX = bb.getDouble()
        val poseY = bb.getDouble()
        val poseZ = bb.getDouble()
        val rotX = bb.getDouble()
        val rotY = bb.getDouble()
        val rotZ = bb.getDouble()

        val pose3d =
            Pose3d(
                poseX,
                poseY,
                poseZ,
                edu.wpi.first.math.geometry
                    .Rotation3d(rotX, rotY, rotZ),
            )

        val timestampSeconds = bb.getDouble()

        return EstimatedRobotPose(pose3d, timestampSeconds, emptyList<PhotonTrackedTarget>())
    }

    override fun pack(
        bb: ByteBuffer,
        value: EstimatedRobotPose,
    ) {
        bb.putDouble(value.estimatedPose.x)
        bb.putDouble(value.estimatedPose.y)
        bb.putDouble(value.estimatedPose.z)
        bb.putDouble(value.estimatedPose.rotation.x)
        bb.putDouble(value.estimatedPose.rotation.y)
        bb.putDouble(value.estimatedPose.rotation.z)

        bb.putDouble(value.timestampSeconds)
    }
}
