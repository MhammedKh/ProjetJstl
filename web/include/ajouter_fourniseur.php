<?php
include("../entite/Fourniseur.php");
$f= new Fourniseur();



	$f->ajouter_fourniseur($_GET['nom'],$_GET['adresse'],$_GET['tel'],$_GET['email']);
	header("location:../edit_fourniseur.php");

?>

