package com.borikov.laba8_1.controller.command.impl;

import com.borikov.laba8_1.controller.PagePath;
import com.borikov.laba8_1.controller.RequestParameter;
import com.borikov.laba8_1.controller.command.Command;
import com.borikov.laba8_1.exception.IncorrectDataException;
import com.borikov.laba8_1.service.FigureService;
import com.borikov.laba8_1.service.impl.FigureServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CalculateSphereVolumeCommand implements Command {
    private static final FigureService figureService = new FigureServiceImpl();
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String radius = request.getParameter(RequestParameter.RADIUS);
        String accuracy = request.getParameter(RequestParameter.ACCURACY);
        try {
            double ballVolume = figureService.calculateSphereVolume(radius, accuracy);
            request.setAttribute(RequestParameter.RESULT, ballVolume);
            page = PagePath.RESULT;
        } catch (IncorrectDataException e) {
            LOGGER.log(Level.ERROR, "Error while calculate sphere volume", e);
            request.setAttribute(RequestParameter.INCORRECT_DATA, true);
            page = PagePath.SPHERE_VOLUME;
        }
        return page;
    }
}
