<?php
    if($_SERVER["REQUEST_METHOD"]== "POST" && !empty($_POST)) {
        // on recupère nos valeurs
        $login = htmlentities(trim($_POST['login']));
        $pass = htmlentities(trim($_POST['password']));
        $role ='';
        if ($login == 'hoteladmin' && $pass == 'miniprojet18') {
            $role = 'Admin';
            //Construction d'un tableau à deux dimensions
            $Personne =  array("login" => $login, "role" => $role);
        } elseif ($login == 'Etud' && $pass == 'etud') {
            $role = 'Etud';
            //Construction d'un tableau à deux dimensions
            $Personne =  array("login" => $login, "role" => $role);
        }

        if (isset($Personne)) {
            session_start();
            $_SESSION['PROFILE'] = $Personne;
            //Redirection vers la pages des livres
            header ("location: index.php");
        } else {
            //Retour à la page login.php
            header ("location: crudlogin.php?error=Utilisateur non identifié");
        }
    } else {
        header ("location: crudlogin.php?error=Pas d'utilisateur");
    }
?>