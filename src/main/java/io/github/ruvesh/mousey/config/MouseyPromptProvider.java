package io.github.ruvesh.mousey.config;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class MouseyPromptProvider implements PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString("mousey:> ", AttributedStyle.BOLD.foreground(AttributedStyle.YELLOW));
    }
}
