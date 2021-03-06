<!DOCTYPE html>
<html>
    <head>
        <title>General Bookstore</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/main2.css">
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
        $(document).ready(function () {
        	var userId = $("#userId").val();
			document.cookie = "userId=" + userId + ";path=/";
			
			$(document).on("click", "#btn-logout", function () {
				deleteCookie("userId");
			});
			
			function deleteCookie(name) {
				document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;path=/';
			}
        });
        </script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet"> 
    </head>

    <body>
    <input type="hidden" id="userId" value="${userId}">
   	<!--header-->
		<header id="header">
			<div class="header_top">
				<div class="container">
					<div class="row">
						<div class="col-sm-6">
							<div class="contactinfo">
								<ul class="nav nav-pills">
									<li><a href=""><i class="fa fa-newspaper-o"></i> NEWS</a></li>
								</ul>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="social-icons pull-right"></div>
						</div>
					</div>
				</div>
			</div>
		
			<div class="header-middle">
				<div class="container">
					<div class="row">
						<div class="col-sm-8">
							<div class="shop-menu pull-left">
								<ul class="nav navbar-nav">
									<li><a href="home.html"><i class="fa fa-home"></i> Home</a></li>
									<li><a href="search.html"><i class="fa fa-search"></i> Search</a></li>
									<li><a href="popular.html"><i class="fa fa-star"></i> Popular</a></li>
									<li><a href="contact.html"><i class="fa fa-envelope"></i> Contact</a></li>
									<li><a href="aboutus.html"><i class="fa fa-info-circle"></i> About Us</a></li>
								</ul>
							</div>
						</div>
						
						<div class="col-sm-4">
							<div class="shop-menu pull-right">
								<ul class="nav navbar-nav">
									<li><a href="profile.html"><i class="fa fa-user"></i> Account</a></li>
									<li><a href="cart.html"><i class="fa fa-shopping-cart"></i> Cart</a></li>
									<li><a href="login.html"><i class="fa fa-lock"></i> Logout</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

      
    <!-- carousel -->
        <div class=" my-carousel container">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="./images/a.jpg" alt="Fast" style="width:100%;">
                    </div>

                    <div class="item">
                        <img src="./images/a.jpg" alt="Chicago" style="width:100%;">
                    </div>
                
                    <div class="item">
                        <img src="./images/a.jpg" alt="New york" style="width:100%;">
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        

	

    <!-- best seller section -->
    
	<div class="container-wrapper bs-sample">
        <h3 class="text-center" > Best Sellers </h3>
        <p class="text-center" style="font-style: italic"> See what fellow users are purchasing and loving! </p>
        <hr style="width:80%">
	
        <div class="container">
        <div class="row">
            <!-- BEGIN PRODUCTS -->
            <div class="col-md-3 col-sm-6">
                <span class="thumbnail">
                    <img src="images/into-water.jpg" alt="...">
                    <h4>Into the Water</h4>
                    <div class="ratings text-center">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p class="text-center">Novel by Paula Hawkins</p>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-3 col-sm-3" >
                            <p class="price">$29.90</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <button type="submit" class="btn btn-default button-0" > BUY ITEM</button>
                        </div>
                        <div class="col-md-3 col-sm-3" ></div>
                    </div>
                </span>
            </div>
            
            <div class="col-md-3 col-sm-6">
                <span class="thumbnail">
                    <img src="https://i.stack.imgur.com/071TF.jpg" alt="...">
                    <h4>Into the Water</h4>
                    <div class="ratings text-center">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p class="text-center">Novel by Paula Hawkins</p>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-3 col-sm-3" >
                            <p class="price">$29.90</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <button type="submit" class="btn btn-default button-0" > BUY ITEM</button>
                        </div>
                        <div class="col-md-3 col-sm-3" ></div>
                    </div>
                </span>
            </div>
            <div class="col-md-3 col-sm-6">
                <span class="thumbnail">
                    <img src="https://upload.wikimedia.org/wikipedia/en/6/62/Kite_runner.jpg" alt="...">
                    <h4>Into the Water</h4>
                    <div class="ratings text-center">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p class="text-center">Novel by Paula Hawkins</p>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-3 col-sm-3" >
                            <p class="price">$29.90</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <button type="submit" class="btn btn-default button-0" > BUY ITEM</button>
                        </div>
                        <div class="col-md-3 col-sm-3" ></div>
                    </div>
                </span>
            </div>
            <div class="col-md-3 col-sm-6">
                <span class="thumbnail">
                    <img src="https://images-na.ssl-images-amazon.com/images/I/A1HGWCA36hL.jpg" alt="...">
                    <h4>Into the Water</h4>
                    <div class="ratings text-center">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p class="text-center">Novel by Paula Hawkins</p>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-3 col-sm-3" >
                            <p class="price">$29.90</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <button type="submit" class="btn btn-default button-0" > BUY ITEM</button>
                        </div>
                        <div class="col-md-3 col-sm-3" ></div>
                    </div>
                </span>
            </div>
            <!-- END PRODUCTS -->
        </div>
    </div> 
    </div>
    
    <!-- random info to fill homepage -->
    <div class="container random">
    
    	<h3 class="text-center" > Next Steps</h3>
        <p class="text-center" style="font-style: italic"> Create an Account, Buy Books, and View Orders Online. </p>
        <hr style="width:80%">
        
        <div class="row next-step">
        	<div class="col-md-1 col-sm-1"></div>
        	<div class="col-md-5 col-sm-5 text-right">
        		<h5>Already a Member?</h5>
        		<p> Sign-in and get started looking through our extensive database!</p>
        		<button class="btn btn-default button-1"><a href="login.html" style="text-decoration:none; color: #232323"> Log In</a></button>
        	</div>
        	
        	<div class="col-md-5 col-sm-5 text-left">
        		<h5>Need an Account?</h5>
        		<p> What are you waiting for? Discover new favorites.</p>
        		<button class="btn btn-default button-1"><a href="register.html" style="text-decoration:none; color: #232323"> Register</a></button>
        	</div>
        	<div class="col-md-1 col-sm-1"></div>
   
    </div>
    </div>

      <!-- Footer -->
      <footer class="footer-distributed">
		<div class="footer-left">
			<h3>Company<span>logo</span></h3>
			<p class="footer-links">
				<a href="home.html">Home</a> �
				<a href="search.html">Search</a> �
				<a href="popular.html">Popular</a> �
				<a href="contact.html">Contact</a> �
				<a href="aboutus.html">About Us</a> �
				<a href="profile.html">Account</a>
			</p>
			<p class="footer-company-name">Books-R-Us &copy; 2017</p>
		</div>
	
		<div class="footer-center">
			<div>
				<i class="fa fa-map-marker"></i>
				<p><span>200 D.W. Brooks Drive </span> Athens, Georgia</p>
			</div>
			<div>
				<i class="fa fa-phone"></i>
				<p>+1 555 123 4567</p>
			</div>
			<div>
				<i class="fa fa-envelope"></i>
				<p><a href="mailto:support@company.com">support@company.com</a></p>
			</div>
		</div>
	
		<div class="footer-right">
			<p class="footer-company-about">
				<span>About the company</span>
				Books-R-Us is a website that allows customers to create 
				an account to be able to purchase books from vendors found on the website.  
			</p>
			<div class="footer-icons">
	
				<a href="#"><i class="fa fa-facebook"></i></a>
				<a href="#"><i class="fa fa-twitter"></i></a>
				<a href="#"><i class="fa fa-linkedin"></i></a>
			    <a href="#"><i class="fa fa-github"></i></a>
			</div>
		</div>
	</footer>
	
	
    </body>
</html>