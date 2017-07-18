<!DOCTYPE html>
<html lang="en">

<head>
    <title>General Bookstore</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/main2.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/style.css" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Slab:300" rel="stylesheet">
</head>

<body>

	<!-- Navigation -->
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

	<!-- admin area -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-4 col-sm-6 col-xs-12">
                    <div class="white-box analytics-info">
                        <h3 class="box-title">TOTAL USERS </h3><span>689</span> 
                       
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 col-xs-12">
                    <div class="white-box analytics-info">
                        <h3 class="box-title">TOTAL VENDOR</h3><span>20</span>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 col-xs-12">
                    <div class="white-box analytics-info">
                        <h3 class="box-title">TOTAL SALES</h3><span>1652</span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-sm-6 col-xs-12">
                    <div class="white-box analytics-info">
                        <a href="#user"><h3 class="box-title">MANAGE USERS</h3> </a>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 col-xs-12">
                    <div class="white-box analytics-info">
                        <a href="#books"><h3 class="box-title">MANAGE BOOKS</h3></a>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 col-xs-12">
                    <div class="white-box analytics-info">
                        <h3 class="box-title">REPORTS</h3>
                    </div>
                </div>
            </div>

            <!-- ============================================================== -->
            <!-- table -->
            <!-- ============================================================== -->
            <div class="row">
                <div class="col-md-12 col-lg-12 col-sm-12">
                    <div class="white-box">
                        <div class="col-md-3 col-sm-4 col-xs-6 pull-right">
                            <select class="form-control pull-right row b-none">
                                <option>March 2017</option>
                                <option selected>April 2017</option>
                                <option>May 2017</option>
                                <option>June 2017</option>
                                <option>July 2017</option>
                            </select>
                        </div>
                        <h3 class="box-title">Recent sales</h3>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>USERNAME</th>
                                        <th>STATUS</th>
                                        <th>DATE</th>
                                        <th>PRICE</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td class="txt-oflo">chan876</td>
                                        <td>DELIVERED</td>
                                        <td class="txt-oflo">April 18, 2017</td>
                                        <td><span class="text-success">$150.64</span></td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td class="txt-oflo">ssmith</td>
                                        <td>SHIPPED</td>
                                        <td class="txt-oflo">April 19, 2017</td>
                                        <td><span class="text-info">$120</span></td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td class="txt-oflo">aalex</td>
                                        <td>SHIPPED</td>
                                        <td class="txt-oflo">April 19, 2017</td>
                                        <td><span class="text-info">$60</span></td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td class="txt-oflo">w.jump</td>
                                        <td>CANCELLED</td>
                                        <td class="txt-oflo">April 20, 2017</td>
                                        <td><span class="text-danger">$24</span></td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td class="txt-oflo">k.wilson</td>
                                        <td>DELIVERED</td>
                                        <td class="txt-oflo">April 21, 2017</td>
                                        <td><span class="text-success">$94.25</span></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!--User Table-->    
            <div class="row">
                <div class="col-md-12 col-lg-12 col-sm-12">
                    <div class="white-box">
                        <h3 class="box-title">Manage Users</h3>
                        <div class="table-responsive">
                            <table id="user" class="table">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FIRST NAME</th>
                                        <th>LAST NAME</th>
                                        <th>USERNAME</th>
                                        <th>EMAIL</th>
                                        <th>PASSWORD</th>
                                        <th>EDIT/DELETE</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>Chanice</td>
                                        <td>Campbell</td>
                                        <td>chan876</td>
                                        <td> chan876@uga.edu</td>
                                        <td> ***** </td>
                                        <td class="actions" data-th="">
                                            <a href="edit.html" class="btn btn-info btn-sm"><i class="fa fa-pencil"></i></a>
                                            <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>								
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>James</td>
                                        <td>Smith</td>
                                        <td>jsmith</td>
                                        <td> jsmith@gmail.com</td>
                                        <td> *********** </td>
                                        <td class="actions" data-th="">
                                            <a href="edit.html" class="btn btn-info btn-sm"><i class="fa fa-pencil"></i></a>
                                            <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>								
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>Kate</td>
                                        <td>Wilson</td>
                                        <td>kwilson</td>
                                        <td> kwilson@yahoo.com</td>
                                        <td> ******* </td>
                                        <td class="actions" data-th="">
                                            <a href="edit.html" class="btn btn-info btn-sm"><i class="fa fa-pencil"></i></a>
                                            <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>								
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>Lewis</td>
                                        <td>Pi</td>
                                        <td>lpi</td>
                                        <td> lpi@gmail.com</td>
                                        <td> ************** </td>
                                        <td class="actions" data-th="">
                                            <a href="edit.html" class="btn btn-info btn-sm"><i class="fa fa-pencil"></i></a>
                                            <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>								
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>Monrow</td>
                                        <td>Wilson</td>
                                        <td>mwilson</td>
                                        <td> mwilson@hotmail.com</td>
                                        <td> ******* </td>
                                        <td class="actions" data-th="">
                                            <a href="edit.html" class="btn btn-info btn-sm"><i class="fa fa-pencil"></i></a>
                                            <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>								
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!--Book Table-->    
            <div class="row">
                <div class="col-md-12 col-lg-12 col-sm-12">
                    <div class="white-box">
                        <h3 class="box-title">Manage Books</h3>
                        <div class="table-responsive">
                            <table id="books" class="table">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>BOOK NAME</th>
                                        <th>LAST NAME</th>
                                        <th>USERNAME</th>
                                        <th>EMAIL</th>
                                        <th>PASSWORD</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>Chanice</td>
                                        <td>Campbell</td>
                                        <td>chan876</td>
                                        <td> chan876@uga.edu</td>
                                        <td> ***** </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Chanice</td>
                                        <td>Campbell</td>
                                        <td>chan876</td>
                                        <td> chan876@uga.edu</td>
                                        <td> ***** </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Chanice</td>
                                        <td>Campbell</td>
                                        <td>chan876</td>
                                        <td> chan876@uga.edu</td>
                                        <td> ***** </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div> <!--End of tables -->
            
        </div>
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
