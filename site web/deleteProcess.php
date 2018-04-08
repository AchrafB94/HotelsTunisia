<?php 
  require_once 'database.php'; 
    
  if(!empty($_POST)){ 
    $id= $_POST['id'];
    $DB = new DB();
    $DB->connect(); 
    $sql = "DELETE FROM hotels  WHERE id = ?";
    $DB->query($sql,array($id));
    $DB->disconnect();
  }
?>
    <a href="index.php">Retour à la page d'administration.</a>