package com.inautix.XBBNHBS.TheatreDetails;

import java.util.Iterator;
import java.util.List;

public class TheatreDetails {

	public void displayTheatreDetails(int movieId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		TheatreDetailsDao dao = new TheatreDetailsDao();
		System.out.println("Theatres which plays your chosen movie are:");
		System.out.println("TheatreId TheatreName");
		List<TheatreDetailsBean> theatresList = dao.getTheatreDetails(movieId);
		Iterator<TheatreDetailsBean> iterator = theatresList.iterator();
		while(iterator.hasNext()){
			TheatreDetailsBean theatre = iterator.next();
			System.out.println(theatre.getTheatreId()+" "+theatre.getTheatreName());
		}
	}

}
