/*
 * This file is part of ProtectionBridge.
 * ProtectionBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * ProtectionBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with ProtectionBridge.  If not, see <http://www.gnu.org/licenses/>.
 */

package cc.bukkit.protectionbridge.adapter;

import cc.bukkit.protectionbridge.ProtectionBridge;
import cc.bukkit.protectionbridge.RequiredCheckPlayer;
import cc.bukkit.protectionbridge.protection.Protection;
import cc.bukkit.protectionbridge.protection.ProtectionAction;
import cc.bukkit.protectionbridge.protection.ProtectionFlag;
import cc.bukkit.protectionbridge.protection.ProtectionResponse;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GriefPreventionAdapter implements Protection {
    private final boolean isEnabled;
    private final ProtectionBridge plugin;
    private final GriefPrevention griefPrevention;

    public GriefPreventionAdapter(@NotNull ProtectionBridge plugin, @Nullable GriefPrevention griefPrevention) {
        this.plugin = plugin;
        this.isEnabled = griefPrevention != null && griefPrevention.isEnabled();
        this.griefPrevention = griefPrevention;
    }

    /**
     * Checks if protection method is enabled.
     *
     * @return Success or Failure
     */
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    /**
     * Gets name of Protection method.
     *
     * @return Name of Protection Method.
     */
    @Override
    public @NotNull String getName() {
        return griefPrevention.getName();
    }

    /**
     * Gets the Protection method Plugin instance
     *
     * @return Plugins instance of Protection Method.
     */
    @Override
    public @NotNull Plugin getPlugin() {
        return griefPrevention;
    }

    /**
     * Checks if protection method support custom flags.
     *
     * @return Support or Not support.
     */
    @Override
    public boolean hasFlagSupport() {
        return false;
    }

    /**
     * Do permission checks with location
     *
     * @param location The location that you want to checks
     * @param player   The target player
     * @param action   The action
     * @return The result
     */
    @Override
    public @NotNull ProtectionResponse check(@NotNull Location location, @NotNull RequiredCheckPlayer player, @NotNull ProtectionAction action) {
        return check(location.getBlock(),player,action);
    }

    /**
     * Do permission checks with block
     *
     * @param block  The location that you want to checks
     * @param player The target player
     * @param action The action
     * @return The result
     */
    @Override
    public @NotNull ProtectionResponse check(@NotNull Block block, @NotNull RequiredCheckPlayer player, @NotNull ProtectionAction action) {
        if(player.isVirtual()){
            return new ProtectionResponse(block.getLocation(),player, ProtectionResponse.ResponseType.ACCESSED, plugin, "GriefPrevention doesn't support virtual player, skipping");
        }
        Player bPlayer = Bukkit.getPlayer(player.getUuid());
        if(bPlayer==null){
            return new ProtectionResponse(block.getLocation(),player, ProtectionResponse.ResponseType.ACCESSED, plugin, "GriefPrevention doesn't support offline player, skipping");
        }

        if(action == ProtectionAction.BREAK){
            String noBuildReason = GriefPrevention.instance.allowBreak(bPlayer,block,block.getLocation());
            if(noBuildReason == null){
                return new ProtectionResponse(block.getLocation(),player, ProtectionResponse.ResponseType.ACCESSED, null, null);
            }
            return new ProtectionResponse(block.getLocation(),player, ProtectionResponse.ResponseType.DENIED, GriefPrevention.instance, noBuildReason);
        }else{
            String noBuildReason = GriefPrevention.instance.allowBuild(bPlayer,block.getLocation(), block.getType());
            if(noBuildReason == null){
                return new ProtectionResponse(block.getLocation(),player, ProtectionResponse.ResponseType.ACCESSED, null, null);
            }
            return new ProtectionResponse(block.getLocation(),player, ProtectionResponse.ResponseType.DENIED, GriefPrevention.instance, noBuildReason);
        }
    }

    /**
     * Do permission checks with location
     *
     * @param location The location that you want to checks
     * @param player   The target player
     * @param action The action
     * @param flag The custom flag
     * @return The result
     */
    @Override
    public @NotNull ProtectionResponse check(@NotNull Location location, @NotNull RequiredCheckPlayer player, @NotNull ProtectionAction action, @Nullable ProtectionFlag flag) {
        return check(location,player,action);
    }

    /**
     * Do permission checks with block
     *
     * @param block  The location that you want to checks
     * @param player The target player
     * @param action The action
     * @param flag The custom flag
     * @return The result
     */
    @Override
    public @NotNull ProtectionResponse check(@NotNull Block block, @NotNull RequiredCheckPlayer player, @NotNull ProtectionAction action, @Nullable ProtectionFlag flag) {
        return check(block,player,action);
    }
}
