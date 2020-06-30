package io.github.rjhaytree.apiservicetest.events;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;

public interface TestEvent {

    Player getPlayer();

    Cause getCause();

    boolean isCancelled();

    void setCancelled(boolean cancel);
}
