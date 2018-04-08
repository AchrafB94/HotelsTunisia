<?php
$id=$_GET["id"];
$con=mysqli_connect("localhost", "achraf18", "achraf18") or die ("Connexion Impossible");
mysqli_select_db($con,"hotelstn") or die ("Connexion Impossible");
$req =mysqli_query($con,"SELECT * FROM reviews where idhotel=".$id);

while ($row=mysqli_fetch_array($req)) {
$output[]=$row;
}
print(json_encode($output));
mysqli_free_result ($req);
?>