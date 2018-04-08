<?php 
  $id=0; 
  if(!empty($_GET['id'])){ 
    $id=$_REQUEST['id']; 
  } 
?>
<!DOCTYPE html>

<html lang="en">
  <head>
  <title>Site d'Administration</title>
    <meta charset="utf-8">
   	<link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <div class="row">
        <h3>Supprimer hotel</h3>
      </div>
      <form class="form-horizontal" action="deleteProcess.php" method="post">
        <input type="hidden" name="id" value="<?php echo $id;?>"/>
        Voulez-vous vraiment supprimer cet hotel ?
        <div class="form-actions">
          <button type="submit" class="btn btn-danger">Oui</button>
          <a class="btn" href="index.php">Non</a>
        </div>
      </form>
    </div>
    </div><!-- /container -->
  </body>
</html>