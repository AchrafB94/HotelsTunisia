<?php
    require 'database.php'; 
    $id = null; 
    if ( !empty($_GET['id'])) { //on récupère l'id depuis la page livres.php
        $id = $_REQUEST['id']; 
    } 
    if ( null==$id ) { 
        //Si l'id est null, on se redirige vers la page livres.php
        header("Location: crud.php");
    } 
    if($_SERVER["REQUEST_METHOD"]== "POST" && !empty($_POST))
    { 
        // on recupère nos valeurs 
        $nom = htmlentities(trim($_POST['titre'])); 
        $stars=htmlentities(trim($_POST['stars'])); 
        $image=htmlentities(trim($_POST['image'])); 
        $image2=htmlentities(trim($_POST['image2'])); 
        $image3=htmlentities(trim($_POST['image3'])); 
        $texte = htmlentities(trim($_POST['texte']));

        $adr = htmlentities(trim($_POST['adr'])); 
        $gov = htmlentities(trim($_POST['gov'])); 
        $num = htmlentities(trim($_POST['num'])); 
        $site = htmlentities(trim($_POST['site'])); 
        $x = htmlentities(trim($_POST['x']));
        $y = htmlentities(trim($_POST['y']));

        //on modifie la base de données
        $DB = new DB();
        $DB->connect(); 
        $sql = "INSERT INTO hotels (name,description,image,etoiles,adresse,gouvernorat,num,site,maps_x,maps_y,image2,image3) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        $DB->query($sql, array($nom,$texte,$image,$stars,$adr,$gov,$num,$site,$x,$y,$image2,$image3));
        $DB->disconnect();
        //On redirige vers la page livres.php
        header("Location: crud.php");
    }
?>