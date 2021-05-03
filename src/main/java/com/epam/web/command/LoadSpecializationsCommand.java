package com.epam.web.command;

import com.epam.web.entity.Faculty;
import com.epam.web.entity.Specialization;
import com.epam.web.entity.image.FacultyImage;
import com.epam.web.entity.image.SpecializationImage;
import com.epam.web.service.FacultyService;
import com.epam.web.service.ImageService;
import com.epam.web.service.ServiceException;
import com.epam.web.service.SpecializationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class LoadSpecializationsCommand implements Command {
    private final FacultyService facultyService;
    private final SpecializationService specializationService;
    private final ImageService imageService;

    public LoadSpecializationsCommand(FacultyService facultyService, SpecializationService specializationService, ImageService imageService) {
        this.facultyService = facultyService;
        this.specializationService = specializationService;
        this.imageService = imageService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, Exception {
        int facultyId = Integer.parseInt(request.getParameter("currentFaculty"));
        int page = Integer.parseInt(request.getParameter("page"));
        int total = Integer.parseInt(request.getParameter("specializationsPerPage"));
        List<Specialization> specializationList = specializationService.getLimitedSpecializations(facultyId, (page - 1) * total, total);
        List<SpecializationImage> imageList = imageService.getLimitedSpecializationImages(facultyId);
        LinkedHashMap<Specialization, SpecializationImage> specializationMap = getMap(specializationList, imageList);
        if (specializationMap.isEmpty()) {
            request.getSession().setAttribute("reportMessage", "Images error");
            return CommandResult.forward("/controller?command=errorPage");
        }
        List<Specialization> nextSpecializationList = specializationService.getLimitedSpecializations(facultyId, page * total, total);
        Optional<Faculty> optionalFaculty = facultyService.getFaculty(facultyId);
        Faculty faculty;
        FacultyImage facultyImage;
        if (!optionalFaculty.isPresent()) {
            request.getSession().setAttribute("reportMessage", "Faculty not found");
            return CommandResult.forward("/controller?command=errorPage");
        } else {
            faculty=optionalFaculty.get();
            facultyImage= getFacultyImage(optionalFaculty.get());
            if(facultyImage==null){
                request.getSession().setAttribute("reportMessage", "Images error");
                return CommandResult.forward("/controller?command=errorPage");
            }
        }
        request.getSession().setAttribute("selectedFaculty",faculty);
        request.getSession().setAttribute("selectedFacultyImage",facultyImage);
        request.getSession().setAttribute("hasNext", !nextSpecializationList.isEmpty());
        request.getSession().setAttribute("specializationMap", specializationMap);
        return CommandResult.forward("/controller?command=facultyPage&page=" + page);
    }

    private LinkedHashMap<Specialization, SpecializationImage> getMap(List<Specialization> specializationList, List<SpecializationImage> imageList) throws Exception, ServiceException {
        LinkedHashMap<Specialization, SpecializationImage> specializationMap = new LinkedHashMap<>();
        if (!imageList.isEmpty()) {
            for (int i = 0; i < specializationList.size(); i++) {
                SpecializationImage image = null;
                int id = specializationList.get(i).getId();
                for (int j = 0; j < imageList.size(); j++) {
                    if (imageList.get(j).getId().equals(id)) {
                        image = imageList.get(j);
                        break;
                    }
                }
                if (image == null) {
                    Optional<SpecializationImage> notFoundImage = imageService.getSpecializationImage(0);
                    if (notFoundImage.isPresent()) {
                        image = notFoundImage.get();
                    } else {
                        return null;
                    }
                }
                specializationMap.put(specializationList.get(i), image);
            }
        } else {
            Optional<SpecializationImage> notFoundImage = imageService.getSpecializationImage(0);
            if (!notFoundImage.isPresent()) {
                return null;
            }
            for (Specialization specialization : specializationList) {
                specializationMap.put(specialization, notFoundImage.get());
            }
        }
        return specializationMap;
    }

    private FacultyImage getFacultyImage(Faculty faculty) throws ServiceException, Exception {
        List<FacultyImage> facultyImageList = imageService.getLimitedFacultyImages();
        FacultyImage image = null;
        int id = faculty.getId();
        for (int j = 0; j < facultyImageList.size(); j++) {
            if (facultyImageList.get(j).getId().equals(id)) {
                image = facultyImageList.get(j);
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
        return image;
    }
}
