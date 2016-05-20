<?php
include("../entite/Fourniseur.php");
$f= new Fourniseur();



	$f->supprimer_fourniseur($_GET['id_f']);
	header("location:../edit_fourniseur.php");

?>

