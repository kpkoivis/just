package wad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.resource.SpacialResource;
import wad.domain.Reservation;
import wad.domain.resource.Resource;
import wad.repository.ResourceRepository;
import wad.repository.MovieRepository;

@Controller
@RequestMapping("resources")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("actors", resourceRepository.findAll());
        //model.addAttribute("airports", airportRepository.findAll());

        return "/WEB-INF/views/actors.jsp";
    }

    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute SpacialResource actor) {
        resourceRepository.save(actor);
        return "redirect:/actors";
    }
    
    
    @RequestMapping(value = "/{resourceId}", method = RequestMethod.GET)
    public String deleteActor(Model model, @PathVariable Long resourceId) {
        Resource resource = resourceRepository.findOne(resourceId);
        List<Reservation> movies = movieRepository.findAll();
        model.addAttribute("resource", resource);
        model.addAttribute("movies", movies);
        return "/WEB-INF/views/actor.jsp";
    }
    
 
    @RequestMapping(value = "/{resourceId}", method = RequestMethod.DELETE)
    public String deleteActor(@PathVariable Long resourceId) {
        /*
        Resource resource = resourceRepository.findOne(resourceId);
        List<Reservation> reseravations = actor.getMovies();
        for (Reservation m : reseravations) {
            //m.getActors().remove(actor);
            movieRepository.save(m);
        }
        //resourceRepository.delete(actor);
                */
        return "redirect:/actors";
    }
    
    @RequestMapping(value = "/{resourceId}/movies", method = RequestMethod.POST)
    public String addActorToMovie(Model model, @PathVariable Long resourceId, @RequestParam Long movieId) {
        Resource actor = resourceRepository.findOne(resourceId);
        Reservation movie = movieRepository.findOne(movieId);
        //actor.getMovies().add(movie);
        //movie.getActors().add(actor);
        resourceRepository.save(actor);
        movieRepository.save(movie);
        return "redirect:/actors";
    }
}
