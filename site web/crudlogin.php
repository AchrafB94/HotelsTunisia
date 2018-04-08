<?php
    require_once('_header.php');
    //on initialise nos messages d'erreurs;
    $error = '';
    if($_SERVER["REQUEST_METHOD"]== "GET" && !empty($_GET)) {
        // on recupère nos valeurs
        $error = htmlentities(trim($_GET['error']));
    }

?>
<!Doctype html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" action="LoginProcess.php" method="POST">
                <legend>Authentification</legend>
                <?php if(!empty($error)):?>
                    <p class="alert alert-danger"><?php echo $error ;?></p>
                <?php endif;?>
                <div class="form-group">
                    <label class="col-md-2 control-label">Login</label>
                    <div class="col-md-2">
                        <input class="form-control" name="login" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Mot de passe</label>
                    <div class="col-md-2">
                        <input class="form-control" name="password" type="password" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <input class="btn btn-primary" type="submit" value="Login" />
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
