package org.milan.shell.providers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

/**
 * Simple Prompt Provider
 *
 * @author Milan Rathod
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimplePromptProvider extends DefaultPromptProvider {

    @Override
    public String getPrompt() {
        return "test-shell>";
    }

    @Override
    public String getProviderName() {
        return "Test Prompt";
    }
}
