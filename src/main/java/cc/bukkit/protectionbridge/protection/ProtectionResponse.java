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

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import cc.bukkit.protectionbridge.RequiredCheckPlayer;

public class ProtectionResponse {
    public enum ResponseType {
        ACCESSED(0),
        DENIED(1),
        NOT_IMPLEMENTED(-1);

        private int id;

        ResponseType(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public ProtectionResponse(@NotNull Location location, @NotNull RequiredCheckPlayer player, @NotNull ResponseType type, @Nullable Plugin cancelPlugin, @Nullable String errorMessages) {
        this.location = location;
        this.player = player;
        this.type = type;
        this.cancelPlugin = cancelPlugin;
        this.errorMessages = errorMessages;
        if(type == ResponseType.DENIED&& (cancelPlugin == null || errorMessages == null)){
            throw new IllegalArgumentException("cancelPlugin and errorMessages cannot be null if type is DENIED");
        }
    }

    @NotNull
    public final Location location;
    @NotNull
    public final RequiredCheckPlayer player;
    @NotNull
    public final ResponseType type;
    @Nullable
    public final Plugin cancelPlugin;
    @Nullable
    public final String errorMessages;

    /**
     * Get the location to checking
     *
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Get player that checking
     *
     * @return The RequiredCheckPlayer
     */
    public RequiredCheckPlayer getPlayer() {
        return player;
    }

    /**
     * Get checking result
     *
     * @return The response result.
     */
    public ResponseType getType() {
        return type;
    }

    /**
     * Get who plugin reject the protection request
     *
     * @return The plugin reject the player build checks in this request.
     */
    public Plugin getCancelPlugin() {
        return cancelPlugin;
    }

    /**
     * Get who plugin reject the protection request error messages
     *
     * @return The messages leaved from reject the player build checks in this request plugin.
     */
    public String getErrorMessages() {
        return errorMessages;
    }
}
