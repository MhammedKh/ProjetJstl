<?php
include("../entite/Fourniseur.php");
$f= new Fourniseur();

	
	$f->modifier_fourniseur( $_GET['id_four'],$_GET['nom'],$_GET['adresse'],$_GET['tel'],$_GET['email']);
	header("location:../edit_fourniseur.php");

?>

