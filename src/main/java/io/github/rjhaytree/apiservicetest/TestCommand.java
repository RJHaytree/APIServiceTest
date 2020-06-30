package io.github.rjhaytree.apiservicetest;

import io.github.rjhaytree.apiservicetest.events.TestEventImpl;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.text.Text;

public class TestCommand implements CommandExecutor {
    private APIServiceTest plugin;

    public TestCommand(APIServiceTest plugin) {
        this.plugin = plugin;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)) {
            src.sendMessage(Text.of("You must be in game to run this command."));
            return CommandResult.empty();
        }

        Player player = (Player) src;

        EventContext context = EventContext.builder().build();
        Cause cause = Cause.builder().append(player).build(context);
        boolean success = Sponge.getEventManager().post(new TestEventImpl(cause, player));
        return success ? CommandResult.success() : CommandResult.empty();
    }
}
