<!DOCTYPE html>
<html>
    <head>
        <title>General Bookstore</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/main2.css">
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="css/edit.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css"> 
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet"> 
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
								<li><a href="Servlet?logout"><i class="fa fa-lock"></i> Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<div class="outer-wrapper">
	<div class="container">
            <div class="row edit-row">
            	
                <form class="form-horizontal" method="post" action="Servlet">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                	<h3> Edit your information </h3>
                	<p>Did you recently move? Need to change your password? Update profile!</p>
                	<p>			<#if editProfileError??>
			Error! Make sure you enter in your correct old password in order to modify your profile information.
			</#if></p>
                	<hr>
                	<!-- Personal Info -->
                	
                	<div class="all-info">            
                       <h4>Basic Information</h4>
                       <div class="form-group">
                           <div class="col-md-12"><strong>First Name: </strong></div>
                           <div class="col-md-12">
                               <input type="text" name="fname" class="form-control" value="Chanice" />
                           </div>
                       </div>
                       <div class="form-group">
                           <div class="col-md-12"><strong>Last Name: </strong></div>
                           <div class="col-md-12">
                               <input type="text" name="lname" class="form-control" value="Campbell" />
                           </div>
                       </div>
                       <div class="form-group">
                           <div class="col-md-12"><strong>Username: </strong></div>
                           <div class="col-md-12">
                               <input type="text" name="username" class="form-control" value="chan876"/>
                           </div>
                       </div>
                       <div class="form-group">
                           <div class="col-md-12"><strong>Email:</strong></div>
                           <div class="col-md-12">
                               <input type="email" name="email" class="form-control" value="chan876@uga.edu" />
                           </div>
                       </div>
                       <div class="form-group">
                           <div class="col-md-12"><strong>Old Password:</strong></div>
                           <div class="col-md-12">
                               <input type="password" name="old-password" class="form-control" value="admin" />
                           </div>
                       </div>
                       <div class="form-group">
                           <div class="col-md-12"><strong>New Password:</strong></div>
                           <div class="col-md-12">
                               <input type="password" name="new-password" class="form-control" value="admin" />
                           </div>
                       </div>
                      
                                          
                    <!-- Shipping Address -->   
                     <h4> Shipping Address</h4>              
                     <div class="form-group">
                         <div class="col-md-12"><strong>Street Address:</strong></div>
                         <div class="col-md-12">
                             <input type="text" name="address" class="form-control" value="000 Eclipse Ave." />
                         </div>
                     </div>
                     <div class="form-group">
                         <div class="col-md-12"><strong>City:</strong></div>
                         <div class="col-md-12">
                             <input type="text" name="city" class="form-control" value="Athens" />
                         </div>
                     </div>
                     <div class="form-group">
                         <div class="col-md-12"><strong>State:</strong></div>
                         <div class="col-md-12">
                             <input type="text" name="state" class="form-control" value="GA" />
                         </div>
                     </div>
                     <div class="form-group">
                         <div class="col-md-12"><strong>Zip / Postal Code:</strong></div>
                         <div class="col-md-12">
                             <input type="text" name="zip_code" class="form-control" value="30605" />
                         </div>
                     </div>
                
                    <!--SHIPPING METHOD END-->
                    <!--CREDIT CART PAYMENT-->
                    <h4>Payment Method</h4>                       
                    <div class="form-group">
                        <div class="col-md-12"><strong>Card Type:</strong></div>
                        <div class="col-md-12">
                            <select id="CreditCardType" name="CreditCardType" class="form-control">
                                <option value="5">Visa</option>
                                <option value="6">MasterCard</option>
                                <option value="7">American Express</option>
                                <option value="8">Discover</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Credit Card Number:</strong></div>
                        <div class="col-md-12"><input type="text" class="form-control" name="car_number" value="4532 0446 1135 6103" /></div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Card CVV:</strong></div>
                        <div class="col-md-12"><input type="text" class="form-control" name="car_code" value="620" /></div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <strong>Expiration Date:</strong>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" name="car_month">
                                <option value="">Month</option>
                                <option value="01">01</option>
                                <option value="02">02</option>
                                <option value="03">03</option>
                                <option value="04">04</option>
                                <option value="05" selected>05</option>
                                <option value="06">06</option>
                                <option value="07">07</option>
                                <option value="08">08</option>
                                <option value="09">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                        </select>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" name="car_year">
                                <option value="">Year</option>
                                <option value="2015">2015</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019" selected>2019</option>
                                <option value="2020">2020</option>
                                <option value="2021">2021</option>
                                <option value="2022">2022</option>
                        </select>
                        </div>
                    </div>
                                     
                    </div>
                    <!--CREDIT CART PAYMENT END-->
                </div>
                <div class="col-lg-2"></div>
                
			    <div class="row">
					<div class="col-lg-5"></div>
					<div class="col-lg-1"> 
						<a href="profile.html" class="btn btn-sm btn-default"> Cancel</a>
					</div>
					<div class="col-lg-1"> 
						<!-- <a href="profile.html" class="btn btn-sm btn-default"> Confirm</a> -->
						<button name="editProfile" type="submit" class="btn btn-sm btn-default"> Confirm</button>
		
					</div>
						<div class="col-lg-5"></div>
			    </div>
                </form>
            </div>
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
