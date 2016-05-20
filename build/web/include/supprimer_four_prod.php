<?php
include("../entite/Produit.php");
$p= new Produit();


	$p->supprimer_fou_prod($_GET['id_f'],$_GET['id_p']);
	header("location:../affiche_four_prod.php?id_p=".$_GET['id_p']);

?>

