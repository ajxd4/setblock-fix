package com.ajxd4.setblockfix.mixin;

import com.ajxd4.setblockfix.LargeDripstoneFeatureState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.world.gen.feature.LargeDripstoneFeature$WindModifier")
public class WindModifierMixin {
    @Inject(method = "modify", at = @At("RETURN"), cancellable = true)
    private void clampWindOffset(BlockPos pos, CallbackInfoReturnable<BlockPos> cir) {
        BlockPos returned = cir.getReturnValue();
        if (returned == null)
            return;

        Long centerLong = LargeDripstoneFeatureState.FEATURE_CENTER.get();
        if (centerLong != null) {
            int centerX = ChunkPos.getPackedX(centerLong);
            int centerZ = ChunkPos.getPackedZ(centerLong);

            int minX = (centerX - 1) * 16;
            int maxX = (centerX + 2) * 16 - 1;
            int minZ = (centerZ - 1) * 16;
            int maxZ = (centerZ + 2) * 16 - 1;

            int clampedX = MathHelper.clamp(returned.getX(), minX, maxX);
            int clampedZ = MathHelper.clamp(returned.getZ(), minZ, maxZ);

            if (clampedX != returned.getX() || clampedZ != returned.getZ()) {
                cir.setReturnValue(new BlockPos(clampedX, returned.getY(), clampedZ));
            }
        } else {
            int dx = returned.getX() - pos.getX();
            int dz = returned.getZ() - pos.getZ();

            int clampedDx = MathHelper.clamp(dx, -15, 15);
            int clampedDz = MathHelper.clamp(dz, -15, 15);

            if (dx != clampedDx || dz != clampedDz) {
                cir.setReturnValue(pos.add(clampedDx, returned.getY() - pos.getY(), clampedDz));
            }
        }
    }
}