package org.frc5183.robot.logging.struct

import edu.wpi.first.util.struct.Struct
import org.photonvision.targeting.PhotonTrackedTarget
import java.nio.ByteBuffer

// todo: some things here are missing which might mess with simulation. works for basic logging tho
object PhotonTrackedTargetStruct : Struct<PhotonTrackedTarget> {
    override fun getTypeClass(): Class<PhotonTrackedTarget> = PhotonTrackedTarget::class.java

    override fun getTypeName(): String = "PhotonTrackedTarget"

    override fun getSize(): Int = Struct.kSizeDouble * 4 + Struct.kSizeInt32

    override fun getSchema(): String = "double yaw;double pitch;double area;double skew;int32 fiducialId;"

    override fun unpack(bb: ByteBuffer): PhotonTrackedTarget {
        val target = PhotonTrackedTarget()
        target.yaw = bb.getDouble()
        target.pitch = bb.getDouble()
        target.area = bb.getDouble()
        target.skew = bb.getDouble()
        target.fiducialId = bb.getInt()
        return target
    }

    override fun pack(
        bb: ByteBuffer,
        value: PhotonTrackedTarget,
    ) {
        bb.putDouble(value.yaw)
        bb.putDouble(value.pitch)
        bb.putDouble(value.area)
        bb.putDouble(value.skew)
        bb.putInt(value.fiducialId)
    }
}
