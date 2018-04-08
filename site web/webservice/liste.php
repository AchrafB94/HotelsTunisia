<?php
$con=mysqli_connect("localhost", "achraf18", "achraf18") or die ("Connexion Impossible");
mysqli_select_db($con,"hotelstn") or die ("Connexion Impossible");
$req =mysqli_query($con,"SELECT id,name,etoiles,image FROM hotels");
while ($row=mysqli_fetch_array($req)) {
$output[]=$row;
}


print(json_encode($output)); mysqli_free_result ($req);
?>