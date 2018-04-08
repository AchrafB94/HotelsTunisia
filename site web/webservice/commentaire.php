<?php
$json = file_get_contents('php://input');
$obj = json_decode($json);

$text = $obj->{'commentaire'};
$user = $obj->{'nom'};
$stars = $obj->{'njoom'};
$date = $obj->{'date'};
$idhotel = $obj->{'idhotel'};

try 
{
    $bdd = new PDO('mysql:host=localhost;dbname=hotelstn;charset=utf8', 'achraf18', 'achraf18');
} catch (Exception $e) 
{
    die('Erreur : '.$e->getMessage());
}

$sql = $bdd->prepare(
'INSERT INTO reviews (id, idhotel, text, user, stars, date) VALUES (NULL, :idhotel, :text, :user, :stars, :date)');
    $sql->execute(array(
        'idhotel' => $idhotel,
        'text' => $text,
        'user' => $user,
        'stars' => $stars,
        'date' => $date));

?>