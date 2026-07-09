package com.ajxd4.setblockfix.mixin;

import com.ajxd4.setblockfix.LargeDripstoneFeatureState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.feature.LargeDripstoneFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LargeDripstoneFeature.class)
public class LargeDripstoneFeatureMixin {

    @Inject(method = "generate", at = @At("HEAD"))
    private void onGenerateStart(FeatureContext<?> context, CallbackInfoReturnable<Boolean> cir) {
        BlockPos origin = context.getOrigin();
        LargeDripstoneFeatureState.FEATURE_CENTER.set(ChunkPos.toLong(origin.getX() >> 4, origin.getZ() >> 4));
    }

    @Inject(method = "generate", at = @At("RETURN"))
    private void onGenerateEnd(FeatureContext<?> context, CallbackInfoReturnable<Boolean> cir) {
        LargeDripstoneFeatureState.FEATURE_CENTER.remove();
    }
}