package io.github.rjhaytree.apiservicetest;

import com.google.inject.Inject;
import io.github.rjhaytree.apiservicetest.service.TestService;
import io.github.rjhaytree.apiservicetest.service.TestServiceImpl;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "apiservicetest",
        name = "APIServiceTest",
        description = "A test plugin to learn how services and API function on sponge servers.",
        authors = {
                "RyanJH"
        }
)
public class APIServiceTest {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        CommandSpec test = CommandSpec.builder()
                .executor(new TestCommand(this))
                .build();

        Sponge.getCommandManager().register(this, test, "test");
    }

    @Listener
    public void gameConstruct(GameConstructionEvent event) {
        Sponge.getServiceManager().setProvider(this, TestService.class, new TestServiceImpl(this));
    }

    public Logger getLogger() {
        return this.logger;
    }
}
