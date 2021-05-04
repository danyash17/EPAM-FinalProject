package com.epam.web.command;

import com.epam.web.entity.Faculty;
import com.epam.web.entity.image.FacultyImage;
import com.epam.web.service.FacultyService;
import com.epam.web.service.ImageService;
import com.epam.web.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class LoadFacultiesCommand implements Command {
    private final Logger LOGGER = LogManager.getLogger(LoadFacultiesCommand.class);
    private final FacultyService facultyService;
    private final ImageService imageService;
    private final String loadAtPage;

    public LoadFacultiesCommand(FacultyService facultyService, ImageService imageService, String loadAtPage) {
        this.facultyService = facultyService;
        this.imageService = imageService;
        this.loadAtPage = loadAtPage;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        int page = Integer.parseInt(request.getParameter("page"));
        int total = Integer.parseInt(request.getParameter("facultiesPerPage"));
        List<Faculty> facultyList = facultyService.getLimitedFaculties((page - 1) * total, total);
        List<FacultyImage> imageList = imageService.getFacultyImages();
        LinkedHashMap<Faculty,FacultyImage> facultyMap=getMap(facultyList,imageList);
        List<Faculty> nextFacultyList = facultyService.getLimitedFaculties(page * total, total);
        if(facultyMap.isEmpty()){
            LOGGER.warn("Critical images error");
            request.getSession().setAttribute("reportMessage", "Images error");
            return CommandResult.forward("/controller?command=errorPage");
        }
        request.getSession().setAttribute("hasNext", !nextFacultyList.isEmpty());
        request.getSession().setAttribute("facultyMap", facultyMap);
        return CommandResult.forward("/controller?command="+loadAtPage+"&page=" + page);
    }
    private LinkedHashMap<Faculty,FacultyImage> getMap(List<Faculty> facultyList,List<FacultyImage> imageList) throws Exception, ServiceException {
        LinkedHashMap<Faculty,FacultyImage> facultyMap=new LinkedHashMap<>();
        if(!imageList.isEmpty()) {
            for (int i = 0; i < facultyList.size(); i++) {
                FacultyImage image=null;
                int id=facultyList.get(i).getId();
                for(int j=0;j<imageList.size();j++){
                    if(imageList.get(j).getId().equals(id)){
                        image=imageList.get(j);
                        break;
                    }
                }
                if (image == null) {
                    Optional<FacultyImage> notFoundImage = imageService.getFacultyImage(0);
                    if (notFoundImage.isPresent()) {
                        image = notFoundImage.get();
                    } else {
                        return null;
                    }
                }
                facultyMap.put(facultyList.get(i), image);
            }
        }
        else {
            Optional<FacultyImage> notFoundImage = imageService.getFacultyImage(0);
            if (!notFoundImage.isPresent()) {
                return null;
            }
            for (Faculty faculty:facultyList) {
                facultyMap.put(faculty,notFoundImage.get());
            }
        }
        return facultyMap;
    }
}
