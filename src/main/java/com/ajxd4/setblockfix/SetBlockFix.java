package com.ajxd4.setblockfix;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetBlockFix implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("setblock-fix");

    @Override
    public void onInitialize() {
        LOGGER.info("[SetBlockFix] Large Dripstone patch loaded.");
    }
}