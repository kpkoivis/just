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
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "/WEB-INF/views/movies.jsp";
    }

    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute Reservation movie) {
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.DELETE)
    public String deleteMovie(@PathVariable Long movieId) {
        Reservation movie = movieRepository.findOne(movieId);
        List<SpaceResource> actors = movie.getActors();
        for (SpaceResource a : actors) {
            a.getMovies().remove(movie);
            actorRepository.save(a);
        }
        movieRepository.delete(movie);
        return "redirect:/movies";
    }
}
