<?php
		    if (!isset($_SESSION)) {
        if (session_status() == PHP_SESSION_NONE) {
            session_start();
        }
    }
    require_once('_header.php');
	require_once('database.php');
?>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un hotel</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" method="post" action="addProcess.php">
			<br>
                <legend>Ajouter un hotel</legend>
                <div class="form-group">
                    <label class="col-md-2 control-label">Nom</label>
                    <div class="col-md-6">
                        <input class="form-control" name="titre" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Etoiles (1 - 5)</label>
                    <div class="col-md-2">
                        <input class="form-control" name="stars" type="number" min="1" max="5"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Lien image principale</label>
                    <div class="col-md-6">
                        <input class="form-control" name="image" type="text" />
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
                        <textarea class="form-control" name="texte" rows="8" cols="100"></textarea>
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
                              <option value="Djerba">Djerba</option>
                               <option value="Hammamet">Hammamet</option>
                             <option value="Tabarka">Tabarka</option>
                             <option value="Sousse">Sousse</option>
                             <option value="Nabeul">Nabeul</option>
                             <option value="Monastir">Monastir</option>
                             <option value="Bizerte">Bizerte</option>
                             <option value="Douz">Douz</option>
                             <option value="Tozeur">Tozeur</option>
                             <option value="Aïn Draham">Aïn Draham</option>
                            
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
                    
                                      
                     <label class="col-md-4 control-label">Equipements</label>
                    <div class="col-md-3">
                        <input type='hidden' value='0' name='wifi'>
                        <input type='hidden' value='0' name='air'>
                        <input type='hidden' value='0' name='bar'>
                        <input type='hidden' value='0' name='breakfast'>
                        <input type='hidden' value='0' name='child'>
                        <input type='hidden' value='0' name='gym'>
                        <input type='hidden' value='0' name='parking'>
                        <input type='hidden' value='0' name='pets'>
                        <input type='hidden' value='0' name='laundry'>
                        <input type='hidden' value='0' name='restaurent'>
                        <input type='hidden' value='0' name='roomservice'>
                        <input type='hidden' value='0' name='spa'>
                        <input type='hidden' value='0' name='pool'>
                        
                        <input type="checkbox" name="wifi" value="1"> Free Wifi<br>
                        <input type="checkbox" name="air" value="1" checked> Air Conditioned<br>
                        <input type="checkbox" name="bar" value="1"> Bar<br>
                        <input type="checkbox" name="breakfast" value="1"> breakfast free<br>
                        <input type="checkbox" name="child" value="1"> child <br>
                        <input type="checkbox" name="gym" value="1"> gym <br>
                        <input type="checkbox" name="laundry" value="1"> laundry <br>
                        <input type="checkbox" name="parking" value="1"> free parking <br>
                        <input type="checkbox" name="pets" value="1"> pets <br>
                        <input type="checkbox" name="pool" value="1"> pool<br>
                        <input type="checkbox" name="restaurent" value="1"> restaurent<br>
                        <input type="checkbox" name="roomservice" value="1"> room service<br>
                        <input type="checkbox" name="spa" value="1"> spa<br>
                        
                        
                    </div>    
                    
                    
                </div>
							
                <div class="form-actions">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="submit" class="btn btn-success" name="submit" value="Ajouter">
                        <a class="btn" href="index.php">Retour</a>
                    </div>
                </div>
            </form>
        </div>
        <br>
    </body>
</html>