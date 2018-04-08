<?php
	if (!isset($_SESSION)) {
        if (session_status() == PHP_SESSION_NONE) {
            session_start();
        }
    }
    require_once('_header.php');
	require_once('database.php'); 
    $id = null; 
    if (!empty($_GET['id'])) { //on récupère l'id depuis la page crud.php
        $id = $_REQUEST['id']; 
    } 
    if (null == $id) { //Si l'id est null, on se redirige vers la page article.php
        header("location:hotel.php");
    } else { //on lance la connection et la requete
        $DB = new DB(); 
        $sql = "SELECT * FROM hotels where id =?";
        $hotel = $DB->select($sql, array($id)); // on récupère un tableau contenant un objet
        $hotels = $hotel[0];
        $DB->disconnect();
    }
?>
<!DOCTYPE html>


<head>


<title><?=$hotels->name?> - Hotels Tunisie</title>
 <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY&callback=myMap"></script>
</head>
<body>
    
<br>
<div class="container">
	<div class="row">

			<h1 style="text-transform:uppercase;"><strong><?=$hotels->name?></strong></h1>
			<br>
			<p><?=$hotels->description?></p>

		
			<hr>

			
			
			<h2>Informations</h2>
			<table  class="table table-condensed table-striped no-border title-normal links-color">
				<tr>
					<td>Etoiles</td>
					<td>
            <?php for ($i = 1; $i <= $hotels->etoiles; $i++) { ?>
            <img src="star.png" height="20px" width="20px"> <?php }   ?> 
          </td>
				</tr>				
				<tr>
					<td>Adresse</td>
					<td><?=$hotels->adresse?></td>
				</tr>				
				<tr>
					<td>Gouvernorat</td>
					<td><?=$hotels->gouvernorat?></td>
				</tr>				
				<tr>
					<td>Site</td>
					<td><a href="https://<?=$hotels->site?>"> <?=$hotels->site?></a></td>
				</tr>	
				<tr>
					<td>Telephone</td>
					<td><?=$hotels->num?></td>
				</tr>	


				
			</table>



<div class="container">
  <h2>Gallery</h2>
  <div class="row">
    <div class="col-md-4">
      <div class="thumbnail">
          <img src="<?=$hotels->image?>" alt="Image" style="width:100%">
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
          <img src="<?=$hotels->image2?>" alt="Image2" style="width:100%">

    
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
          <img src="<?=$hotels->image3?>" alt="Image3" style="width:100%">

      </div>
    </div>
  </div>
</div>


<h2>Equipements</h2>
<div class="container">
<?php if ($hotels->wifi == 1)  { ?> <img src="wifi.png" height="15px" width="15px"> Free Wi-fi <br>  <?php } ?>
<?php if ($hotels->air == 1)  { ?> <img src="air.png" height="15px" width="15px"> Air-conditioned<br>  <?php } ?>
<?php if ($hotels->bar == 1)  { ?> <img src="bar.png" height="15px" width="15px"> Bar <br> <?php } ?>
<?php if ($hotels->breakfast == 1)  { ?> <img src="breakfast.png" height="15px" width="15px"> Free Breakfast<br>  <?php } ?>
<?php if ($hotels->child == 1)  { ?> <img src="child.png" height="15px" width="15px"> Child  Friendly<br>  <?php } ?>
<?php if ($hotels->gym == 1)  { ?> <img src="gym.png" height="15px" width="15px"> Gym <br> <?php } ?>
<?php if ($hotels->laundry == 1)  { ?> <img src="laundry.png" height="15px" width="15px"> Laundry Service<br>  <?php } ?>
<?php if ($hotels->parking == 1)  { ?> <img src="parking.png" height="15px" width="15px"> Paid Parking<br>  <?php } ?>
<?php if ($hotels->pets == 1)  { ?> <img src="pets.png" height="15px" width="15px"> Pets Allowed <br><?php } ?>
<?php if ($hotels->pool == 1)  { ?> <img src="pool.png" height="15px" width="15px"> Pool <br> <?php } ?>
<?php if ($hotels->restaurent == 1)  { ?> <img src="restaurent.png" height="15px" width="15px"> Restaurant <br> <?php } ?>
<?php if ($hotels->roomservice == 1)  { ?> <img src="roomservice.png" height="15px" width="15px"> Room Service<br>  <?php } ?>
<?php if ($hotels->spa == 1)  { ?> <img src="spa.png" height="15px" width="15px"> Spa<br>  <?php } ?>
</div>
<br>


<h2>Google Maps</h2>

<div id="googleMap" style="width:100%;height:300px;"></div>

<script>
function myMap() {
var mapProp= {
    center:new google.maps.LatLng(<?=$hotels->maps_x?>,<?=$hotels->maps_y?>),
    zoom:17,
};
var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAhgtyjLmd5lgLW7ss-TygrcHOa_x230E8&callback=myMap"></script>


			
			
			
			<br>
			
		
</body>
</html>