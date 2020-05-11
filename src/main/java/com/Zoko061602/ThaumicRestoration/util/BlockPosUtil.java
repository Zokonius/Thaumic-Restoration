package com.Zoko061602.ThaumicRestoration.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class BlockPosUtil { // cHJvZCB3YXMgaGVyZQ==
    public static Vec3s translate(BlockPos bp, double x, double y, double z) {
        return new Vec3s(bp.getX() + x, bp.getY() + y, bp.getZ() + z);
    }

    public static Vec3d translateToVec3d(BlockPos bp, double x, double y, double z) {
        return new Vec3d(bp.getX() + x, bp.getY() + y, bp.getZ() + z);
    }

    public static BlockPos translateToBlockPos(BlockPos bp, double x, double y, double z) {
        return new BlockPos(bp.getX() + x, bp.getY() + y, bp.getZ() + z);
    }

    public static double[] translateToArray(BlockPos bp, double x, double y, double z) {
        return new double[] { bp.getX() + x, bp.getY() + y, bp.getZ() + z };
    }

    /**
     * Simple vector implementation that doesn't contain methods.
     * for vector with methods, use """net.minecraft.util.math.Vec3d"""
     */
    public static class Vec3s {
        public final double x;
        public final double y;
        public final double z;

        public static Vec3s ZERO = new Vec3s(0, 0, 0);

        public Vec3s() { this(ZERO); }

        public Vec3s(Vec3s v) { this(v.x, v.y, v.z); }

        public Vec3s(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}