package org.milan.shell;

import org.milan.shell.util.DirectoryUtils;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

/**
 * Shell to support basic functionality similar to linux commands
 *
 * @author Milan Rathod
 */
@Component
public class LinuxSimulater implements CommandMarker {

    /**
     * ls command
     */
    @CliCommand(value = {"ls"}, help = "List contents of current directories.")
    public String listContents() {
        return DirectoryUtils.listDirectories().toString();
    }

    /**
     *
     */
    @CliCommand(value = {"cd"}, help = "Change Directories")
    public String changeDirectories(@CliOption(key = {""}, mandatory = true, help = "directory name to which redirect") String directory) {
        return DirectoryUtils.changeDirectory(directory);
    }

}