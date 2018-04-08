<?php
    session_start();
    session_destroy();
    //Redirection vers la page login.php après avoir libérer les ressources
    header("location:index.php");
?>