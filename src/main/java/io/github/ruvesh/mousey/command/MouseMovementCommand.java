package io.github.ruvesh.mousey.command;

import io.github.ruvesh.mousey.process.MouseMoverProcess;
import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.context.InteractionMode;
import org.springframework.shell.standard.*;

@ShellComponent
@ShellCommandGroup("Mouse Movement Commands")
public class MouseMovementCommand  {
    private final LineReader lineReader;
    private final Terminal terminal;

    public MouseMovementCommand(@Lazy LineReader lineReader, Terminal terminal) {
        this.lineReader = lineReader;
        this.terminal = terminal;
    }

    @ShellMethod(
            key = "tarantallegra",
            value = "The quintessential Hogwarts spell to hysterically move something.",
            interactionMode = InteractionMode.INTERACTIVE
    )
    public String moveMouse(@ShellOption(
            defaultValue = "1", value = "interval", help = "interval between the hysterical spasms") int interval) {
        String inp = "";
        MouseMoverProcess mouseMoverProcess = new MouseMoverProcess(interval);
        mouseMoverProcess.start();
        terminal.writer().println("Casting a spell to randomly move your mouse in intervals of " + interval + "s");
        terminal.flush();
        while (!inp.equalsIgnoreCase("finite")){
            inp = lineReader.readLine("Wanna stop it? Say \"finite\": ");
        }
        mouseMoverProcess.stop();
        return "Your mouse is now free from the spell!! :p";
    }

}
