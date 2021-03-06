<!DOCTYPE html>
<html>
<head>
    <title>General Bookstore</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/main2.css">
    <link rel="stylesheet" href="css/footer.css">
  	<link rel="stylesheet" href="css/register.css">
	<link rel="stylesheet" href="css/register2.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/loginAuth.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet" type="text/css">
    
</head>
<body>
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
	
        <!-- form section -->
        <div id="main-wrapper">
        	<div class="container-fluid">
        		<div class="row">
        			
        			<!-- Left Side -->
        			<div class="col-md-6 left-side">
        				<header style="background-color: inherit;">
        					<span> Already a Member?</span>
        					<h3> Log In<br> Buy Books</h3>
        				</header>
        			</div>
        			
        			 <h5>Welcome Back</h5>
            <#if failedLogin??>
			Login failed! Please make sure to input the correct login information.
			</#if>
			<#if registerSuccessful??>
			Registration successful!
			</#if>
            <hr>
        			<form id="Servlet" class="" name="contact-form" method="post" action="Servlet">
        			        			
	        			<!-- Right side -->
	        			<div class="col-md-6 right-side">
	        				
	        				<span class = "input input--hoshi">
	        					<input class="input__field input__field--hoshi" type="text" name="username" id="username">
	        					<label class="input__label input__label--hoshi input__label--hoshi-color-3" for="username">
	        						<span class="input__label-content input__label-content--hoshi"> Username</span>
	        					</label>
	        				</span>
	   
	        				<span class = "input input--hoshi">
	        					<input class="input__field input__field--hoshi" type="password" name="password" id="password">
	        					<label class="input__label input__label--hoshi input__label--hoshi-color-3" for="password">
	        						<span class="input__label-content input__label-content--hoshi"> Password</span>
	        					</label>
	        				</span>     				
	        				
	        				<div class="cta">
	        					<button name="login" type="submit" class="btn btn-primary pull-left"> Sign In</button>
	        					<span>
	        						<a href="register.html"> I am not a member</a>
	        					</span>
	        				</div>
	        				
	        				<ul class="social list-inline">
	        					<li><a href="#">Facebook</a></li>
	        					<li><a href="#">Twitter</a></li>
	        					<li><a href="#">Linkedin</a></li>
	        				</ul>        				   				
	        				
	        			</div>  
        			</form>    			
        		 </div>
        	</div>       
        </div> <!-- end #main-wrapper -->
        
        
  
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
		
		<!-- script -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="js/scripts.js"></script>
		<script src="js/classie.js"></script>
		
		<script>
			  (function() {
			    if (!String.prototype.trim) {
			      (function() {
			        // Make sure we trim BOM and NBSP
			        var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
			        String.prototype.trim = function() {
			          return this.replace(rtrim, '');
			        };
			      })();
			    }
	
			    [].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
			      // in case the input is already filled..
			      if( inputEl.value.trim() !== '' ) {
			        classie.add( inputEl.parentNode, 'input--filled' );
			      }
	
			      // events:
			      inputEl.addEventListener( 'focus', onInputFocus );
			      inputEl.addEventListener( 'blur', onInputBlur );
			    } );
	
			    function onInputFocus( ev ) {
			      classie.add( ev.target.parentNode, 'input--filled' );
			    }
	
			    function onInputBlur( ev ) {
			      if( ev.target.value.trim() === '' ) {
			        classie.remove( ev.target.parentNode, 'input--filled' );
			      }
			    }
			  })();
		</script>
</body>
</html>