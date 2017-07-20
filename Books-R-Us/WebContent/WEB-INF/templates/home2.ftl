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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
        
    </head>

    <body>
    
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
									<li><a href="login.html"><i class="fa fa-lock"></i> Login</a></li>
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

    <!-- Search bar -->
        <div class="dark">
            <form>
                <span class="icon"><i class="fa fa-search"></i></span>
                <input type="text" class="search rounded" placeholder="Search...">
            </form>            
        </div>

    <!-- best seller section -->
        <div class="border">
            <span style="font-size: 20px; background-color: white; padding: 0 15px;">
                Best Sellers 
            </span>
        </div>

        <div class="container">
        <div class="row">
            <!-- BEGIN PRODUCTS -->
            <div class="col-md-3 col-sm-6">
                <span class="thumbnail">
                    <img src="images/into-water.jpg" alt="...">
                    <h4>Into the Water</h4>
                    <div class="ratings">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. </p>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <p class="price">$29.90</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <button class="btn btn-default" > BUY ITEM</button>
                        </div>
                        
                    </div>
                </span>
            </div>
            <div class="col-md-3 col-sm-6">
                <span class="thumbnail">
                    <img src="images/into-water.jpg" alt="...">
                    <h4>Into the Water</h4>
                    <div class="ratings">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. </p>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <p class="price">$29.90</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <button class="btn btn-default" > BUY ITEM</button>
                        </div>
                        
                    </div>
                </span>
            </div>
            <div class="col-md-3 col-sm-6">
                <span class="thumbnail">
                    <img src="images/into-water.jpg" alt="...">
                    <h4>Into the Water</h4>
                    <div class="ratings">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. </p>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <p class="price">$29.90</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <button class="btn btn-default" > BUY ITEM</button>
                        </div>
                        
                    </div>
                </span>
            </div>
            <div class="col-md-3 col-sm-6">
                <span class="thumbnail">
                    <img src="images/into-water.jpg" alt="...">
                    <h4>Into the Water</h4>
                    <div class="ratings">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. </p>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <p class="price">$29.90</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <button class="btn btn-default" > BUY ITEM</button>
                        </div>
                        
                    </div>
                </span>
            </div>
            <!-- END PRODUCTS -->
        </div>
    </div> 

          <!-- best seller section -->
        <div class="border">
            <span style="font-size: 20px; background-color: white; padding: 0 15px;">
                Other Products 
            </span>
        </div>

        

        <!-- Footer -->
        <footer class="footer-distributed">
			<div class="footer-left">
				<h3>Company<span>logo</span></h3>
				<p class="footer-links">
					<a href="home.html">Home</a>�
					<a href="search.html">Search</a>�
					<a href="popular.html">Popular</a>�
					<a href="contact.html">Contact</a>�
					<a href="aboutus.html">About Us</a>�
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
					<p>+1 555 123456</p>
				</div>
				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:support@company.com">support@company.com</a></p>
				</div>
			</div>

			<div class="footer-right">
				<p class="footer-company-about">
					<span>About the company</span>
					Lorem ipsum dolor sit amet, consectateur adispicing elit. Fusce euismod convallis velit, eu auctor lacus vehicula sit amet.
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