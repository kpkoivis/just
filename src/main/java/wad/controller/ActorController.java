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
import wad.domain.SpaceResource;
import wad.domain.Reservation;
import wad.repository.ActorRepository;
import wad.repository.MovieRepository;

@Controller
@RequestMapping("actors")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("actors", actorRepository.findAll());
        //model.addAttribute("airports", airportRepository.findAll());

        return "/WEB-INF/views/actors.jsp";
    }

    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute SpaceResource actor) {
        actorRepository.save(actor);
        return "redirect:/actors";
    }
    
    
    @RequestMapping(value = "/{actorId}", method = RequestMethod.GET)
    public String deleteActor(Model model, @PathVariable Long actorId) {
        SpaceResource actor = actorRepository.findOne(actorId);
        List<Reservation> movies = movieRepository.findAll();
        model.addAttribute("actor", actor);
        model.addAttribute("movies", movies);
        return "/WEB-INF/views/actor.jsp";
    }
    
 
    @RequestMapping(value = "/{actorId}", method = RequestMethod.DELETE)
    public String deleteActor(@PathVariable Long actorId) {
        SpaceResource actor = actorRepository.findOne(actorId);
        List<Reservation> movies = actor.getMovies();
        for (Reservation m : movies) {
            m.getActors().remove(actor);
            movieRepository.save(m);
        }
        actorRepository.delete(actor);
        return "redirect:/actors";
    }
    
    @RequestMapping(value = "/{actorId}/movies", method = RequestMethod.POST)
    public String addActorToMovie(Model model, @PathVariable Long actorId, @RequestParam Long movieId) {
        SpaceResource actor = actorRepository.findOne(actorId);
        Reservation movie = movieRepository.findOne(movieId);
        actor.getMovies().add(movie);
        movie.getActors().add(actor);
        actorRepository.save(actor);
        movieRepository.save(movie);
        return "redirect:/actors";
    }
}
