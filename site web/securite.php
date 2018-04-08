<?php
    //Si aucun utilisateur n'est identifié, redirection vers la page login.php
    if (!isset($_SESSION['PROFILE'])) {
        header("location: crudlogin.php");
    }
?>