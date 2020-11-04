package com.borikov.laba8_1.controller.command;

import com.borikov.laba8_1.controller.command.impl.*;
import com.borikov.laba8_1.controller.command.impl.page.*;

public enum CommandType {
    BROWSE_BALL_VOLUME_PAGE_COMMAND(new BrowseBallVolumePageCommand()),
    BROWSE_CUBE_VOLUME_PAGE_COMMAND(new BrowseCubeVolumePageCommand()),
    BROWSE_PARALLELEPIPED_VOLUME_PAGE_COMMAND(new BrowseParallelepipedVolumePageCommand()),
    BROWSE_SPHERE_VOLUME_PAGE_COMMAND(new BrowseSphereVolumePageCommand()),
    BROWSE_TETRAHEDRON_VOLUME_PAGE_COMMAND(new BrowseTetrahedronVolumePageCommand()),
    BROWSE_TORUS_VOLUME_PAGE_COMMAND(new BrowseTorusVolumePageCommand()),
    CALCULATE_BALL_VOLUME_COMMAND(new CalculateBallVolumeCommand()),
    CALCULATE_CUBE_VOLUME_COMMAND(new CalculateCubeVolumeCommand()),
    CALCULATE_PARALLELEPIPED_VOLUME_COMMAND(new CalculateParallelepipedVolumeCommand()),
    CALCULATE_SPHERE_VOLUME_COMMAND(new CalculateSphereVolumeCommand()),
    CALCULATE_TETRAHEDRON_VOLUME_COMMAND(new CalculateTetrahedronVolumeCommand()),
    CALCULATE_TORUS_VOLUME_COMMAND(new CalculateTorusVolumeCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
