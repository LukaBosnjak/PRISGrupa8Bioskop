<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
     prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="FilmStyle.css">
<title>Movie</title>
</head>
<body>
<div class="movie-card">
  
  <div class="container">
    
    <a href="#"><img src="${movieTrailer }" alt="cover" class="cover" /></a>
        
    <div class="hero">
            
      <div class="details">
      
        <div class="title1">${movieTitle }</div>

        <div class="title2">${movieTitle2 }</div>    
        
        <fieldset class="rating">
		    <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
		    <input type="radio" id="star4half" name="rating" value="4 and a half" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
		    <input type="radio" id="star4" name="rating" value="4" checked /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
		    <input type="radio" id="star3half" name="rating" value="3 and a half" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
		    <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
		    <input type="radio" id="star2half" name="rating" value="2 and a half" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
		    <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
		    <input type="radio" id="star1half" name="rating" value="1 and a half" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>
		    <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
		    <input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
		  </fieldset>
        
      </div> <!-- end details -->
      
    </div> <!-- end hero -->
    
    <div class="description">
      
      <div class="column1">
        <span class="tag">${movieZanr }</span>
      </div> <!-- end column1 -->
      
      <div class="column2">
        
        <p>${description }</p>
          
        </div> <!-- end avatars -->
        
        
        
      </div> <!-- end column2 -->
    </div> <!-- end description -->
    
   
  </div> <!-- end container -->
</body>
</html>