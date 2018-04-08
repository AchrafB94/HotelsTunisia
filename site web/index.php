<?php
	    if (!isset($_SESSION)) {
        if (session_status() == PHP_SESSION_NONE) {
            session_start();
        }
    }
	require_once('database.php');
	require_once("securite.php");
    require_once('_header.php');
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Site d'Administration - Hotels Tunisie</title>

    </head>
    <body>








        <div class="container">
            
            <center><img src="banner.jpg"/>
            <h1>Site d'administration</h1>
            <hr>
            </center>
            
            <div class="row">
			<br>
                <a href="add.php" class="btn btn-danger">Ajouter un hotel</a>
            </div>
            <div class="row">
                <div class="table-responsive">
                    <table class="table table-bordered">
                    <thead>
                        <th>Titre</th>
                        <th colspan="3">Actions</th>
                    </thead>
                    <tbody>
                        <?php require_once ('DB.class.php'); //on inclut notre fichier de connection
                        $DB = new DB(); //on se connecte à la base
                        $sql = 'SELECT * FROM hotels ORDER BY id DESC';//on formule notre requete
                        $hotel = $DB->select($sql);
                        //on parcourt notre tableau de livres
                        foreach ($hotel as $hotel) : ?>
                            <tr>
                                <td><?=$hotel->name?></td>
                                <td><a class="btn btn-danger" href="hotel.php?id=<?=$hotel->id?>">Lire</a></td>
                                <td><a class="btn btn-danger" href="update.php?id=<?=$hotel->id?>">Modifier</a></td>
                                <td><a class="btn btn-danger" href="delete.php?id=<?=$hotel->id?>">Supprimer</a></td>
                            </tr>
                        <?php endforeach;
                            $DB->disconnect(); //on se deconnecte de la base
                        ?>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
		<center><a href="crudlogout.php">Logout</a></center>
    </body>
</html>
