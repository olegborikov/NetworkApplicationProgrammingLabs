package com.borikov.laba8_1.controller.command.impl.page;

import com.borikov.laba8_1.controller.PagePath;
import com.borikov.laba8_1.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class BrowseTorusVolumePageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.TORUS_VOLUME;
    }
}
