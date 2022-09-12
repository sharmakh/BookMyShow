import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import service.SearchMoviesService;
import service.TicketBookingService;

import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class BookMyShow {

    public static void main(String[] args){
      User A = User.builder().userId(1).accountNo("1234").address("Jaipur").email("email1").phoneNo("7263828477").build();
      User B = User.builder().userId(2).accountNo("5678").address("Jaipur").email("email2").phoneNo("7263828477").build();
      User C = User.builder().userId(3).accountNo("1001").address("Jaipur").email("email3").phoneNo("7263828477").build();

        BookingSystem bookingSystem = new BookingSystem();
        Map<Integer,User> userMap = new HashMap<>();
        userMap.put(A.getUserId(),A);
        userMap.put(B.getUserId(),B);
        userMap.put(C.getUserId(),C);
        bookingSystem.setUsers(userMap);

        Screen s1 = Screen.builder().screenId(1).capacity(50).name("A").build();
        Screen s2 = Screen.builder().screenId(2).capacity(50).name("B").build();
        Screen s3 = Screen.builder().screenId(3).capacity(50).name("C").build();
        Screen s4 = Screen.builder().screenId(4).capacity(50).name("D").build();


        Map<Movie, List<Show>> showListMap = new HashMap<>();

        Show show1 = Show.builder().showId(1).start(LocalDateTime.now().toLocalDate().atTime(16,0))
                .end(LocalDateTime.now().toLocalDate().atTime(19,0)).build();

        Show show2 = Show.builder().showId(1).start(LocalDateTime.now().toLocalDate().atTime(13,0))
                .end(LocalDateTime.now().toLocalDate().atTime(15,0)).build();


        LocalDateTime localDateTime1 = LocalDateTime.now().minusDays(3);
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int weekNumber = localDateTime1.get(woy);
        Movie movie1 = Movie.builder().id(1).name("Brahmastra").weekNo(weekNumber).releaseData(localDateTime1).screens(Arrays.asList(s1,s2)).build();



        localDateTime1 = LocalDateTime.now().minusDays(10);
        woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        weekNumber = localDateTime1.get(woy);
        Movie movie2 = Movie.builder().id(2).name("shamshera").weekNo(weekNumber).releaseData(localDateTime1).screens(Arrays.asList(s3,s4)).build();

        showListMap.put(movie1,Arrays.asList(show2));
        showListMap.put(movie2,Arrays.asList(show1,show2));


        Theater t1 = Theater.builder().screenList(Arrays.asList(s1,s2,s3,s4)).movieList(showListMap).build();

      SearchMoviesService searchMoviesService = new SearchMoviesService();
      searchMoviesService.serachMovies(t1,movie1);

      searchMoviesService.serachShows(t1,show2);
      TicketBookingService ticketBookingService = new TicketBookingService();
      ticketBookingService.bookTicket(movie1,show1,t1);
      ticketBookingService.bookTicket(movie1,show2,t1);
    }
}
