package io.github.rjhaytree.apiservicetest.events;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.impl.AbstractEvent;

public class TestEventImpl extends AbstractEvent implements Cancellable, TestEvent {
    private final Cause cause;
    private final Player player;
    private boolean cancelled = false;

    public TestEventImpl(Cause cause, Player player) {
        this.cause = cause;
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public Cause getCause() {
        return this.cause;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
