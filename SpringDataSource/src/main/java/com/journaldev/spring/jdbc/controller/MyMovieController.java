package com.journaldev.spring.jdbc.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.journaldev.spring.jdbc.model.MyMovies;

@Controller
public class MyMovieController {

	private static final Logger logger = LoggerFactory.getLogger(MyMovieController.class);
	@Autowired
	@Qualifier("dbDataSource")
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@RequestMapping(value = "/rest/movies", method = RequestMethod.GET)
	public @ResponseBody List<MyMovies> getMovies() {
		logger.info("Start getMovies.");
		List<MyMovies> movieList = new ArrayList<MyMovies>();
		//JDBC Code - Start
		String query = "select * from my_movies order by title asc";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Map<String,Object>> movieRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> movieRow : movieRows){
			MyMovies movie = new MyMovies();
			movie.setId(Integer.parseInt(String.valueOf(movieRow.get("id"))));
			movie.setTitle(String.valueOf(movieRow.get("title")));
			movie.setImdb_link(String.valueOf(movieRow.get("imdb_link")));
			movie.setCover_link(String.valueOf(movieRow.get("cover_link")));
			movie.setInsert_date(Date.valueOf(String.valueOf(movieRow.get("insert_date"))));
			movieList.add(movie);
		}		
		return movieList;
	}
	
}
