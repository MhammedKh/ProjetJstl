<?php
include("../entite/Produit.php");
$p= new Produit();
	$p->ajouter_fou_prod($_GET['id_four'],$_GET['id_prod'],$_GET['prix']);
		header("location:../affiche_four_prod.php?id_p=".$_GET['id_prod']);

?>

