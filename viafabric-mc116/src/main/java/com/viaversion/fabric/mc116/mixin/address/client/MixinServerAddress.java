/*
 * This file is part of ViaFabric - https://github.com/ViaVersion/ViaFabric
 * Copyright (C) 2018-2024 ViaVersion and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.viaversion.fabric.mc116.mixin.address.client;

import com.mojang.datafixers.util.Pair;
import com.viaversion.fabric.common.AddressParser;
import net.minecraft.client.network.ServerAddress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerAddress.class)
public abstract class MixinServerAddress {
    @Shadow
    private static Pair<String, Integer> resolveServer(String address) {
        throw new AssertionError();
    }

    @Redirect(method = "parse", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ServerAddress;resolveServer(Ljava/lang/String;)Lcom/mojang/datafixers/util/Pair;"))
    private static Pair<String, Integer> modifySrvAddr(String address) {
        AddressParser viaAddr = new AddressParser().parse(address);
        if (viaAddr.viaSuffix == null) {
            return resolveServer(address);
        }

        return resolveServer(viaAddr.serverAddress).mapFirst(it -> it.replaceAll("\\.$", "") + "." + viaAddr.getSuffixWithOptions());
    }
}
