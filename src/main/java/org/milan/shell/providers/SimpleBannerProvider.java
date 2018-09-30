package org.milan.shell.providers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

/**
 * Simple Banner Provider
 *
 * @author Milan Rathod
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleBannerProvider extends DefaultBannerProvider {

    public String getBanner() {
        StringBuffer buf = new StringBuffer();
        buf.append("=======================================").append(OsUtils.LINE_SEPARATOR);
        buf.append("*          Customize Shell             *").append(OsUtils.LINE_SEPARATOR);
        buf.append("=======================================").append(OsUtils.LINE_SEPARATOR);
        buf.append("Version:").append(this.getVersion());
        return buf.toString();
    }

    public String getVersion() {
        return "1.0.0";
    }

    public String getWelcomeMessage() {
        return "Welcome to Test Shell";
    }

    @Override
    public String getProviderName() {
        return "Test Shell Banner";
    }
}
