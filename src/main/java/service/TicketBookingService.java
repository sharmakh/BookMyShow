package service;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TicketBookingService {

   public void bookTicket(Movie movie, Show show, Theater t1){
       if(!t1.getMovieList().containsKey(movie)){
           System.out.println("movie is not available in the theater");
           return;
       }
       Map<Movie, List<Show>> movieListMap = t1.getMovieList();
       if(!movieListMap.get(movie).contains(show)){
           System.out.println("movie is not available for the selected show");
           return;
       }
       boolean isFull = true;
       int screenId = -1;
       for(Screen sc : movie.getScreens()){
           if(sc.getCapacity() > 0){
               isFull = false;
               screenId = sc.getScreenId();
               sc.setCapacity(sc.getCapacity()-1);
               break;
           }
       }
       if(isFull){
           System.out.println("all available screens are full");
       }
       Ticket ticket = Ticket.builder().ticketId(String.valueOf(UUID.randomUUID())).screenId(screenId).movieId(movie.getId())
               .theaterId(t1.getId()).timing(show.getStart()).build();
       List<Ticket> ticketList = t1.getTicketList();
       if(ticketList == null || ticketList.size() == 0){
           ticketList = new ArrayList<>();
       }
       ticketList.add(ticket);
       t1.setTicketList(ticketList);
       System.out.println("Ticket is booked Successfully and id is : "+ticket.getTicketId());
   }
}
