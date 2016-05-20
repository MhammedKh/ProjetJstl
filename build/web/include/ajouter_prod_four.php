<?php
include("../entite/Produit.php");
$p= new Produit();
	$p->ajouter_fou_prod($_GET['id_four'],$_GET['id_prod'],$_GET['prix']);
		header("location:../affiche_prod_four.php?id_f=".$_GET['id_four']);

?>

