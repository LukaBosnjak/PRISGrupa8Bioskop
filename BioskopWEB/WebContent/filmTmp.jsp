<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="filmStyle.css">
<title>Movie</title>
</head>
<body>
	<div class="movie-card">

		<div class="container">

			<img height="300" src="${moviePoster } " alt="cover" class="cover" style="filter: drop-shadow(8px 8px 10px black);" />

			<div class="hero">

				<div class="details" style="padding: 190px 0 0 280px;">

					<div class="title1"
						style="color: #f92247; font-size: 44px; margin-bottom: 13px; position: relative; filter: drop-shadow(8px 8px 10px black);">
						${movieTitle }</div>

					<div class="title2"
						style="color: #C7C1BA; font-size: 23px; font-weight: 300; margin-bottom: 15px; filter: drop-shadow(8px 8px 10px black);">
						${roles }</div>

					<fieldset class="rating" style="filter: drop-shadow(8px 8px 10px black);">
						<input type="radio" id="star5" name="rating" value="5" /><label
							class="full" for="star5" title="Awesome - 5 stars"></label> <input
							type="radio" id="star4half" name="rating" value="4.5" /><label
							class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
						<input type="radio" id="star4" name="rating" value="4" checked /><label
							class="full" for="star4" title="Pretty good - 4 stars"></label> <input
							type="radio" id="star3half" name="rating" value="3.5" /><label
							class="half" for="star3half" title="Meh - 3.5 stars"></label> <input
							type="radio" id="star3" name="rating" value="3" /><label
							class="full" for="star3" title="Meh - 3 stars"></label> <input
							type="radio" id="star2half" name="rating" value="2.5" /><label
							class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
						<input type="radio" id="star2" name="rating" value="2" /><label
							class="full" for="star2" title="Kinda bad - 2 stars"></label> <input
							type="radio" id="star1half" name="rating" value="1.5" /><label
							class="half" for="star1half" title="Meh - 1.5 stars"></label> <input
							type="radio" id="star1" name="rating" value="1" /><label
							class="full" for="star1" title="Sucks big time - 1 star"></label>
						<input type="radio" id="starhalf" name="rating" value="0.5" /><label
							class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
					</fieldset>
					<span class="likes"
						style="margin-left: 24px; position: relative; top: 2px; padding-right: 7px; filter: drop-shadow(8px 8px 10px black);">
						<img
						src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/195612/icon_like.png"
						alt="hart" />${rate }</span>
				</div>
				<!-- end details -->

			</div>
			<!-- end hero -->

			<div class="description">

				<div class="column1">
					<span class="tag"
						style="position: absolute; top: 3px; margin-left: 12px; background: #C4AF3D; border-radius: 5px; color: #544C21; font-size: 14px; padding: 0px 4px;">${movieZanr }</span><br>
					<span class="tag"><a href="${movieTrailer }" style="filter: drop-shadow(8px 8px 10px black);">${movieTrailer }</a></span>
				</div>
				<!-- end column1 -->

				<div class="column2"
					style="bottom: 0px; height: 200px; font-size: 16px; line-height: 26px; color: #B1B0AC; padding-left: 41px; padding-top: 30px; margin-left: 20px; width: 480px; float: left;">

					<p style="color:#705157;">${description }</p>

				</div>
				<!-- end avatars -->



			</div>
			<!-- end column2 -->
		</div>
		<!-- end description -->


	</div>
	<!-- end container -->
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							$(".rating input:radio").attr("checked", false);

							$(".input:radio")

							$('.rating input').click(function() {
								$(".rating span").removeClass('checked');
								$(this).parent().addClass('checked');
							});

							$('input:radio')
									.change(
											function() {
												var tmp = -1;
												if (tmp !== this.value) {
													tmp = this.value;
													var userRating = {
														rating : this.value
													};
													$
															.post(
																	"http://localhost:8080/BioskopWEB/FilmoviServlet",
																	$
																			.param(userRating),
																	function(
																			response) {
																		alert('Your vote has been submitted.');
																	});
												}
											});
						});
	</script>
</body>
</html>