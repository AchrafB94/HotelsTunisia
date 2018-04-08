<?php 
		    if (!isset($_SESSION)) {
        if (session_status() == PHP_SESSION_NONE) {
            session_start();
        }
    }
    require_once('_header.php');
    require_once 'database.php'; 
    $id = null; 
    if ( !empty($_GET['id'])) { //on récupère l'id depuis la page crud.php
        $id = $_REQUEST['id']; 
    } 

    if ( null==$id ) { 
        //Si l'id est null, on se redirige vers la page crud.php
        header("Location: hotel.php");
    }else {
        $DB = new DB();
        $sql = "SELECT * FROM hotels where id = ?";
        $hotel = $DB->select($sql,array($id)); //on récupère un tableau contenant un objet
        $hotels = $hotel[0];

        $nom      = $hotels->name;
        $stars     = $hotels->etoiles;
        $image       = $hotels->image;
        $texte    = $hotels->description;

        $DB->disconnect();
    }
?>








<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier un hotel - Administration</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
<div class="container">
            <form class="form-horizontal" method="post" action="addProcess.php">
            <br>
                <legend>Modifier un hotel</legend>
                <div class="form-group">
                    <label class="col-md-2 control-label">Nom</label>
                    <div class="col-md-6">
                        <input class="form-control" name="titre" type="text"  value="<?php echo!empty($nom) ? $nom : ''; ?>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Etoiles (1 - 5)</label>
                    <div class="col-md-2">
                        <input class="form-control" name="stars" type="number" min="1" max="5" value="<?php echo!empty($stars) ? $stars : ''; ?>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Lien image principale</label>
                    <div class="col-md-6">
                        <input class="form-control" name="image" type="text"  value="<?php echo!empty($image) ? $image : ''; ?>"/>
                    </div>
                </div>
                    <div class="form-group">
                    <label class="col-md-2 control-label">Lien image 2</label>
                    <div class="col-md-6">
                        <input class="form-control" name="image2" type="text" />
                    </div>
                </div>
                    <div class="form-group">
                    <label class="col-md-2 control-label">Lien image 3</label>
                    <div class="col-md-6">
                        <input class="form-control" name="image3" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Description</label><br />
                    <div class="col-md-6">
                        <textarea class="form-control" name="texte" rows="8" cols="100"  value="<?php echo!empty($texte) ? $texte : ''; ?>"></textarea>
                    </div>
                </div>
                
                
                <legend>Informations</legend>
                <div class="form-group">
                    <label class="col-md-2 control-label">Adresse</label>
                    <div class="col-md-6">
                        <input class="form-control" name="adr" type="text" />
                    </div>
                    <label class="col-md-2 control-label">Ville</label>
                    <div class="col-md-2">
                        <select name="gov" class="form-control">
                             <option value="Tunis">Tunis</option>
                             <option value="Sfax">Sfax</option>
                             <option value="Sousse">Sousse</option>
                             <option value="Nabeul">Nabeul</option>
                             <option value="Monastir">Monastir</option>
                             <option value="Bizerte">Bizerte</option>
                             <option value="Kebili">Kebili</option>
                             <option value="Tozeur">Tozeur</option>
                             <option value="Tozeur">Hammamet</option>
                        </select>
                    </div>
                    <label class="col-md-2 control-label">Numero telephone</label>
                    <div class="col-md-3">
                        <input class="form-control" name="num" type="text" />
                    </div>
                    <label class="col-md-2 control-label">Site web</label>
                    <div class="col-md-3">
                        <input class="form-control" name="site" type="text" />
                    </div>
                    <label class="col-md-4 control-label">Coordonnees maps: X - latitude</label>
                    <div class="col-md-3">
                        <input class="form-control" name="x" type="text" />
                    </div>
                     <label class="col-md-4 control-label">Coordonnees maps: Y - longitude</label>
                    <div class="col-md-3">
                        <input class="form-control" name="y" type="text" />
                    </div>                     
                </div>
                            
                <div class="form-actions">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="submit" class="btn btn-success" name="submit" value="Ajouter">
                        <a class="btn" href="crud.php">Retour</a>
                    </div>
                </div>
            </form>
        </div>
        <br>
    </body>
</html>