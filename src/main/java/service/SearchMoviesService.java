package service;

import model.Movie;
import model.Show;
import model.Theater;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchMoviesService {

    public void serachMovies(Theater theater,Movie movie){
        Map<Movie, List<Show>> moviesList = theater.getMovieList();
        for(Map.Entry<Movie, List<Show>> map:moviesList.entrySet()){
            System.out.println("movie name is : "+map.getKey().getName());
            AtomicInteger count = new AtomicInteger(1);
            map.getValue().forEach(show ->{
                System.out.println("show "+count);
                System.out.println("show start time is : "+show.getStart().toString());
                System.out.println("show end time is : " + show.getEnd().toString());
                count.getAndIncrement();
            });
        }
    }

    public void serachShows(Theater theater,Show show){
        Map<Movie, List<Show>> moviesList = theater.getMovieList();
        System.out.println("available movies for a show ");
        int count = 1;
        for(Map.Entry<Movie, List<Show>> map:moviesList.entrySet()){
           if(map.getValue().contains(show)){
               System.out.println("movie"+count+":"+map.getKey().getName());
               count++;
           }
        }
    }
}
