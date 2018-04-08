 <?php 
    require_once 'DB.class.php'; 
    if($_SERVER["REQUEST_METHOD"]== "POST" && !empty($_POST)){ 
    
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
        
        $wifi = $_POST['wifi'];
        $air = $_POST['air'];
        $bar = $_POST['bar'];
        $breakfast = $_POST['breakfast'];
        $pets = $_POST['pets'];
        $pool = $_POST['pool'];
        $parking = $_POST['parking'];
        $child = $_POST['child'];
        $restaurent = $_POST['restaurent'];
        $spa = $_POST['spa'];
        $roomservice = $_POST['roomservice'];
        $laundry = $_POST['laundry'];
        $gym = $_POST['gym'];

		
        //On insère dans la base de données
        $DB = new DB();
        $sql = "INSERT INTO hotels (name,description,image,etoiles,adresse,gouvernorat,num,site,maps_x,maps_y,image2,image3,wifi,air,bar,pool,breakfast,parking,restaurent,child,spa,pets,roomservice,laundry,gym) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        $DB->query($sql, array($nom,$texte,$image,$stars,$adr,$gov,$num,$site,$x,$y,$image2,$image3,$wifi,$air,$bar,$pool,$breakfast,$parking,$restaurent,$child,$spa,$pets,$roomservice,$laundry,$gym));
        $DB->disconnect();
		
    }
        //redirection vers la page
        ?>
        
    <a href="index.php">Retour à la page d'administration.</a>