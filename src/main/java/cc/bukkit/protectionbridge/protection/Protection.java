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

package cc.bukkit.protectionbridge.protection;

import cc.bukkit.protectionbridge.RequiredCheckPlayer;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Protection {
    /**
     * Checks if protection method is enabled.
     *
     * @return Success or Failure
     */
    boolean isEnabled();

    /**
     * Gets name of Protection method.
     *
     * @return Name of Protection Method.
     */
    @NotNull String getName();

    /**
     * Gets the Protection method Plugin instance
     *
     * @return Plugins instance of Protection Method.
     */
    @NotNull Plugin getPlugin();

    /**
     * Checks if protection method support custom flags.
     *
     * @return Support or Not support.
     */
    boolean hasFlagSupport();

    /**
     * Do permission checks with location
     *
     * @param location The location that you want to checks
     * @param player   The target player
     * @param action   The action
     * @return The result
     */
    @NotNull ProtectionResponse check(@NotNull Location location, @NotNull RequiredCheckPlayer player, @NotNull ProtectionAction action);

    /**
     * Do permission checks with block
     *
     * @param block  The location that you want to checks
     * @param player The target player
     * @param action The action
     * @return The result
     */
    @NotNull ProtectionResponse check(@NotNull Block block, @NotNull RequiredCheckPlayer player, @NotNull ProtectionAction action);

    /**
     * Do permission checks with location
     *
     * @param location The location that you want to checks
     * @param player   The target player
     * @param action   The action
     * @param flag The custom protection flag
     * @return The result
     */
    @NotNull ProtectionResponse check(@NotNull Location location, @NotNull RequiredCheckPlayer player, @NotNull ProtectionAction action, @Nullable ProtectionFlag flag);

    /**
     * Do permission checks with block
     *
     * @param block  The location that you want to checks
     * @param player The target player
     * @param action   The action
     * @param flag The custom protection flag
     * @return The result
     */
    @NotNull ProtectionResponse check(@NotNull Block block, @NotNull RequiredCheckPlayer player, @NotNull ProtectionAction action, @Nullable ProtectionFlag flag);
}
