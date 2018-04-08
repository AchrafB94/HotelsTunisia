<?php
$nom=$_GET["nom"];
$ville=$_GET["ville"];
$con=mysqli_connect("localhost", "achraf18", "achraf18") or die ("Connexion Impossible");
mysqli_select_db($con,"hotelstn") or die ("Connexion Impossible");


if ($ville=="all")
{
	$req =mysqli_query($con,"SELECT id,name,image,etoiles FROM hotels where name like '%".$nom."%'");
}else {

	$req =mysqli_query($con,"SELECT id,name,image,etoiles FROM hotels where name like '%".$nom."%' and gouvernorat='".$ville."'");
}



if (!$req) {
    printf("Error: %s\n", mysqli_error($con));
    exit();
}





while ($row=mysqli_fetch_array($req)) {
$output[]=$row;
}
//on encode en JSON
print(json_encode($output)); mysqli_free_result ($req);
?>