<?php
	class DB {
		private $host = 'localhost';
		private $username = 'achraf18';
		private $password = 'achraf18';
		private $database = 'hotelstn';
		private $port = 3306;

		private $pdo = null;

		public function __construct($host = null, $username = null,
			$password = null, $database = null, $port = null) {
			if ($host != null) {
				$this->host = $host;
				$this->username = $username;
				$this->password = $password;
				$this->database = $database;
				$this->port = $port;
			}

			try {
				$this->pdo = new PDO ('mysql:host='.$this->host.';port='.$this->port.';dbname='.$this->database, $this->username, $this->password, 
					array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES UTF8',
						PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION, 
						PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_OBJ
						));
			}catch(PDOException $e) {
				die ('Impossible de se connecter à la base de données');
			}
		}
		public function query($sql, $params = false) {
			if ($params) {
				$req = $this->pdo->prepare($sql);
				$req->execute($params);
			} else {
				$req = $this->pdo->query($sql);
			}
			return $req;
		}
		public function lastInsertId() {
			return $this->pdo->lastInsertId();
		}
		
		public function select($sql, $data = array()) {
			$req = $this->pdo->prepare($sql);
			$req->execute($data);
			return $req->fetchAll(PDO::FETCH_OBJ);
		}
		
		public function connect() { 
			if ($this->db == null) { 
				try { 
					$this->db = new PDO ("mysql:host=".$this->host.";port=".$this->port.";"."dbname=".$this->database, $this->username, 
						$this->password);

					$this->db->query('SET NAMES utf8');
                    $this->db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

				} catch(PDOException $e) { 
					die($e->getMessage()); 
        		}
       		}
    	}
		
		public function disconnect() {
        	$this->db = null;
    	}
		
	}
?>